package com.AmebaDevices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.dao.FloorDAO;
import com.AmebaDevices.model.Floor;

@Service
public class FloorService {
	
	private FloorDAO floordao;
	
	@Autowired
	public FloorService() {
		floordao = new FloorDAO();
	}
	
	
	public boolean insertFloor(Floor f) {
		return this.floordao.insertFloor(f);
	}
	
	public List <Floor> getAllByBuilding (int buildingid){
		return floordao.getAllByBuilding(buildingid);
	}
	
	public void delete(Floor f) {
		this.floordao.delete(f);
	}
		
	public void update (Floor f) {
		this.floordao.update(f);
	}
	
	public Floor findByPrimaryKey(int id) {
		return this.floordao.findByPrimaryKey(id);
	}


	public void deleteById(int id) {
		this.floordao.deleteById(id);
		
	}

	
}
