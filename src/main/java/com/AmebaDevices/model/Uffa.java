package com.AmebaDevices.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Uffa {
@Id
int id;
public Uffa() {
	// TODO Auto-generated constructor stub
}
public void setId(int id) {
	this.id = id;
}
public int getId() {
	return id;
}
}
