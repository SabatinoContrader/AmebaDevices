package com.AmebaDevices.converter;

import com.AmebaDevices.dao.BuildingDAO;
import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.model.Building;

public class BuildingConverter {
	public static BuildingDTO convertToDto(Building b) {
		BuildingDTO building = new BuildingDTO();
		building.setBuildingId(b.getBuildingId());
		building.setCap(b.getCap());
		building.setCitta(b.getCitta());
		building.setIndirizzo(b.getIndirizzo());
		building.setInterno(b.getInterno());
		return building;
	}
	public static Building convertToBuilding(BuildingDTO b) {
		Building building= new Building();
		building.setBuildingId(b.getBuildingId());
		building.setCap(b.getCap());
		building.setCitta(b.getCitta());
		building.setIndirizzo(b.getIndirizzo());
		building.setInterno(b.getInterno());
		return building;
	}
}
