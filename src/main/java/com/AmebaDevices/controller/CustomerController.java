package com.AmebaDevices.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.dto.NewCustomerDTO;
import com.AmebaDevices.services.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/Customer")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// CREATE -> TESTED
	@CrossOrigin
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public NewCustomerDTO newCustomer(
			@RequestParam(value = "userRole") String userRole,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password
	) {
		int role=Integer.parseInt(userRole);
		NewCustomerDTO customerDTO = new NewCustomerDTO(name, surname, email, username, password, role);
		customerDTO = customerService.insertCustomer(customerDTO);
		return customerDTO;

	}

	// READ -> TESTED
	@RequestMapping(value = "", method = RequestMethod.GET)
	public CustomerDTO getOne(@RequestParam(value = "customerId") long customerId) {
		CustomerDTO cdto = customerService.searchCustomer(customerId);
		return cdto;

	}

	// UPDATE -> TESTED
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public CustomerDTO updateCustomer(
			@RequestParam(value = "nome", required=false) String nome, 
			@RequestParam(value = "cognome", required=false) String cognome, 
			@RequestParam(value = "email", required=false) String email, 
			@RequestParam(value = "username", required=false) String username, 
			@RequestParam(value = "customerId") long customerId) {
		
		
		CustomerDTO cdto = customerService.searchCustomer(customerId);
		if (nome != null) {
			cdto.setNome(nome);
		}
		if (cognome != null) {
			cdto.setCognome(cognome);
		}
		
		if (email != null) {
			cdto.setEmail(email);
		}
		if (username != null) {
			cdto.setUsername(username);
		}
		
		cdto = customerService.updateCustomer(cdto);
		return cdto;
	}
	
	// DELETE -> TESTED
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public boolean delete(@RequestParam(value="customerId") long customerId) {
		customerService.deleteCustomer(customerId);
		return true;
	}

	/*
	
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertCustomer";
	}

	@RequestMapping(value = "/goBackSuper", method = RequestMethod.GET)
	public String goBackSuper(HttpServletRequest request) {
		return "superuserhome";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		CustomerDTO customer = new CustomerDTO();
		customer.setNome(request.getParameter("nome"));
		customer.setCognome(request.getParameter("cognome"));
		customer.setDataNascita(request.getParameter("dataDiNascita").toString());
		customer.setEmail(request.getParameter("email"));
		customer.setUsername(request.getParameter("username"));
		customer.setPassword(request.getParameter("password"));
		customer.setUserRole(2);
		customerService.insertCustomer(customer);
		return "GestioneCustomer";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		List<CustomerDTO> customers = customerService.readAll();
		model.addAttribute("customers", customers);
		return "readCustomers";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<CustomerDTO> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "updateCustomer";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idselected"));
		long l = id;
		CustomerDTO newcustomer = customerService.searchCustomer(l);
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

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<CustomerDTO> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "deletecustomer";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idDelete = Integer.parseInt(request.getParameter("idselected"));
		long l = idDelete;
		customerService.deleteCustomer(l);
		return "GestioneCustomer";
	}

	@RequestMapping(value = "/goBack", method = RequestMethod.GET) // cambiare return con goBack
	public String goBack(HttpServletRequest request) {
		return "GestioneCustomer";
	}

	
	*/

}
