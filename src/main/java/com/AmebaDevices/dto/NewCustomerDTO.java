package com.AmebaDevices.dto;

public class NewCustomerDTO extends CustomerDTO {
	private String password;
	
	public NewCustomerDTO() {}
	
	public NewCustomerDTO(
			String nome,
			String cognome, 
			String email,
			String username,
			String password,
			Integer userRole
	) {
		super(nome, cognome, email, username, userRole);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
