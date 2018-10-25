package com.AmebaDevices.dto;

public class FloorDTO {
	private String id;
	private String nomeFloor;
	private String descrizione;
	private String idBuilding;

	public FloorDTO() {
	}

	public FloorDTO(String id, String nomeFloor, String descrizione, String idBuilding) {
		super();
		this.id = id;
		this.nomeFloor = nomeFloor;
		this.descrizione = descrizione;
		this.idBuilding = idBuilding;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getIdBuilding() {
		return idBuilding;
	}

	public void setIdBuilding(String idBuilding) {
		this.idBuilding = idBuilding;
	}

}
