package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Building;

public class BuildingMenuView implements View {
	
	private int choice;
	private Request request;
	private String username;

	@Override
	public void showResults(Request request) {
		this.request=request;
		this.username=request.get("username").toString();
		List<Building> buildings= (List<Building>) request.get("buildings");
	
			System.out.println("----------ciao, " + username + " questi sono i tuoi buildings ----------");
			if (buildings.size() == 0)
				System.out.println(" ");
			for (int i = 0; i < buildings.size(); i++) {
				System.out.println(i + 1 + ") " + buildings.get(i).getIndirizzo() + " " + buildings.get(i).getCap()
						+ " " + buildings.get(i).getCitta() + " " + buildings.get(i).getInterno());
			}
			System.out.println("-----------------------------------------------------------");
	}

	@Override
	public void showOptions() {
		System.out.println("1) Inserisci building");
    	System.out.println("2) Visualizza buildings");
    	System.out.println("3) Modifica building");
    	System.out.println("4) Elimina building");
    	System.out.println("6) Logout");
    	this.choice = Integer.parseInt(getInput());
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}

	@Override
	public void submit() {
		Request request = new Request();
		
		if(choice>0 && choice <5) {
			// Viene richiamato il BuildingController per le operazioni CRUD
        	request = new Request();
        	request.put("choice", choice);
        	request.put("username", username);
          	MainDispatcher.getInstance().callAction("Building", "doControl", request);
		}
		else { MainDispatcher.getInstance().callAction("Menu", "doControl", request);}
		
		
	}

}
