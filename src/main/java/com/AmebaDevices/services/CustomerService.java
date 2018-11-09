package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.CustomerConverter;
import com.AmebaDevices.converter.NewCustomerConverter;
import com.AmebaDevices.dao.CustomerDAO;
import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.dto.CustomerWithIdDTO;
import com.AmebaDevices.dto.NewCustomerDTO;
import com.AmebaDevices.model.Customer;

@Service
public class CustomerService {

	private CustomerDAO customerDAO;

	@Autowired
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public CustomerDTO login(String username, String password) {
		Customer c = customerDAO.findByUsernameAndPassword(username, password);
		CustomerDTO customerDTO = CustomerConverter.convertToDto(c);
		
		return customerDTO;
	}

	public NewCustomerDTO insertCustomer(NewCustomerDTO customer) {
		return NewCustomerConverter.convertToDto(customerDAO.save(NewCustomerConverter.convertToCustomer(customer)));
	}

	public List<NewCustomerDTO> readAll() {
		List<NewCustomerDTO> customers = new ArrayList<>();
		customerDAO.findByUserRole(2).forEach(c -> {
			customers.add(CustomerConverter.convertToNewCustomerDTO(c));
		});
		return customers;
	}

	public List<CustomerWithIdDTO> readInstallers() {
		List<CustomerWithIdDTO> installers = new ArrayList<>();
		customerDAO.findByUserRole(3).forEach(i -> installers.add(CustomerConverter.convertToDtoWithId(i)));
		return installers;

	}
	public List<CustomerDTO> readManufacturers(){
		List<CustomerDTO> manufacturers = new ArrayList<>();
		customerDAO.findByUserRole(4).forEach(i -> manufacturers.add(CustomerConverter.convertToDto(i)));
		return manufacturers;
	}

	public CustomerWithIdDTO updateCustomer(CustomerWithIdDTO customer) {
			return CustomerConverter.convertToDtoWithId((customerDAO.save(CustomerConverter.convertToCustomer(customer))));
	}

	public CustomerWithIdDTO searchCustomer(Long id) {
		return CustomerConverter.convertToDtoWithId(customerDAO.findOne(id));
	}

	public void deleteCustomer(Long id) {
		Customer c = customerDAO.findOne(id);
		customerDAO.delete(c);
	}

	public CustomerWithIdDTO findByUsername(String username) {
		return CustomerConverter.convertToDtoWithId(customerDAO.findByUsername(username));
	}
}
