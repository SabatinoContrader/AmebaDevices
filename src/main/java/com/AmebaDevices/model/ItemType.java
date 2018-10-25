package com.AmebaDevices.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemType  {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotNull
	private String categoria;
	
	@Column
	@NotNull
	private String modello; 
	
	@Column
	@NotNull
	private String marca;
	
	@Column
	@NotNull
	private String descrizione;
	
	@ManyToOne
	@JoinColumn (name ="iditemtype")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="idroom")
	private Room room;
	
	public ItemType(Long id, String categoria, String marca, String modello, String descrizione) {
	
		this.id = id;
		this.categoria = categoria;
		this.modello = modello;
		this.marca = marca;
		this.descrizione = descrizione;
	}
	
	public ItemType() {
		
	}
	

	public String toString() {
		return "id: " + id + 
				"\nModello: " + modello + 
	        	"\nMarca: " +marca + 
	        	"\nCategoria: "+ categoria +
	        	"\nDescrizione: " + descrizione;
	 }
	 
	 public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        ItemType i = (ItemType) o;
	        return id == i.id&&modello.equals(i.modello)&&categoria.equals(i.categoria)&&marca.equals(i.marca)&&descrizione.equals(i.descrizione);
	 }
	 

}

