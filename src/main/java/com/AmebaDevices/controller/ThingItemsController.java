package com.AmebaDevices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.services.FloorService;
import com.AmebaDevices.services.ItemService;
import com.AmebaDevices.services.RoomService;

@Controller
@RequestMapping("/ThingItems")
public class ThingItemsController {
	
	private FloorService floorService;
	private RoomService roomService;
	private ItemService itemService;
	
	@Autowired
	public ThingItemsController(FloorService _floorService, RoomService _roomService, ItemService _itemService) {
		this.floorService = _floorService;
		this.roomService = _roomService;
		this.itemService = _itemService;
	}
	
	@RequestMapping(value = "getAllThree", method = RequestMethod.GET)
	public String getAllThree(HttpServletRequest request) {
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		List<FloorDTO> floors = new ArrayList<>();
		floors = this.floorService.getAllByBuilding(buildingId);
		request.setAttribute("floor", floors);
		List <RoomDTO> roomsPerFloor = new ArrayList<>();
		List <ItemDTO> itemsPerRoom = new ArrayList<>();
		
		floors.forEach(floor -> {
			roomsPerFloor.addAll(roomService.getAllByFloor(floor));
		});
		roomsPerFloor.forEach(room -> {
			itemsPerRoom.addAll(itemService.getAllByRoom(room));
		});
		itemsPerRoom.forEach(item -> System.out.println(item.getId()));
		return "pippo";
	}
	
	

}
