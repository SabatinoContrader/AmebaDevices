package com.AmebaDevices.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.CustomerService;

@RestController
@RequestMapping("/user")
public class Login {

	private BuildingService buildingService;
	private CustomerService customerService;

	@Autowired
	public Login(CustomerService cs, BuildingService bs) {
		customerService = cs;
		buildingService = bs;
	}

	@RequestMapping(value="/login", method= RequestMethod.POST)
	public CustomerDTO login
	(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password
	) {
		CustomerDTO customerDTO = customerService.login(username, password);
		return customerDTO;
	}
	
	/*@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(HttpServletRequest request) {
	
		String nomeUtente = request.getParameter("username");
		String password = request.getParameter("password");
		request.getSession().setAttribute("username", nomeUtente);
		long userRole = customerService.login(nomeUtente, password);
		if (userRole== 1) {
			return "superuserhome";
		} else if (userRole == 2) {
			List <BuildingDTO> myBuildings = buildingService.getAll((String) request.getSession().getAttribute("username"));
			request.setAttribute("buildings", myBuildings);
			return "CustomerHome";	
		} else if (userRole == 3) {
			List <BuildingDTO> buildings = buildingService.findByInstaller((String) request.getSession().getAttribute("username"));
			CustomerDTO cDTO = customerService.findByUsername((String) request.getSession().getAttribute("username"));
			request.setAttribute("installer", cDTO);
			request.setAttribute("buildings", buildings);
			return "installerHome";
		}
		
		else {
			return "index";
		}

	}*/

}
