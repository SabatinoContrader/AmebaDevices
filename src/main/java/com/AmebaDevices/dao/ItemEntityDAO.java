package com.AmebaDevices.dao;

import org.springframework.data.repository.CrudRepository;

import com.AmebaDevices.model.ItemEntity;

public interface ItemEntityDAO extends CrudRepository<ItemEntity,Long> {

}
