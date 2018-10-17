package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.model.Thing;

public class ThingService {
	
	private ThingDAO thingDAO;
	
	
	public ThingService() {	
		thingDAO = new ThingDAO();	
	}
	
	public void create(Thing t) {
		thingDAO.create(t);
		
	}
	
	public List<Thing> getAllByBuilding(Building b) {
		return thingDAO.getAllByBuilding(b);
	}
	
	public Thing searchThing(String id) {
		return thingDAO.searchThing(id);
	}
	
	public void delete(Thing t) {
		thingDAO.delete(t);
	}
	
	

}
