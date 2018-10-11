package main.controller;

import main.MainDispatcher;

public class MenuController implements Controller {
	String mode;

	public MenuController() {
		
	}
	
	@Override
	public void doControl(Request request) {
		mode = request.get("mode").toString();
		
		switch(mode) {
		case "CustomerMenu":
			MainDispatcher.getInstance().callView("CustomerMenu", null);
			break;
		case "BuildingMenu":
			MainDispatcher.getInstance().callView("BuildingMenu", null);
			break;
		}
		
	}

}
