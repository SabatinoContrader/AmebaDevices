package com.AmebaDevices.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.CustomerService;

@Controller
@RequestMapping("/Customer")
public class CustomerController  {

	private CustomerService customerService;
	@Autowired
	public CustomerController(CustomerService customerService) {
	this.customerService=customerService;
	}
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String retur(HttpServletRequest request) {
		System.out.println("ciao");
		return "index";
	}
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(HttpServletRequest request) {
		System.out.println("ojojohjiybvyg");
		String nomeUtente = request.getParameter("username");
		String password = request.getParameter("password");
		request.getSession().setAttribute("username", nomeUtente);
		System.out.println(nomeUtente+"-"+password);
		int userId = customerService.login(nomeUtente, password);
		request.getSession().setAttribute("userId", userId);

		if (userId == 1) {
			return "superuserhome";
		} else if (userId == 2) {
			BuildingService buildingService = new BuildingService();
			List <Building> myBuildings = buildingService.getAll((String) request.getSession().getAttribute("username"));
			request.setAttribute("buildings", myBuildings);
			return "CustomerHome";
		} else {
			return "index";
		}

	}
	
	
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertCustomer";
	} 
	@RequestMapping(value="/goBackSuper", method=RequestMethod.GET)
	public String goBackSuper(HttpServletRequest request) {
		return "superuserhome";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String data = request.getParameter("dataDiNascita").toString();
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer customer = new Customer(nome, cognome, data, email, username, password,2);
		customerService.insertCustomer(customer);
		return "GestioneCustomer";
	} 
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(HttpServletRequest request) {
		List<Customer> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "readCustomers";
	}
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<Customer> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "updateCustomer";
	} 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idselected"));
		Customer newcustomer = customerService.searchCustomer(id);
		System.out.println(request.getParameter("selected"));
		switch (Integer.parseInt(request.getParameter("selected"))) {
		case 1:
			newcustomer.setNome(request.getParameter("value"));
			break;
		case 2:
			newcustomer.setCognome(request.getParameter("value"));
			break;
		case 3:
			newcustomer.setDataNascita(request.getParameter("value"));
			break;
		case 4:
			newcustomer.setUsername(request.getParameter("value"));
			break;
		case 5:
			newcustomer.setPassword(request.getParameter("value"));
			break;
		default:
			break;
		}
		customerService.updateCustomer(newcustomer);
		return "GestioneCustomer";
	} 
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<Customer> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "deletecustomer";
	} 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idDelete = Integer.parseInt(request.getParameter("idselected"));
		customerService.deleteCustomer(idDelete);
		return "GestioneCustomer";
	} 
	
	@RequestMapping(value="/goBack", method=RequestMethod.GET)   // cambiare return con goBack
	public String goBack(HttpServletRequest request) {
		return "GestioneCustomer";
	} 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customerControl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	String mode = request.getParameter("mode");
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.readAll();
		switch (mode) {
		case "InsertForm":
			getServletContext().getRequestDispatcher("/insertCustomer.jsp").forward(request, response);
			break;
		case "InsertDb":
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String data = request.getParameter("dataDiNascita").toString();
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Customer customer = new Customer(nome, cognome, data, email, username, password);
			customerService.insertCustomer(customer);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "Read":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/readCustomers.jsp").forward(request, response);
			break;
		case "Return":
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "UpdateForm":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
			break;
		case "UpdateDb":
			int id = Integer.parseInt(request.getParameter("idselected"));
			customer = customerService.searchCustomer(id);
			System.out.println(request.getParameter("selected"));
			switch (Integer.parseInt(request.getParameter("selected"))) {
			case 1:
				customer.setNome(request.getParameter("value"));
				break;
			case 2:
				customer.setCognome(request.getParameter("value"));
				break;
			case 3:
				customer.setDataNascita(request.getParameter("value"));
				break;
			case 4:
				customer.setUsername(request.getParameter("value"));
				break;
			case 5:
				customer.setPassword(request.getParameter("value"));
				break;
			default:
				break;
			}
			customerService.updateCustomer(customer);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "DeleteForm":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/deletecustomer.jsp").forward(request, response);
			break;
		case "DeleteDb":
			int idDelete = Integer.parseInt(request.getParameter("idselected"));
			customerService.deleteCustomer(idDelete);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	doGet(request, response);
	}

}
