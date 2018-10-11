package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class BuildingMenuView implements View {
	
	private int choice;

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		System.out.println("1) Inserisci building");
    	System.out.println("2) Visualizza buildings");
    	System.out.println("3) Modifica building");
    	System.out.println("4) Elimina building");
    	System.out.println("5) Logout");
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
		
		switch (choice) {
        case 1:
        case 2: 
        case 3: 
        case 4:
        	// Viene richiamato il BuildingController per le operazioni CRUD
        	Request newRequest = new Request();
        	newRequest.put("choice", choice);
        	String prova=request.get("nomeUtente").toString();
        	System.out.println(prova);
        	newRequest.put("username", request.get("nomeUtente").toString());
        	System.out.println("username="+ request.get("nomeUtente").toString());
        	System.out.println("sono nel caso 4");
        	System.out.println("nomeUtente="+request.get("nomeUtente").toString());
        	
        	MainDispatcher.getInstance().callAction("Building", "doControl", newRequest);
        	break;
        case 5:
        	 MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        default:
        	 MainDispatcher.getInstance().callAction("Home", "doControl", request);
        	break; 
        }
		
	}

}
