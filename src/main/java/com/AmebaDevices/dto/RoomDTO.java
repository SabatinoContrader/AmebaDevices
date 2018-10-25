package com.AmebaDevices.dto;

public class RoomDTO {
	
	private int id;
	private String nomeRoom;
	private String descrizione;
	private String idfloor;
	
	public RoomDTO() {
	}
	
	public RoomDTO(int id, String nomeRoom, String descrizione, String idfloor) {
		this.id = id;
		this.nomeRoom = nomeRoom;
		this.descrizione = descrizione;
		this.idfloor = idfloor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRoom() {
		return nomeRoom;
	}

	public void setNomeRoom(String nomeRoom) {
		this.nomeRoom = nomeRoom;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIdfloor() {
		return idfloor;
	}

	public void setIdfloor(String idfloor) {
		this.idfloor = idfloor;
	}

	

}
