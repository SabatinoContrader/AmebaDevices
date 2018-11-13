package com.AmebaDevices.dto;

import com.AmebaDevices.model.Customer;

public class NewItemDTO extends BasicItemDTO {
	Customer manufacturer;
	
	public NewItemDTO(long id, RoomDTO room, ItemTypeDTO itemType,Customer manufacturer ) {
		super(id,room, itemType);
		this.manufacturer=manufacturer;
	}
	public NewItemDTO(long id, RoomDTO room, ItemTypeDTO itemType) {
		super(id,room,itemType);
	}
	public NewItemDTO() {
		// TODO Auto-generated constructor stub
	}
	public Customer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Customer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}
