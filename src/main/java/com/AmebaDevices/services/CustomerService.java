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
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public int login(String username, String password) {
		System.out.println(username);
		Customer c = customerDAO.findByUsername(username);
		if (c != null) {
			System.out.println("c è diverso da null");
			if (c.getId() != null)
				return Integer.parseInt(c.getId());
		} else {
			System.out.println("nullo");
		}

		return -1;
	}

	public void insertCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	public List<Customer> readAll() {
		return (List<Customer>) customerDAO.findAll();
	}

	public void updateCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	public Customer searchCustomer(int id) {
		return customerDAO.findOne(id);
	}

	public void deleteCustomer(int id) {
		Customer c = customerDAO.findOne(id);
		customerDAO.delete(c);
	}
}
