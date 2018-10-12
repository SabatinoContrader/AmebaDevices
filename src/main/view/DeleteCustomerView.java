package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Customer;

public class DeleteCustomerView implements View {

	private Request request;
	private List<Customer> customers;
	private int id;
	
	@Override
	public void showResults(Request request) {
		this.request=request;
		customers=(List<Customer>) request.get("customers");
		customers.forEach(c->System.out.println(c.getId()+"-"+c.getNome()+"-"+c.getCognome()+"-"+c.getDataNascita()+"-"+c.getUsername()));
	}

	@Override
	public void showOptions() {
		System.out.println("Quale customer vuoi eliminare?");
		id=Integer.parseInt(getInput());
		
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
		request.put("mode", "DeleteCustomer");
		MainDispatcher.getInstance().callAction("Customer","doControl", request);
		
	}

}
