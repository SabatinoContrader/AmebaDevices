package com.virtualpairprogrammers.model;

import org.jdom2.Element;

public class Room{
	int id;
	String nomeRoom,descrizione;
	private String idroom;
	
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


	public String getIdRoom() {

		return idroom;

	}

	public void setIdRoom(String idroom) {

		this.idroom=idroom;

	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
