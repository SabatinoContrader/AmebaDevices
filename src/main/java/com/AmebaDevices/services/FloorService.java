package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.FloorConverter;
import com.AmebaDevices.dao.BuildingDAO;
import com.AmebaDevices.dao.FloorDAO;
import com.AmebaDevices.dto.FloorDTO;
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
	
	
	public FloorDTO insertFloor(FloorDTO f, long buildingId) {
		Building b = buildingdao.findOne(buildingId);
		f.setBuilding(b);
		return FloorConverter.convertToDto(floordao.save(FloorConverter.convertToFloor(f)));
	}
	
	public List <FloorDTO> getAllByBuilding (long buildingid){
		Building b = buildingdao.findOne(buildingid);
		List <Floor> floors = (List<Floor>) floordao.findByBuilding(b);
		List<FloorDTO> toReturn= new ArrayList<>();
		floors.forEach(f->toReturn.add(FloorConverter.convertToDto(f)));
		return toReturn;
	}
	
	public void delete(FloorDTO f) {
		this.floordao.delete(FloorConverter.convertToFloor(f));
	}
		
	public void update (FloorDTO f, long buildingId) {
		Building b = buildingdao.findOne(buildingId);
		f.setBuilding(b);
		if (floordao.findOne(f.getId()) != null)
			this.floordao.save(FloorConverter.convertToFloor(f));
	}
	
	public FloorDTO findByPrimaryKey(long id) {
		return FloorConverter.convertToDto(this.floordao.findOne(id));
	}


	public void deleteById(long id) {
		this.floordao.delete(id);
		
	}
	
	
	
}
