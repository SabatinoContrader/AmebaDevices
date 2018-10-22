package com.AmebaDevices.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.BuildingDAO;
import com.AmebaDevices.model.Building;


@Service
public class BuildingService {
	
	private BuildingDAO buildingdao;
	
	// DEVE permettere operazioni di create, read, update e delete 
	// e probabilmente altre se mi serviranno
	@Autowired
	public BuildingService () {
		buildingdao = new BuildingDAO();
	}
	
	
	public List<Building> getAll(String owner){
		return buildingdao.getAllByUser(owner);
	
		
	}

	public boolean delete (Building toDestroy, String owner) {
		return buildingdao.delete(toDestroy, owner);
	}

	public boolean create(String owner, Building myNewBuilding) {
		return buildingdao.insert(myNewBuilding, owner);
		
	}


	public boolean update(Building building, Building newValues, String username) {
		return buildingdao.update(building, newValues, username);
	}


	public Building findByPrimaryKey(int buildingId) {
		return BuildingDAO.findByPrimaryKey(buildingId);
	}
		

}
