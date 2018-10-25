package com.AmebaDevices.dto;

import com.AmebaDevices.model.ItemType;

public class ThingDTO {

	private String id;
	private String nome;
	private int numUscite; //potenze di 2
	
	private ItemType[] items;
	
	public ThingDTO() {
	}
	public ThingDTO(int numUscite) {
		this.numUscite = numUscite;
		items = new ItemType[numUscite];
	}
	public ThingDTO(String id, String nome, int numUscite, ItemType[] items) {
		this.id = id;
		this.nome = nome;
		this.numUscite = numUscite;
		this.items = items;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumUscite() {
		return numUscite;
	}
	public void setNumUscite(int numUscite) {
		this.numUscite = numUscite;
	}
	public ItemType[] getItems() {
		return items;
	}
	public void setItems(ItemType[] items) {
		this.items = items;
	}
	
}
