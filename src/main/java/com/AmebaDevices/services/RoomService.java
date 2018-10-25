package com.AmebaDevices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.RoomDAO;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.Room;

@Service
public class RoomService {

	private RoomDAO roomdao;

	@Autowired
	public RoomService(RoomDAO roomdao) {
		this.roomdao = roomdao;
	}

	public void delete(long id) {
		Room c = roomdao.findOne(id);
		roomdao.delete(c);

	}

	public Room insertRoom(Room f) {
		return this.roomdao.save(f);
	}

	public void update(Room f) {
		if (roomdao.findOne(f.getId()) != null)
			this.roomdao.save(f);

	}

	public List<Room> getAllByFloor(Floor f) {
		List<Room> rooms = (List<Room>) roomdao.findByFloor(f);
		return rooms;

	}

}