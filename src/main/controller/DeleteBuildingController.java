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
		newRequest.put("buildings", new BuildingService().getAll(username));
		if (new BuildingService().delete(building, username)) {
			newRequest.put("buildings", new BuildingService().getAll(username));
			newRequest.put("username", username);
			MainDispatcher.getInstance().callView("BuildingMenu", newRequest);
		} else {
			newRequest.put("buildings", new BuildingService().getAll(username));
			newRequest.put("username", username);
			MainDispatcher.getInstance().callView("DeleteBuilding", newRequest);
		}
	}

}
