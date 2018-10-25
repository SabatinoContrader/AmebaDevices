package com.AmebaDevices.dto;

public class BuildingDTO {

	private int buildingId;
	private String indirizzo;
	private String citta;
	private String cap;
	private String interno;

	public BuildingDTO() {
	}

	public BuildingDTO(int buildingId, String indirizzo, String citta, String cap, String interno) {
		super();
		this.buildingId = buildingId;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.interno = interno;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

}
