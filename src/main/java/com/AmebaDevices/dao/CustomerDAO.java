package com.AmebaDevices.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.Customer;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {


   // @Query(value = "SELECT c FROM Customer c where c.username = ?1")
	 Customer findByUsername(String username);
}
