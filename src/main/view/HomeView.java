package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String userRole;
    private Request request;

    public void showResults(Request request) {
    	if(Integer.parseInt(request.getString("choice").toString())==1) 	
    		userRole="SUPERUSER";
    	else 
    		userRole="CUSTOMER";
       	this.request=request;
}


    public void showOptions() {
        System.out.println("Benvenuto in ContraderFramework");
        System.out.println("");
        System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        if(userRole.equals("SUPERUSER")) {
        	System.out.println("1) Vai in gestione Customer");
        	System.out.println("2) Logout");
        } else {
        	System.out.println("1) Vai a gestione building");
        	System.out.println("2) Vai a gestione item");
        	System.out.println("3) Logout");
        }
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
    	Request request = new Request();
    	
    	if(userRole.equals("SUPERUSER")) {
    		if(choice < 1 || choice > 2) {
    			MainDispatcher.getInstance().callAction("Home", "doControl", request);
    		} else if (choice == 2) {
    			MainDispatcher.getInstance().callAction("Login", "doControl", null);
    		} else if (choice==1){
                request.put("mode", "CustomerMenu");
                MainDispatcher.getInstance().callAction("Menu", "doControl", request);
    		}
    	} else {
    		if(choice < 1 || choice > 3) {
    			MainDispatcher.getInstance().callAction("Home", "doControl", request);
    		} 
    		else if (choice == 3) {
    			MainDispatcher.getInstance().callAction("Login", "doControl", null);
    		} 
    		else if (choice == 1) {
                request.put("mode", "BuildingMenu");
                MainDispatcher.getInstance().callAction("Menu", "doControl", request);
    		}
    		else if (choice == 2) {
                request.put("mode", "ItemMenu");
    		}
    	}
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
