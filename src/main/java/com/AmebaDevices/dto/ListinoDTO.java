package com.AmebaDevices.dto;

import com.AmebaDevices.model.Customer;

public class ListinoDTO {
	private long id;
	private String nomeListino;
	private int anno;
	private Customer manufacturer;
	
public ListinoDTO() {

}

public ListinoDTO(long id, String nomeListino, int anno, Customer manufacturer) {
	this.id = id;
	this.nomeListino = nomeListino;
	this.anno = anno;
	this.manufacturer = manufacturer;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNomeListino() {
	return nomeListino;
}

public void setNomeListino(String nomeListino) {
	this.nomeListino = nomeListino;
}

public int getAnno() {
	return anno;
}

public void setAnno(int anno) {
	this.anno = anno;
}

public Customer getManufacturer() {
	return manufacturer;
}

public void setManufacturer(Customer manufacturer) {
	this.manufacturer = manufacturer;
}


}
