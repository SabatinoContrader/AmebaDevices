package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Customer;
import main.service.CustomerService;

public class CustomerController implements Controller {
	CustomerService customerService;
	Customer customer;
	
	public CustomerController() {
		customerService=new CustomerService();
	}
	
	String mode="";

	public void doControl(Request request) {
		
		mode=request.get("mode").toString();
		switch(mode) {
		case "InsertForm":
			request=new Request();
			request.put("mode", mode);
			MainDispatcher.getInstance().callView("Customer", request);
			break;
		case "InsertDb":
			customer= (Customer) request.get("customer");
			if(customerService.insertCustomer(customer)) {
				request=new Request();
				request.put("choice", 1);
				MainDispatcher.getInstance().callView("Home", request);
			}else {
			System.out.println("Dati mancanti o utente già registrato");
			request=new Request();
			request.put("choice", "InsertForm");
			MainDispatcher.getInstance().callView("Customer", request);
			}
			break;
		case "Read":
			List<Customer> customers= customerService.readAll();
			request= new Request();
			request.put("choice", 1);
			request.put("customers",customers);
			request.put("mode", "Read");
			MainDispatcher.getInstance().callView("Customer", request);
			break;
		
		
		case "Return":
			request= new Request();
			request.put("choice", 1);
			MainDispatcher.getInstance().callView("Home", request);
			break;
			
		case "UpdateForm":
			request= new Request();
			request.put("mode", "UpdateForm");
			MainDispatcher.getInstance().callView("Customer", request);
			break;
		
		case "UpdateCustomer":
			int id=Integer.parseInt(request.get("id").toString());
			Customer customer=customerService.searchCustomer(id);
			if(customer==null) {
				System.out.println("Id non valido");
				request.put("choice", 1);
				MainDispatcher.getInstance().callView("Home", request);}
			else {
				System.out.println(customer.getNome()+" "+customer.getCognome());
				request= new Request();
				request.put("mode", "UpdateCustomer");
				request.put("customer", customer);
				MainDispatcher.getInstance().callView("Customer", request);
				}
			break;
			
		case "SaveUpdate":
			Customer customer1=(Customer) request.get("customer");
			customerService.updateCustomer(customer1);
			request.put("choice", 1);
			MainDispatcher.getInstance().callView("Home", request);
			break;
			
		case "DeleteForm":
			request=new Request();
			request.put("mode", "DeleteForm");
			MainDispatcher.getInstance().callView("Customer", request);
			break;
		
		case "DeleteCustomer":
			int id1= Integer.parseInt(request.get("id").toString());
			customerService.deleteCustomer(id1);
			request.put("choice", 1);
			MainDispatcher.getInstance().callView("Home", request);
			break;
		
		}
		
		
		  
	}

}
