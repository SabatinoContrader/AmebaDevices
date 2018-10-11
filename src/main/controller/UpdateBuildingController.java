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
		System.err.println(building.getIndirizzo() + " "
				+ building.getCap()+ " "
				+building.getCitta()+" "
				+building.getInterno());
		System.err.println(newValues.getIndirizzo() + " "
				+ newValues.getCap()+ " "
				+newValues.getCitta()+" "
				+newValues.getInterno());
		System.err.println(username);
		if (new BuildingService().update(building, newValues, username)) {
			newRequest.put("nomeUtente", username);
			newRequest.put("choice", 2);
			MainDispatcher.getInstance().callView("Home", newRequest);
		} else {
			
			newRequest.put("username", username);
			newRequest.put("mode", "update");
			MainDispatcher.getInstance().callView("BuildingPanel", newRequest);
		}

	}

}
