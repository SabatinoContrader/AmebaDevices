package com.AmebaDevices.dto;

public class TreeItemDTO {
	
	private long id;
	private String seriale;
	private String categoria;
	private String descrizione;
	private String marca;
	private String modello;
	
	public TreeItemDTO() {};
	
	public TreeItemDTO(
			long id,
			String seriale,
			String descrizione,
			String marca,
			String modello
	) {
		this.id = id;
		this.seriale = seriale;
		this.descrizione = descrizione;
		this.marca = marca;
		this.modello = modello;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeriale() {
		return seriale;
	}

	public void setSeriale(String seriale) {
		this.seriale = seriale;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}
}
