package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Customer;
import main.service.BuildingService;
import main.service.CustomerService;

public class MenuController implements Controller {
	private String mode;
	private Request request;
	private String username;
	
	public MenuController() {
		
	}
	
	@Override
	public void doControl(Request request) {
		this.request=request;
		mode = request.get("mode").toString();
		username=request.get("username").toString();
		this.request=new Request();
		switch(mode) {
		case "CustomerMenu":
			CustomerService customerService= new CustomerService();
			List<Customer> customers= customerService.readAll();
			request.put("customers", customers);
			MainDispatcher.getInstance().callView("CustomerMenu", request);
			break;
		case "BuildingMenu":
			request.put("username", username);
			request.put("buildings", new BuildingService().getAll(username));
			MainDispatcher.getInstance().callView("BuildingMenu", request);
			break;
		}
		
	}

}
