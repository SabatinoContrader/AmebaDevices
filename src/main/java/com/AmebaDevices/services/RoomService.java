package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.FloorConverter;
import com.AmebaDevices.converter.RoomConverter;
import com.AmebaDevices.converter.TreeFloorConverter;
import com.AmebaDevices.converter.TreeRoomConverter;
import com.AmebaDevices.dao.ItemDAO;
import com.AmebaDevices.dao.RoomDAO;
import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.dto.TreeFloorDTO;
import com.AmebaDevices.dto.TreeRoomDTO;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.Room;

@Service
public class RoomService {

	private RoomDAO roomdao;
	private ItemDAO itemdao;
	private ItemService itemService;

	@Autowired
	public RoomService(RoomDAO roomdao, ItemDAO itemdao, ItemService itemService) {
		this.roomdao = roomdao;
		this.itemdao=itemdao;
		this.itemService = itemService;
	}

	public void delete(RoomDTO room) {
		Room r= RoomConverter.convertToRoom(room);
		List<Item> list= itemdao.findByRoom(r);
		for(Item item: list){
			itemdao.delete(item);
		}
		roomdao.delete(r);

	}

	public RoomDTO insertRoom(RoomDTO f) {
		return RoomConverter.convertToDto(this.roomdao.save(RoomConverter.convertToRoom(f)));
	}

	public void update(RoomDTO f) {
		if (roomdao.findOne(f.getId()) != null)
			this.roomdao.save(RoomConverter.convertToRoom(f));

	}

	public List<RoomDTO> getAllByFloor(FloorDTO f) {
		List<Room> rooms = (List<Room>) roomdao.findByFloor(FloorConverter.convertToFloor(f));
		List<RoomDTO> toReturn= new ArrayList<>();
		rooms.forEach(r->toReturn.add(RoomConverter.convertToDto(r)));
		return toReturn;
	}
	
	public List<TreeRoomDTO> getAllTreeByFloor(TreeFloorDTO f) {
		List<Room> rooms = (List<Room>) roomdao.findByFloor(TreeFloorConverter.convertToFloor(f));
		List<TreeRoomDTO> toReturn= new ArrayList<>();
		rooms.forEach(room-> {
			TreeRoomDTO treeRoom = TreeRoomConverter.convertToDTO(room);
			treeRoom.setItems(itemService.getAllTreeItem(treeRoom));
			toReturn.add(treeRoom);
		});
		return toReturn;
	}

	public RoomDTO findByPrimaryKey(long id) {
		return RoomConverter.convertToDto(this.roomdao.findOne(id));
	}

}