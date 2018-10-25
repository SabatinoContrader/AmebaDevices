package com.AmebaDevices.controller;

import java.io.IOException;
import java.util.List;

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
import com.AmebaDevices.services.LoginService;

@Controller
@RequestMapping("")
public class Login {

	private LoginService loginService;
	private BuildingService buildingService;
	private CustomerService customerService;

	@Autowired
	public Login(CustomerService cs) {
		System.out.println("wewe");
		loginService = new LoginService();
		customerService = cs;
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
		long userId = loginService.login(nomeUtente, password);
		request.getSession().setAttribute("userId", userId);

		if (userId == 1) {
			return "superuserhome";
		} else if (userId == 2) {
			List <Building> myBuildings = buildingService.getAll((String)request.getSession().getAttribute("username"));
			request.setAttribute("buildings", myBuildings);
			return "CustomerHome";
		} else {
			return "index";
		}

	}

}
