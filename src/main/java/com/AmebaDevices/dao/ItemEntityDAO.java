package com.AmebaDevices.dao;

import org.springframework.data.repository.CrudRepository;

import com.AmebaDevices.model.Item;

public interface ItemEntityDAO extends CrudRepository<Item,Long> {

}
