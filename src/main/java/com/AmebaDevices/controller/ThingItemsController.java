package com.AmebaDevices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.BuildingTreeDTO;
import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.FloorService;
import com.AmebaDevices.services.ItemService;
import com.AmebaDevices.services.RoomService;

@Controller
@RequestMapping("/BuildingTree")
public class ThingItemsController {
	
	private FloorService floorService;
	private RoomService roomService;
	private ItemService itemService;
	private BuildingService buildingService;
	
	@Autowired
	public ThingItemsController(FloorService _floorService, RoomService _roomService, ItemService _itemService, BuildingService _buildingService) {
		this.floorService = _floorService;
		this.roomService = _roomService;
		this.itemService = _itemService;
		this.buildingService = _buildingService;
	}
	
	@RequestMapping(value = "getTree", method = RequestMethod.GET)
	public String getAllThree(HttpServletRequest request) {
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		BuildingTreeDTO buildingTree = this.BuildingTreeFromBuildingId(buildingId);
		
		request.setAttribute("buildingTree", buildingTree);
		return "ThingTree";
	}
	
	private BuildingTreeDTO BuildingTreeFromBuildingId(long _buildingId) {
		BuildingTreeDTO buildingTree = new BuildingTreeDTO();
		BuildingDTO building = buildingService.findByPrimaryKey(_buildingId);
		buildingTree.setBuilding(building);
				
		buildingTree.setFloors(this.floorService.getAllByBuilding(_buildingId));
				
		buildingTree.getAllFloors().forEach(floor -> {
			buildingTree.setRoomsByFloor(floor.getId(), roomService.getAllByFloor(floor));
			
			buildingTree.getRoomsByFloor(floor.getId()).forEach(room -> {
				buildingTree.setItemsByRoom(room.getId(), itemService.getAllByRoom(room));				
			});
		});
		
		return buildingTree;
	}
	

}
