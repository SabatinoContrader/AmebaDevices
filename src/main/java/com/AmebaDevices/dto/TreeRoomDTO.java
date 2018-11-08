package com.AmebaDevices.dto;

import java.util.List;

public class TreeRoomDTO {
	private long id;
	private String nomeRoom;
	private String descrizione;
	private List<TreeItemDTO> items;
	
	public TreeRoomDTO() {}
	
	public TreeRoomDTO(
			long id,
			String nomeRoom,
			String descrizione
	) {
		this.id = id;
		this.nomeRoom = nomeRoom;
		this.descrizione = descrizione;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeRoom() {
		return nomeRoom;
	}
	
	public String getName() {
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
	
	public void setItems(List<TreeItemDTO> items) {
		this.items = items;
	}
	
	public List<TreeItemDTO> getItems() {
		return this.items;
	}
	
	public List<TreeItemDTO> getChildren() {
		return this.items;
	}

}
