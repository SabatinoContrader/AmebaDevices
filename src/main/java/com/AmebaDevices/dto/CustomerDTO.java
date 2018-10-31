package com.AmebaDevices.dto;

public class CustomerDTO {

	private String nome;
	private String cognome;
	private String email;
	private String username;
	private Integer userRole;

	public CustomerDTO() {

	}

	public CustomerDTO(String nome, String cognome, 
			String email, String username,Integer userRole) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.userRole = userRole;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}


	public Integer getUserRole() {
		return userRole;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

}
