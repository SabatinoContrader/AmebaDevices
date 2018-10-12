package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Building;
import main.service.BuildingService;

public class BuildingController implements Controller {

	private BuildingService buildingService;
	
	private String username;
	private int choice;
	
	@Override
	public void doControl(Request request) {
		List <Building> buildings;
		buildingService = new BuildingService();
		this.username = request.get("username").toString();
		this.choice = (int) request.get("choice");
		buildings = buildingService.getAll(username);
		Request newRequest = new Request();
		newRequest.put("username", this.username);
		newRequest.put("buildings", buildings);
		switch(this.choice) {
			
			case 1: // create	
				newRequest.put("mode", "create");
				MainDispatcher.getInstance().callView("InsertBuilding", newRequest);
				break;
			case 2: // read
				newRequest.put("mode", "read");
				MainDispatcher.getInstance().callView("BuildingMenu", newRequest);
				break;
			case 3: // update
				newRequest.put("mode", "update");
				MainDispatcher.getInstance().callView("UpdateBuilding", newRequest);
				
				break;
			case 4: // delete
				newRequest.put("mode", "delete");
				MainDispatcher.getInstance().callView("DeleteBuilding", newRequest);
				break;
			default:
				break;
			
		}

	}

}
