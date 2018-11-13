package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.ItemConverter;
import com.AmebaDevices.converter.RoomConverter;
import com.AmebaDevices.converter.TreeItemConverter;
import com.AmebaDevices.converter.TreeRoomConverter;
import com.AmebaDevices.dao.BuildingDAO;
import com.AmebaDevices.dao.FloorDAO;
import com.AmebaDevices.dao.ItemDAO;
import com.AmebaDevices.dao.RoomDAO;
import com.AmebaDevices.dto.BasicItemDTO;
import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.dto.TreeItemDTO;
import com.AmebaDevices.dto.TreeRoomDTO;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.Room;

@Service
public class ItemService {

	private ItemDAO itemEntityDao;
	private BuildingDAO buildingDao;
	private FloorDAO floorDao;
	private RoomDAO roomDao;

	@Autowired
	public ItemService(ItemDAO itemEntityDao, BuildingDAO buildingDAO, FloorDAO floorDao, RoomDAO roomDao) {
		this.itemEntityDao = itemEntityDao;
		this.buildingDao = buildingDAO;
		this.floorDao = floorDao;
		this.roomDao = roomDao;
	}

	public ItemDTO insertItem(ItemDTO item) {
		return ItemConverter.convertToDto(this.itemEntityDao.save(ItemConverter.convertToItem(item)));
	}

	public boolean deleteItem(Long id) {
		Item item = itemEntityDao.findOne(id);
		 itemEntityDao.delete(item);
		 return true;
	}

	public ItemDTO updateItem(ItemDTO item) {
		return ItemConverter.convertToDto(this.itemEntityDao.save(ItemConverter.convertToItem(item)));
	}

	public ItemDTO searchItem(Long id) {
		return ItemConverter.convertToDto(this.itemEntityDao.findOne(id));
	}

	public List<ItemDTO> getAllByRoom(RoomDTO room) {
		List<Item> items = (List<Item>) itemEntityDao.findByRoom(RoomConverter.convertToRoom(room));
		List<ItemDTO> ItemPerRoom = new ArrayList<>();
		items.forEach(i -> ItemPerRoom.add(ItemConverter.convertToDto(i)));
		return ItemPerRoom;

	}
	
	public List<TreeItemDTO> getAllTreeItem(TreeRoomDTO room) {
		List<Item> items = (List<Item>) itemEntityDao.findByRoom(TreeRoomConverter.convertToRoom(room));
		List<TreeItemDTO> itemPerRoom = new ArrayList<>();
		items.forEach(item -> itemPerRoom.add(TreeItemConverter.convertToDto(item)));
		return itemPerRoom;

	}

	public List<BasicItemDTO> getByBuilding(long buildingId) {
		List <Floor> floors = floorDao.findByBuilding(buildingDao.findOne(buildingId));
		List <Room> rooms = new ArrayList<>();
		for (Floor floor : floors) {
			rooms.addAll(roomDao.findByFloor(floor));
		}
		List <Item> items = new ArrayList<>();
		for (Room room : rooms) {
			items.addAll(itemEntityDao.findByRoom(room));
		}
		List <BasicItemDTO> itemsdto = new ArrayList<>();
		for (Item item : items) {
			
			itemsdto.add(ItemConverter.convertToBasicDto(item));
		}
		
		return itemsdto;
	}
	
	
}
