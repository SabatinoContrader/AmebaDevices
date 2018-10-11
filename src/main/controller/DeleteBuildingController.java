package main.controller;

import main.MainDispatcher;
import main.model.Building;
import main.service.BuildingService;

public class DeleteBuildingController implements Controller {

	@Override
	public void doControl(Request request) {
		Request newRequest = new Request();
		Building building = (Building) request.get("toDeleteBuilding");
		String username = request.get("username").toString();
		
		if (new BuildingService().delete(building, username)) {
			newRequest.put("nomeUtente", username);
			newRequest.put("choice", 2);
			MainDispatcher.getInstance().callView("Home", newRequest);
		} else {
			
			newRequest.put("username", username);
			newRequest.put("mode", "delete");
			MainDispatcher.getInstance().callView("BuildingPanel", newRequest);
		}
	}

}
