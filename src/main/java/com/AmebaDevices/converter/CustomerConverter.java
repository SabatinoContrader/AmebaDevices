package com.AmebaDevices.converter;

import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.dto.CustomerWithIdDTO;
import com.AmebaDevices.dto.NewCustomerDTO;
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
	
	public static Customer convertToCustomer(CustomerWithIdDTO c) {
		Customer customer= new Customer();
		customer.setId(c.getId());
		customer.setNome(c.getNome());
		customer.setCognome(c.getCognome());
		customer.setEmail(c.getEmail());
		customer.setUsername(c.getUsername());
		customer.setPassword(c.getPassword());
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
			customerDTO.setPassword(c.getPassword());
			customerDTO.setUserRole(c.getUserRole());
		} else {
			customerDTO.setUserRole(-1);
		}
		
		return customerDTO;
	}
	public static NewCustomerDTO convertToNewCustomerDTO(Customer c) {
		NewCustomerDTO newCustomer= new NewCustomerDTO();
		newCustomer.setNome(c.getNome());
		newCustomer.setCognome(c.getCognome());
		newCustomer.setEmail(c.getEmail());
		newCustomer.setUsername(c.getUsername());
		newCustomer.setUserRole(c.getUserRole());
		newCustomer.setPassword(c.getPassword());
		return newCustomer;
	}

	public static NewCustomerDTO convertCustomerWithIdToNewCustomer(CustomerWithIdDTO customer) {
		NewCustomerDTO newCustomerDto= new NewCustomerDTO();
		newCustomerDto.setNome(customer.getNome());
		newCustomerDto.setCognome(customer.getCognome());
		newCustomerDto.setEmail(customer.getEmail());
		newCustomerDto.setUsername(customer.getUsername());
		newCustomerDto.setPassword(customer.getPassword());
		return newCustomerDto;
	}
	
}
