package com.AmebaDevices.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.CustomerDAO;
import com.AmebaDevices.model.Customer;


@Service
public class CustomerService {

	private CustomerDAO customerDAO;
	@Autowired
	public CustomerService() {
		this.customerDAO=new CustomerDAO();
	}
	public boolean insertCustomer(Customer customer) {
		return this.customerDAO.insertCustomer(customer);
	}
	
	public List<Customer> readAll(){
		return this.customerDAO.readAll();
	}
	public void updateCustomer( Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	
	public Customer searchCustomer(int id) {
		return customerDAO.searchCustomer(id);
	}
	
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
}
