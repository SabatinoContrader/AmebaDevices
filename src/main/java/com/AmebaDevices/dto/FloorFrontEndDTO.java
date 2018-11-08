package com.AmebaDevices.dto;

public class FloorFrontEndDTO {
	
	private String nomeFloor;
	private String descrizione;

	public FloorFrontEndDTO() {
	}

	public FloorFrontEndDTO(String nomeFloor, String descrizione) {
		this.nomeFloor = nomeFloor;
		this.descrizione = descrizione;
	}


	public String getNomeFloor() {
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

}
