package main.view;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;


public class ItemMenuView implements View {
	private int choice;
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		System.out.println("1) Inserisci item");
        System.out.println("2) Visualizza item");
        System.out.println("3) Modifica item");
        System.out.println("4) Elimina item");
        System.out.println("5) Logout");
        this.choice = Integer.parseInt(getInput());
	}

	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();	
        }

	@Override
	public void submit() {
		 if (this.choice < 1 || this.choice > 5)
	            MainDispatcher.getInstance().callAction("Home", "doControl", null);
	        else if (this.choice == 5)
	            MainDispatcher.getInstance().callAction("Login", "doControl", null);
	        else if(choice==1) {
	        	Request request = new Request();
	            request.put("mode", "InsertForm");
	            MainDispatcher.getInstance().callAction("Item", "doControl", request);
	        }
	        else if(choice==2) {
	        	Request request = new Request();
	            request.put("mode", "Read");
	            MainDispatcher.getInstance().callAction("Item", "doControl", request);
	        }
	        
	        else if(choice==3) {
	        	Request request= new Request();
	        	request.put("mode", "UpdateForm");
	        	MainDispatcher.getInstance().callAction("Item", "doControl", request);
	        }
	        
	        else if(choice==4) {
	        	Request request= new Request();
	        	request.put("mode", "DeleteForm");
	        	MainDispatcher.getInstance().callAction("Item", "doControl", request);
	        }
	        
	        else if(choice==5) {
	        	Request request= new Request();
	        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
	        }
	        
	    
	}

}
