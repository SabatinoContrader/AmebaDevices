package com.AmebaDevices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.RoomDAO;
import com.AmebaDevices.model.Room;

@Service
public class RoomService {

	private RoomDAO roomdao;
	

	@Autowired
	public RoomService() {
		//this.roomdao=(RoomDAO) room;
	}

	public void delete(int id) {
		Room c= roomdao.findOne(id);
		roomdao.delete(c);

	}

	public Room insertRoom(Room f) {
		return this.roomdao.save(f);
	}
	
	
	public void update(Room f) {
		if(roomdao.findOne(Integer.parseInt(f.getId()))!=null)
		this.roomdao.save(f);

	}

	public List<Room> getAllByFloor(int floorId) {
		List<Room> room= (List<Room>) roomdao.findAll();
		for(int i=0; i<room.size();i++) {
			if (room.get(i).getIdfloor()!= floorId) {
				room.remove(i);
				i--;
			}
		}
		return room;
		
	}

}