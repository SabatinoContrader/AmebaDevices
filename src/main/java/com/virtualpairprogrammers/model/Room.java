package com.virtualpairprogrammers.model;

import org.jdom2.Element;

public class Room implements Buildable{
	String id;
	String nomeRoom,descrizione;
	private String idfloor;
	
	public Room(String nomeRoom, String descrizione) {
		this.nomeRoom=nomeRoom;
		this.descrizione=descrizione;
	}
	
	public Room() {
		
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


	public String getIdFloor() {

		return idfloor;

	}

	public void setIdFloor(String idfloor) {

		this.idfloor=idfloor;

	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
