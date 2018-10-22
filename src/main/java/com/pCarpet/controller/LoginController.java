package com.pCarpet.controller;

import com.pCarpet.model.User;
import com.pCarpet.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Login")
public class LoginController {

	private UserService userService;
	private User user;
	private HttpSession session;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request, Model model ) {
		this.session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		if (this.userService.login(username, password)) {
			System.out.println("Loggato");
			this.user = this.userService.getLoggedUser(username, password);
			session.setAttribute("user", this.user);
			if (this.user.getRuolo().equals("segretaria")) {
				return "homeSegretaria";
			}	
			else if (this.user.getRuolo().equals("cliente")) {
				return "homeCliente";
			}
			else if (this.user.getRuolo().equals("amministratore")) {
				return "homeAdmin";
			}	
			else {
				return "index";
			}	
		}
		else {
			model.addAttribute("feedback", "wrong");
			return "index";
		}
	}
	
	@RequestMapping(value = "/logoutControl", method = RequestMethod.GET)
	public String logoutControl(HttpServletRequest request, Model model ) {
		this.session.invalidate();
		return "index";
	}
	
	public HttpSession getSession() {
		return this.session;
	}
}
