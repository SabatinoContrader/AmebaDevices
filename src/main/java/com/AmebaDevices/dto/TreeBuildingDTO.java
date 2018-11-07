package com.AmebaDevices.dto;

import java.util.List;

public class TreeBuildingDTO {
	private List<TreeFloorDTO> treeFloors;
	
	public TreeBuildingDTO() {}
	
	public void setTreeFloor(List<TreeFloorDTO> _treeFloors) {
		treeFloors = _treeFloors;
	}
	
	public List<TreeFloorDTO> getTreeFloor() {
		return treeFloors;
	}
}
