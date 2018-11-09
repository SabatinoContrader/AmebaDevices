package com.AmebaDevices.dto;

public class BasicItemDTO {
	
	private long id;
	private RoomDTO room;
	private ItemTypeDTO itemType;
	
	
	public BasicItemDTO(long id, RoomDTO room, ItemTypeDTO itemType) {
		super();
		this.id = id;
		this.room = room;
		this.itemType = itemType;
	}


	public BasicItemDTO() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public RoomDTO getRoom() {
		return room;
	}


	public void setRoom(RoomDTO room) {
		this.room = room;
	}


	public ItemTypeDTO getItemType() {
		return itemType;
	}


	public void setItemType(ItemTypeDTO itemType) {
		this.itemType = itemType;
	}
	
}
