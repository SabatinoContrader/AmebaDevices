package com.AmebaDevices.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.Room;
@Repository
public interface ItemDAO extends CrudRepository<Item,Long>{

	List<Item> findByRoom(Room room);

}
