package com.virtualpairprogrammers.model;

import org.jdom2.Element;

public class Floor implements Buildable {

	private String id;
	private String nomeFloor;
	private String descrizione;
	private String idBuilding; // l'id del building associato al floor

	public Floor() {
	}

	public Floor(String nomeFloor, String descrizione) {
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

	public String getIdBuilding() {
		return idBuilding;
	}

	public void setIdBuilding(String idBuilding) {
		this.idBuilding = idBuilding;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		// Metodo per l'xml
		
		return null;
	}

}
