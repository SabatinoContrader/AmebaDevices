package com.AmebaDevices.dto;

import java.util.ArrayList;
import java.util.List;

public class TreeBuildingDTO {
	private List<TreeFloorDTO> treeFloors;
	private String name;
	private List<ThingDTO> things;
	
	public TreeBuildingDTO() {}
	
	public void setTreeFloor(List<TreeFloorDTO> _treeFloors) {
		treeFloors = _treeFloors;
	}
	
	public List<TreeFloorDTO> getTreeFloor() {
		return treeFloors;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setThings(List<ThingDTO> _things) {
		this.things = _things;
	}
	
	public List<ThingDTO> getThings() {
		return this.things;
	}
	
	public List<TreeItemDTO> allItems() {
		List<TreeItemDTO> items=new ArrayList<>();
		this.treeFloors.forEach(floor -> floor.getRooms().forEach(room -> room.getItems().forEach(item -> {
			if(item.getThingId() == 0) {
				items.add(item);
			}	
		})));
		return items;
	}
}
