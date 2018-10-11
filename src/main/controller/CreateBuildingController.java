package main.controller;

import main.MainDispatcher;
import main.model.Building;
import main.service.BuildingService;

public class CreateBuildingController implements Controller {

	@Override
	public void doControl(Request request) {
		
		String username = request.get("username").toString();
		String city = request.get("city").toString();
		String address = request.get("address").toString();
		String cap = request.get("cap").toString();
		String interno = request.get("interno").toString();
		Building myNewBuilding = new Building();
		
		myNewBuilding.setCap(cap);
		myNewBuilding.setCitta(city);
		myNewBuilding.setIndirizzo(address);
		myNewBuilding.setInterno(interno);
		
		Request newRequest = new Request();
		if ( new BuildingService().create(username, myNewBuilding) ) {
			
			newRequest.put("nomeUtente", username);
			newRequest.put("choice", 2);
			MainDispatcher.getInstance().callView("Home", newRequest); 
			
		} else {
			newRequest.put("username", username);
			newRequest.put("mode", "create");
			MainDispatcher.getInstance().callView("BuildingPanel", newRequest);
		}

	}

}
