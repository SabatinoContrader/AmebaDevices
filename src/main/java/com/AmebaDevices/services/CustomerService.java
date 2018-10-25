package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.CustomerDAO;
import com.AmebaDevices.model.Customer;

@Service
public class CustomerService {

	private CustomerDAO customerDAO;

	@Autowired
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public long login(String username, String password) {
		Customer c = customerDAO.findByUsernameAndPassword(username, password);
		if (c != null) {
			if (c.getId() != 0)
				return c.getId();
		}
		return -1;
	}

	public void insertCustomer(Customer customer) {
		System.out.println(customer.getId() + customer.getNome() + customer.getCognome() + customer.getDataNascita()
				+ customer.getEmail() + customer.getUsername() + customer.getPassword() + customer.getUser_role());
		customerDAO.save(customer);
	}

	public List<Customer> readAll() {
		List<Customer> customers = new ArrayList<>();
		customerDAO.findAll().forEach(c -> {
			customers.add(c);
			System.out.println(c.getNome());
		});
		return customers;
	}

	public void updateCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	public Customer searchCustomer(Long id) {
		return customerDAO.findOne(id);
	}

	public void deleteCustomer(Long id) {
		Customer c = customerDAO.findOne(id);
		customerDAO.delete(c);
	}
	
	public Customer findByUsername(String username) {
		return customerDAO.findByUsername(username);
	}
}
