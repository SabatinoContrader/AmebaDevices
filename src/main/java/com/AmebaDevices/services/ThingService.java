package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.ThingConverter;
import com.AmebaDevices.dao.ThingDAO;
import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.model.Thing;

@Service
public class ThingService {

	private ThingDAO thingDAO;

	@Autowired
	public ThingService() {
		thingDAO = new ThingDAO();
	}

	public void create(ThingDTO t) {
		thingDAO.create(ThingConverter.convertToThing(t));

	}

	public List<ThingDTO> getAllItem() {
		List<Thing> things = new ArrayList<>();
		things = this.thingDAO.getAllItem();
		List<ThingDTO> toReturn = new ArrayList<>();
		things.forEach(t -> toReturn.add(ThingConverter.convertToDto(t)));
		return toReturn;
	}

	/*
	 * public List<Thing> getAllByBuilding(int buildingId) { return
	 * thingDAO.getAllByBuilding(buildingId); }
	 * 
	 * public Thing searchThing(String id) { return thingDAO.searchThing(id); }
	 */

	public void delete(int id) {
		thingDAO.delete(id);
	}

	public void update(ThingDTO newThing) {
		this.thingDAO.update(ThingConverter.convertToThing(newThing));
	}

}
