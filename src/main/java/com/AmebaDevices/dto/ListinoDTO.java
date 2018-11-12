package com.AmebaDevices.dto;

import com.AmebaDevices.model.Customer;

public class ListinoDTO {
	private long id;
	private String nomeListino;
	private String anno;
	private Customer manufacturer;
	
public ListinoDTO() {

}

public ListinoDTO(long id, String nomeListino, String anno, Customer manufacturer) {
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

public String getAnno() {
	return anno;
}

public void setAnno(String anno) {
	this.anno = anno;
}

public Customer getManufacturer() {
	return manufacturer;
}

public void setManufacturer(Customer manufacturer) {
	this.manufacturer = manufacturer;
}


}
