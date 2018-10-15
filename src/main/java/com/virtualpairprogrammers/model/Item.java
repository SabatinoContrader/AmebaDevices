package com.virtualpairprogrammers.model;


import org.jdom2.Element;

public class Item implements Buildable {
	private int id;
	private String categoria,modello,marca;
	public Item(String categoria, String modello, String marca ) {
	
		this.categoria=categoria;
		this.modello=modello;
		this.marca=marca;
	}
	
	public Item() {
		
	}
	
	
	
	public String getCategoria() {
		
		return this.categoria;
	}
	
	public String getModello() {
		return this.modello;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	
	public void setCategoria(String categoria) {
		this.categoria=categoria;
	}
	
	public void setModello(String modello) {
		this.modello=modello;
	}
	
	public void setMarca(String marca) {
		this.marca=marca;
	}
	
	 public String toString() {
	        return "Modello " + modello + "\nMarca: " +marca + "\nCategoria: "+categoria+"\n";
	 }
	 
	 public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Item i = (Item) o;
	        return modello.equals(i.modello)&&categoria.equals(i.categoria)&&marca.equals(i.marca);
	    }

	public void setId(int id) {
		this.id=id;
		
	}

	@Override
	public String getId() {
		return String.valueOf(this.id);
	}

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return null;
	}
		 
	 }

