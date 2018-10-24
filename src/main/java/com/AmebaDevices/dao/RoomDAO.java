package com.AmebaDevices.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.Room;


@Repository
@Transactional
public interface RoomDAO extends CrudRepository<Room, Integer> {

	void update(Room f);
	void delete(int id); 
    Room save(Room f);
    List<Room> getAllByFloor(int floorId) ;


	}