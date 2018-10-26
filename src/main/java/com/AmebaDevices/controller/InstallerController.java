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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.CustomerService;

@Controller
@RequestMapping("/Installer")
public class InstallerController{

	private CustomerService customerService;
	@Autowired
	public InstallerController(CustomerService customerService) {
	this.customerService=customerService;
	}
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertInstaller";
	} 
	@RequestMapping(value="/goBackSuper", method=RequestMethod.GET)
	public String goBackSuper(HttpServletRequest request) {
		return "superuserhome";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		CustomerDTO customer = new CustomerDTO();
		customer.setNome(request.getParameter("nome"));
		customer.setCognome(request.getParameter("cognome"));
		customer.setDataNascita(request.getParameter("dataDiNascita").toString());
		customer.setEmail(request.getParameter("email"));
		customer.setUsername(request.getParameter("username"));
		customer.setPassword(request.getParameter("password"));
		customer.setUserRole(3);
		customerService.insertCustomer(customer);
		return "InstallerMenu";
	} 
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		List<CustomerDTO> installers = customerService.readInstallers();
		model.addAttribute("installers", installers);
		return "readInstaller";
	}
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<CustomerDTO> installers = customerService.readInstallers();
		request.setAttribute("customers", installers);
		return "UpdateInstaller";
	} 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idselected"));
		long l=id;
		CustomerDTO newcustomer = customerService.searchCustomer(l);
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
		return "InstallerMenu";
	} 
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<CustomerDTO> installers = customerService.readInstallers();
		request.setAttribute("installers", installers);
		return "deleteInstaller";
	} 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idDelete = Integer.parseInt(request.getParameter("idselected"));
		long l=idDelete;
		customerService.deleteCustomer(l);
		return "InstallerMenu";
	} 
	
	@RequestMapping(value="/goBack", method=RequestMethod.GET)  
	public String goBack(HttpServletRequest request) {
		return "InstallerMenu";
	} 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customerControl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
