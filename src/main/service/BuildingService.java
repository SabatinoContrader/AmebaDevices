package main.service;

import java.util.List;

import main.dao.BuildingDAO;
import main.model.Building;

public class BuildingService {
	
	private BuildingDAO buildingdao;
	
	// DEVE permettere operazioni di create, read, update e delete 
	// e probabilmente altre se mi serviranno
	
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
		

}
