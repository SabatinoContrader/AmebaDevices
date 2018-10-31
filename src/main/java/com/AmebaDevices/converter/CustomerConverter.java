package com.AmebaDevices.converter;

import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.model.Customer;

public class CustomerConverter {

	public static CustomerDTO convertToDto(Customer c) {
		CustomerDTO customerDTO=new CustomerDTO();
		
		if(c != null) {
			customerDTO.setNome(c.getNome());
			customerDTO.setCognome(c.getCognome());
			customerDTO.setEmail(c.getEmail());
			customerDTO.setUsername(c.getUsername());
			customerDTO.setUserRole(c.getUserRole());
		} else {
			customerDTO.setUserRole(-1);
		}
		
		return customerDTO;
	}
	
	public static Customer convertToCustomer(CustomerDTO c) {
		Customer customer= new Customer();
		customer.setNome(c.getNome());
		customer.setCognome(c.getCognome());
		customer.setEmail(c.getEmail());
		customer.setUsername(c.getUsername());
		customer.setUserRole(c.getUserRole());
		return customer;
	}
	
}
