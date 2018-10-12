package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Building;

public class InsertBuildingView implements View {

	private Request request;
	private Building building;
	private String username;
	
	@Override
	public void showResults(Request request) {
		this.request=request;
		username=request.get("username").toString();
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci indirizzo del building: ");
		String address = this.getInput();
		System.out.println("Inserisci interno del building");
		String interno = this.getInput();
		System.out.println("Inserisci citta' del building: ");
		String city = this.getInput();
		System.out.println("Inserisci cap del building: ");
		String cap = this.getInput();
		building= new Building(address,city,cap,interno);
	
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("username", username);
		request.put("building", building);
		MainDispatcher.getInstance().callAction("CreateBuilding", "doControl", request);
	}

}
