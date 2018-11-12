package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ManufacturerDTO;
import com.AmebaDevices.model.Customer;

public class ManufacturerConverter {
	public static ManufacturerDTO convertToDto(Customer customer) {
		ManufacturerDTO manufacturer= new ManufacturerDTO();
		manufacturer.setUsername(customer.getUsername());
		manufacturer.setNome(customer.getNome());
		manufacturer.setEmail(customer.getEmail());
		manufacturer.setUserRole(4);
		return manufacturer;
	}

	public static Customer convertToCustomer(ManufacturerDTO manufacturer) {
		Customer customer = new Customer();
		customer.setUserRole(4);
		customer.setNome(manufacturer.getNome());
		customer.setUsername(manufacturer.getUsername());
		customer.setEmail(manufacturer.getEmail());
		return customer;
	}
}
