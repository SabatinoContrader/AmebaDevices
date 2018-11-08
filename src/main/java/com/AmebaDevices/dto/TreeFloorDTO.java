package com.AmebaDevices.dto;

import java.util.List;

public class TreeFloorDTO {
	private long id;
	private String nomeFloor;
	private String descrizione;
	private List<TreeRoomDTO> rooms;
	
	public TreeFloorDTO() {}
	
	public TreeFloorDTO(long id, String nomeFloor, String descrizione) {
		this.id = id;
		this.nomeFloor = nomeFloor;
		this.descrizione = descrizione;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeFloor() {
		return nomeFloor;
	}
	
	public String getName() {
		return nomeFloor;
	}

	public void setNomeFloor(String nomeFloor) {
		this.nomeFloor = nomeFloor;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public void setRooms(List<TreeRoomDTO> _rooms) {
		this.rooms = _rooms;
	}
	
	public List<TreeRoomDTO> getRooms() {
		return this.rooms;
	}
	
	public List<TreeRoomDTO> getChildren() {
		return this.rooms;
	}
}
