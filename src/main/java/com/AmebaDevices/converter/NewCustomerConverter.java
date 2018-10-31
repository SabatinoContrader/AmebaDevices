package com.AmebaDevices.converter;

import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.dto.NewCustomerDTO;
import com.AmebaDevices.model.Customer;

public class NewCustomerConverter {
	public static NewCustomerDTO convertToDto(Customer c) {
		NewCustomerDTO newCustomerDTO = new NewCustomerDTO();
		
		if(c != null) {
			newCustomerDTO.setNome(c.getNome());
			newCustomerDTO.setCognome(c.getCognome());
			newCustomerDTO.setEmail(c.getEmail());
			newCustomerDTO.setUsername(c.getUsername());
			newCustomerDTO.setUserRole(c.getUserRole());
			newCustomerDTO.setPassword(c.getPassword());
		} else {
			newCustomerDTO.setUserRole(-1);
		}
		
		return newCustomerDTO;
	}
	
	public static Customer convertToCustomer(NewCustomerDTO c) {
		Customer customer= new Customer();
		customer.setNome(c.getNome());
		customer.setCognome(c.getCognome());
		customer.setEmail(c.getEmail());
		customer.setUsername(c.getUsername());
		customer.setUserRole(c.getUserRole());
		customer.setPassword(c.getPassword());
		return customer;
	}
}
