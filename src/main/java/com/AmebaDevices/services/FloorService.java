package com.AmebaDevices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.BuildingDAO;
import com.AmebaDevices.dao.FloorDAO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Floor;

@Service
public class FloorService {
	
	private FloorDAO floordao;
	private BuildingDAO buildingdao;
	
	@Autowired
	public FloorService(FloorDAO floorDAO, BuildingDAO buildingdao) {
		this.floordao = floorDAO;
		this.buildingdao = buildingdao;

	}
	
	
	public Floor insertFloor(Floor f, long buildingId) {
		Building b = buildingdao.findOne(buildingId);
		f.setBuilding(b);
		return floordao.save(f);
	}
	
	public List <Floor> getAllByBuilding (long buildingid){
		Building b = buildingdao.findOne(buildingid);
		List <Floor> floors = (List<Floor>) floordao.findByBuilding(b);
		return floors;
	}
	
	public void delete(Floor f) {
		this.floordao.delete(f);
	}
		
	public void update (Floor f, long buildingId) {
		Building b = buildingdao.findOne(buildingId);
		f.setBuilding(b);
		if (floordao.findOne(f.getId()) != null)
			this.floordao.save(f);
	}
	
	public Floor findByPrimaryKey(long id) {
		return this.floordao.findOne(id);
	}


	public void deleteById(long id) {
		this.floordao.delete(id);
		
	}
	
	
	
}
