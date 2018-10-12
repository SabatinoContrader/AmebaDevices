package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Customer;

public class InsertCustomerView implements View{

	private Request request;
	Customer customer;
	
	@Override
	public void showResults(Request request) {
		this.request=request;
	}

	@Override
	public void showOptions() {
		  System.out.println("-------INSERISCI CUSTOMER-------");
		  System.out.println("");
		  System.out.println("");
		  System.out.println("Nome:");
		  String nome=getInput();
		  System.out.println("Cognome:");
		  String cognome=getInput();
		  System.out.println("Data di Nascita dd-MM-yyyy:");
		  String dataNascita=getInput();
		  System.out.println("Username:");
		  String username=getInput();
		  System.out.println("Password:");
		  String password=getInput();
		  customer= new Customer(nome, cognome, dataNascita, username, password);
	}

	@Override
	public String getInput() {
	    Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}

	@Override
	public void submit() {
		request= new Request();
		request.put("mode", "InsertDb");
		request.put("customer", customer);
		MainDispatcher.getInstance().callAction("Customer", "doControl", request);
	}

}
