package com.AmebaDevices.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.Thing;

@Repository
public interface ThingDAO extends CrudRepository<Thing, Long> {
}
