package com.AmebaDevices.dto;

import com.AmebaDevices.model.ItemType;
import com.AmebaDevices.model.Listino;

public class PrezzoDTO {
	private long id;
	private double prezzo;
	private ItemTypeDTO idItemType;
	private ListinoDTO idListino;
	
	public PrezzoDTO() {
		
	}
	public PrezzoDTO(long id, double prezzo, ItemTypeDTO idItemType, ListinoDTO idListino) {
		super();
		this.id = id;
		this.prezzo = prezzo;
		this.idItemType = idItemType;
		this.idListino = idListino;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public ItemTypeDTO getIdItemType() {
		return idItemType;
	}
	public void setIdItemType(ItemTypeDTO idItemType) {
		this.idItemType = idItemType;
	}
	public ListinoDTO getIdListino() {
		return idListino;
	}
	public void setIdListino(ListinoDTO listinoDTO) {
		this.idListino = listinoDTO;
	}
	

}
