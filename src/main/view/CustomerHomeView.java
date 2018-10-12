package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class CustomerHomeView implements View {

	private Request request;
	private int choice;
	private String username;
	
	@Override
	public void showResults(Request request) {
	  	this.request=request;
	  	username=request.get("username").toString();
	}

	@Override
	public void showOptions() {
		System.out.println("1) Vai a gestione building");
    	System.out.println("2) Vai a gestione item");
    	System.out.println("3) Logout");
    	this.choice = Integer.parseInt(getInput());
	}

	@Override
	public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

	@Override
	public void submit() {
		Request request = new Request();
		if(choice < 1 || choice > 3) {
			MainDispatcher.getInstance().callAction("Home", "doControl", request);
		} 
		else if (choice == 1) {
            request.put("mode", "BuildingMenu");
            request.put("username",username);
            MainDispatcher.getInstance().callAction("Menu", "doControl", request);
		}
		else if (choice == 2) {
            request.put("mode", "ItemMenu");
		}
		else if (choice == 3) {
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} 
	}

}
