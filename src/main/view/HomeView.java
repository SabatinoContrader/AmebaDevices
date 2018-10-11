package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

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
        /*if(userRole.equals("SUPERUSER")) {
        	System.out.println("1) Inserisci customer");
        	System.out.println("2) Visualizza customers");
        	System.out.println("3) Modifica customer");
        	System.out.println("4) Elimina customer");
        }else {
        	System.out.println("1) Inserisci building");
        	System.out.println("2) Visualizza buildings");
        	System.out.println("3) Modifica building");
        	System.out.println("4) Elimina building");
        }*/
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
                //MainDispatcher.getInstance().callAction("Customer", "doControl", request);
    		}
    	}
    	/*if(userRole.equals("SUPERUSER")) {
    		System.out.println("okok");
        if (choice < 1 || choice > 5) 
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
        else if (choice == 5)
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else if(choice==1) {
        	Request request = new Request();
            request.put("mode", "InsertForm");
            
        	 MainDispatcher.getInstance().callAction("Customer", "doControl", request);
        }
        else if(choice==2) {
        	Request request= new Request();
        	request.put("mode", "Read");
        	MainDispatcher.getInstance().callAction("Customer", "doControl", request);
        }
        else if(choice==3) {
        	Request request = new Request();
        	request.put("mode","UpdateForm");
        	MainDispatcher.getInstance().callAction("Customer", "doControl", request);
        }
        else if(choice==4) {
        	Request request= new Request();
        	request.put("mode", "DeleteForm");
        	MainDispatcher.getInstance().callAction("Customer", "doControl", request);
        }
    	}else {
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
    	}*/
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
