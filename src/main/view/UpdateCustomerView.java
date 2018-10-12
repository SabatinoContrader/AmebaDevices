package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Customer;

public class UpdateCustomerView implements View {

	private List<Customer> customers;
	private int id;
	private int field;
	private String value;
	private Request request;
	
	@Override
	public void showResults(Request request) {
		this.request=request;
		customers=(List<Customer>) request.get("customers");
		customers.forEach(c->System.out.println(c.getId()+"-"+c.getNome()+"-"+c.getCognome()+"-"+c.getDataNascita()+"-"+c.getUsername()));
	
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci id del customer da modificare gentilmente");
		this.id=Integer.parseInt(getInput());
		System.out.println("Quale campo vuoi modificare?");
		System.out.println("1) Nome");
		System.out.println("2) Cognome");
		System.out.println("3) Data di Nascita dd-MM-yyyy:");
		System.out.println("4) Username");
		System.out.println("5) Password");
		field=Integer.parseInt(getInput());
		System.out.println("Inserisci nuovo valore");
		value=getInput();
	}

	@Override
	public String getInput() {
	    Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}
	@Override
	public void submit() {
		request= new Request();
		request.put("id", id);
		request.put("field", field);
		request.put("value", value);
		request.put("mode", "UpdateCustomer");
		MainDispatcher.getInstance().callAction("Customer","doControl", request);
	}

}
