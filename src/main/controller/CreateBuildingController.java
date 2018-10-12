package main.controller;

import main.MainDispatcher;
import main.model.Building;
import main.service.BuildingService;

public class CreateBuildingController implements Controller {

	@Override
	public void doControl(Request request) {
		
		String username = request.get("username").toString();
	
		Building myNewBuilding = (Building) request.get("building");
			
		Request newRequest = new Request();
		if ( new BuildingService().create(username, myNewBuilding) ) {
			
			newRequest.put("username", username);
			newRequest.put("buildings", new BuildingService().getAll(username));
			MainDispatcher.getInstance().callView("BuildingMenu", newRequest); 
			
		} else {
			newRequest.put("username", username);
			MainDispatcher.getInstance().callView("InsertBuilding", newRequest);
		}

	}

}
