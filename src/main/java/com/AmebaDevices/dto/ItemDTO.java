package com.AmebaDevices.dto;

public class ItemDTO {
	private String id, categoria,modello,marca, descrizione;
	
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemDTO(String id, String categoria, String modello, String marca, String descrizione) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.modello = modello;
		this.marca = marca;
		this.descrizione = descrizione;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
