package main.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Customer;

public class CustomerView implements View{

	String nome;
	String cognome;
	String dataNascita;
	String username;
	String email;
	String password;
	String mode;
	Customer customer;
	Customer customer1;
	int id;
	List<Customer> customers; 
	
	public void showResults(Request request) {
		mode=request.get("mode").toString();
		if(mode.equals("Read"))
			customers= (List<Customer>) request.get("customers");
		else if(mode.equals("UpdateCustomer"))
			customer=(Customer) request.get("customer");
	}


	public void showOptions() {
		switch(mode) {
		case "InsertForm":
		  System.out.println("-------INSERISCI CUSTOMER-------");
		  System.out.println("");
		  System.out.println("");
		  System.out.println("Nome:");
		  this.nome=getInput();
		  System.out.println("Cognome:");
		  this.cognome=getInput();
		  System.out.println("Data di Nascita dd-MM-yyyy:");
		this.dataNascita=getInput();
		  System.out.println("Username:");
		  this.username=getInput();
		  System.out.println("Password:");
		  this.password=getInput();
		  customer= new Customer(nome, cognome, dataNascita, username, password);
		  	break;
		case "Read":
			customers.forEach(c ->System.out.println(c.getId()+"-"+c.getNome()+"-"+c.getCognome()+"-"+c.getDataNascita()));
			break;
		case "UpdateForm":
			System.out.println("Inserisci id del customer da modificare");
			this.id=Integer.parseInt(getInput());
			break;
			
		case "UpdateCustomer":
			System.out.println("Nome attuale: "+customer.getNome()+" inserisci nuovo nome: ");
			String nome= getInput();
			System.out.println("Cognome attuale: "+customer.getCognome()+" inserisci nuovo cognome: ");
			String cognome= getInput();
			System.out.println("Data di nascita attuale: "+customer.getDataNascita()+" inserisci nuova data di nascita: ");
			String datanascita= getInput();
			System.out.println("Username attuale: "+customer.getUsername()+" inserisci la nuova username: ");
			String username= getInput();
			System.out.println("Password attuale: "+customer.getPassword()+" inserisci nuova password: ");
			String password= getInput();
			customer1= new Customer(nome,cognome,datanascita,username,password);
			customer1.setId(customer.getId());
			break;
			
		case "DeleteForm":
			System.out.println("inserisci l'id del customer da cancellare");
			id=Integer.parseInt(getInput());
			
			break;
		}
		
		
		  
	}

	
	public String getInput() {
	    Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}

	@Override
	public void submit() {
		Request request=new Request();
		if(mode.equals("InsertForm")) {
			request.put("customer", customer);
			request.put("mode", "InsertDb");
			MainDispatcher.getInstance().callAction("Customer", "doControl", request);
		}
		else if(mode.equals("Read")) {
			System.out.println("mode "+mode);
			request.put("mode", "Return");
			MainDispatcher.getInstance().callAction("Customer", "doControl", request);
		}
		else if(mode.equals("UpdateForm")) {
			request.put("id", id);
			request.put("mode", "UpdateCustomer");
			MainDispatcher.getInstance().callAction("Customer","doControl", request);
		}
		else if(mode.equals("UpdateCustomer")) {
			request.put("mode", "SaveUpdate");
			request.put("customer", customer1);
			MainDispatcher.getInstance().callAction("Customer","doControl", request);
		}
		else if(mode.equals("DeleteForm")) {
			request.put("id", id);
			request.put("mode", "DeleteCustomer");
			MainDispatcher.getInstance().callAction("Customer", "doControl", request);
		}
	}

}
