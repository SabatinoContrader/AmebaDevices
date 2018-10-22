package com.AmebaDevices.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.RoomDAO;
import com.AmebaDevices.model.Room;

@Service
public class RoomService {

	private RoomDAO roomdao;

	@Autowired
	public RoomService() {
		this.roomdao = new RoomDAO();

	}

	public void delete(int id) {
		roomdao.delete(id);

	}

	public Room searchRoom(int id) {
		return roomdao.searchRoom(id);
	}

	public void update(Room f) {
		this.roomdao.update(f);

	}

	public boolean insertRoom(Room f) {
		return this.roomdao.insertRoom(f);
	}

	public List<Room> getAllByFloor(int floorId) {

		return roomdao.getAllByFloor(floorId);

	}

}
