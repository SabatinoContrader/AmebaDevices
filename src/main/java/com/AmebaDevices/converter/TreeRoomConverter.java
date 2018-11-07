package com.AmebaDevices.converter;

import java.util.List;

import com.AmebaDevices.dto.TreeItemDTO;
import com.AmebaDevices.dto.TreeRoomDTO;
import com.AmebaDevices.model.Room;

public class TreeRoomConverter {
	
	public static TreeRoomDTO convertToDTO(Room room) {
		TreeRoomDTO treeRoom = new TreeRoomDTO(
				room.getId(),
				room.getNomeRoom(),
				room.getDescrizione()
		);
		return treeRoom;
	}
	
	public static Room convertToRoom(TreeRoomDTO _room) {
		Room room = new Room();
		room.setId(_room.getId());
		room.setDescrizione(_room.getDescrizione());
		return room;
	}
}
