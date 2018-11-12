package com.AmebaDevices.dto;

import com.AmebaDevices.model.Customer;

public class ManufacturerDTO {
	private String username;
	private String nome;
	private String email;
	private int userRole;

	public String getUsername() {
		return username;
	}

	public int getUserRole() {
		return userRole;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
