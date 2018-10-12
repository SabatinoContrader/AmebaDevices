package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Customer;
import main.service.CustomerService;

public class CustomerController implements Controller {
	private CustomerService customerService;
	private Customer customer;
	private List<Customer> customers;
	
	public CustomerController() {
		customerService=new CustomerService();
	}
	
	String mode="";

	public void doControl(Request request) {
		
		mode=request.get("mode").toString();
		switch(mode) {
		case "InsertForm":
			request=new Request();
			MainDispatcher.getInstance().callView("InsertCustomer", request);
			break;
		case "InsertDb":
			customer= (Customer) request.get("customer");
			if(customerService.insertCustomer(customer)) {
				request=new Request();
				customers=customerService.readAll();
				request.put("customers", customers);
				MainDispatcher.getInstance().callView("CustomerMenu", request);
			}else {
			request=new Request();
			request.put("choice", "InsertForm");
			MainDispatcher.getInstance().callView("InsertCustomer", request);
			}
			break;
		case "Read":
			List<Customer> customers= customerService.readAll();
			request= new Request();
			request.put("choice", 1);
			request.put("customers",customers);
			request.put("mode", "Read");
			MainDispatcher.getInstance().callView("CustomerMenu", request);
			break;
		
		
		case "Return":
			request= new Request();
			MainDispatcher.getInstance().callView("SuperUserHome", request);
			break;
			
		case "UpdateForm":
			request= new Request();
			customers= customerService.readAll();
			request.put("mode", "UpdateForm");
			request.put("customers",customers);
			MainDispatcher.getInstance().callView("UpdateCustomer", request);
			break;
		
		case "UpdateCustomer":
			int id=Integer.parseInt(request.get("id").toString());
			Customer customer=customerService.searchCustomer(id);
			switch(Integer.parseInt(request.get("field").toString())) {
				case 1:
					customer.setNome(request.get("value").toString());
					break;
				case 2:
					customer.setCognome(request.get("value").toString());
					break;
				case 3:
					customer.setDataNascita(request.get("value").toString());
					break;
				case 4:
					customer.setUsername(request.get("value").toString());
					break;
				case 5:
					customer.setPassword(request.get("value").toString());
					break;
				default:
					break;
			}
			customerService.updateCustomer(customer);
			customers=customerService.readAll();
			request=new Request();
			request.put("customers", customers);
			MainDispatcher.getInstance().callView("CustomerMenu", request);
			break;
		case "SaveUpdate":
			Customer customer1=(Customer) request.get("customer");
			customerService.updateCustomer(customer1);
			MainDispatcher.getInstance().callView("SuperUserHome", request);
			break;
			
		case "DeleteForm":
			request=new Request();
			customers=customerService.readAll();
			request.put("mode", "DeleteForm");
			request.put("customers", customers);
			MainDispatcher.getInstance().callView("DeleteCustomer", request);
			break;
		
		case "DeleteCustomer":
			int id1= Integer.parseInt(request.get("id").toString());
			customerService.deleteCustomer(id1);
			customers=customerService.readAll();
			request=new Request();
			request.put("customers", customers);
			MainDispatcher.getInstance().callView("CustomerMenu", request);
			break;
			
		case "GenerateXML":
			
		
		}
		
		
		  
	}

}
