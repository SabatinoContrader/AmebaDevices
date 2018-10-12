package main.controller;

import main.MainDispatcher;
import main.model.Building;
import main.service.BuildingService;

public class UpdateBuildingController implements Controller {

	@Override
	public void doControl(Request request) {
		Request newRequest = new Request();
		Building building = (Building) request.get("toUp");
		Building newValues = (Building) request.get("newValues");
		String username = request.get("username").toString();
		if (new BuildingService().update(building, newValues, username)) {
			newRequest.put("username", username);
			newRequest.put("buildings", new BuildingService().getAll(username));
			MainDispatcher.getInstance().callView("BuildingMenu", newRequest);
		} else {
			newRequest.put("username", username);
			newRequest.put("buildings", new BuildingService().getAll(username));
			MainDispatcher.getInstance().callView("UpdateBuilding", newRequest);
		}

	}

}
