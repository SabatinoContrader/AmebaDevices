package com.AmebaDevices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.ThingDAO;
import com.AmebaDevices.model.Thing;

@Service
public class ThingService {
	
	private ThingDAO thingDAO;
	
	@Autowired
	public ThingService() {	
		thingDAO = new ThingDAO();	
	}
	
	public void create(Thing t) {
		thingDAO.create(t);
		
	}
	
	public List<Thing> getAllItem(){
		return this.thingDAO.getAllItem();
	}
	
	/*public List<Thing> getAllByBuilding(int buildingId) {
		return thingDAO.getAllByBuilding(buildingId);
	}
	
	public Thing searchThing(String id) {
		return thingDAO.searchThing(id);
	}*/
	
	public void delete(int id) {
		thingDAO.delete(id);
	}

	public void update(Thing newThing) {
		this.thingDAO.update(newThing);
	}
	
	

}
