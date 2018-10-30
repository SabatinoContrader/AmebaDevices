package com.AmebaDevices.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingTreeDTO {
	
	private BuildingDTO building;
	private List<FloorDTO> floors;
	private Map<Long, List<RoomDTO>> roomsByFloor = new HashMap<>();
	private Map<Long, List<ItemDTO>> itemsByRoom = new HashMap<>();
	
	public BuildingTreeDTO() {}
	
	public void setBuilding(BuildingDTO _building) {
		this.building = _building;
	}
	
	public void setFloors(List<FloorDTO> _floors) {
		this.floors = _floors;
	}
	
	public void setRoomsByFloor(long _floorId, List<RoomDTO> _rooms) {
		this.roomsByFloor.put(_floorId, _rooms);
	}
	
	public void setItemsByRoom(long _roomId, List<ItemDTO> _items) {
		this.itemsByRoom.put(_roomId, _items);
	}

	public BuildingDTO getBuilding() {
		return this.building;
	}
	
	public List<FloorDTO> getAllFloors() {
		return this.floors;
	}
	
	public List<RoomDTO> getRoomsByFloor(long _floorId) {
		return this.roomsByFloor.get(_floorId);
	}
	
	public List<ItemDTO> getItemsByRoom(long _roomId) {
		return this.itemsByRoom.get(_roomId);
	}
	
}
