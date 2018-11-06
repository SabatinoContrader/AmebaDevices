package com.AmebaDevices.converter;

import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.dto.NewCustomerDTO;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.services.CustomerWithIdDTO;

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
	
	public static Customer convertToCustomer(CustomerWithIdDTO c) {
		Customer customer= new Customer();
		customer.setId(c.getId());
		customer.setNome(c.getNome());
		customer.setCognome(c.getCognome());
		customer.setEmail(c.getEmail());
		customer.setUsername(c.getUsername());
		customer.setUserRole(c.getUserRole());
		return customer;
	}
	
	public static CustomerWithIdDTO convertToDtoWithId(Customer c) {
			
		CustomerWithIdDTO customerDTO=new CustomerWithIdDTO();
		
		if(c != null) {
			customerDTO.setId(c.getId());
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
	
}
