package com.AmebaDevices.converter;

import com.AmebaDevices.dto.TreeFloorDTO;
import com.AmebaDevices.model.Floor;

public class TreeFloorConverter {
	
	public static TreeFloorDTO convertToDTO(Floor f) {
		TreeFloorDTO floor = new TreeFloorDTO();
		floor.setId(f.getId());
		floor.setDescrizione(f.getDescrizione());
		floor.setNomeFloor(f.getNomeFloor());
		return floor;
	}
	
	public static Floor convertToFloor(TreeFloorDTO f) {
		Floor floor = new Floor();
		floor.setId(f.getId());
		floor.setDescrizione(f.getDescrizione());
		floor.setNomeFloor(f.getNomeFloor());
		return floor;
	}

}
