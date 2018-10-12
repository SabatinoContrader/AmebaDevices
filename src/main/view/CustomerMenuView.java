package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Customer;

public class CustomerMenuView implements View {

	private int choice;
	List<Customer> customers;
	
	@Override
	public void showResults(Request request) {
		customers=(List<Customer>) request.get("customers");
		customers.forEach(c->System.out.println(c.getId()+"-"+c.getNome()+"-"+c.getCognome()+"-"+c.getDataNascita()+"-"+c.getUsername()));
		System.out.println("");
	}

	@Override
	public void showOptions() {
		System.out.println("1) Inserisci customer");
    	System.out.println("2) Visualizza customers");
    	System.out.println("3) Modifica customer");
    	System.out.println("4) Elimina customer");
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
		
		if (choice < 1 || choice > 5) 
            MainDispatcher.getInstance().callAction("SuperUserHome", "doControl", request);
    else if (choice == 5)
        MainDispatcher.getInstance().callAction("Login", "doControl", null);
    else if(choice==1) {
        request.put("mode", "InsertForm");
    	 MainDispatcher.getInstance().callAction("Customer", "doControl", request);
    }
    else if(choice==2) {
    	request.put("mode", "Read");
    	MainDispatcher.getInstance().callAction("Customer", "doControl", request);
    }
    else if(choice==3) {
    	request.put("mode","UpdateForm");
    	MainDispatcher.getInstance().callAction("Customer", "doControl", request);
    }
    else if(choice==4) {
    	request.put("mode", "DeleteForm");
    	MainDispatcher.getInstance().callAction("Customer", "doControl", request);
    }
		
	}

}
