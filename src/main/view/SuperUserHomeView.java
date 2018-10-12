package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class SuperUserHomeView implements View {
	
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
	  	this.request=request;
	}

	@Override
	public void showOptions() {
		System.out.println("1) Vai in gestione Customer");
    	System.out.println("2) Logout");
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
		if(choice < 1 || choice > 2) {
			MainDispatcher.getInstance().callAction("SuperUserHome", "doControl", request);
		} else if (choice == 2) {
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else if (choice==1){
            request.put("mode", "CustomerMenu");
            MainDispatcher.getInstance().callAction("Menu", "doControl", request);
		}
	}

}
