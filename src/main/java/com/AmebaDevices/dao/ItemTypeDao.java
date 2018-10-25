package com.AmebaDevices.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.ItemType;

@Repository
public interface ItemTypeDao extends CrudRepository<ItemType,Long> {
	
	
}