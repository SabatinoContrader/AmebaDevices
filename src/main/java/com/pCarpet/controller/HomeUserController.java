package com.pCarpet.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pCarpet.model.User;
import com.pCarpet.services.UserService;

@Controller
@RequestMapping("/HomeUser")
public class HomeUserController {
	
	private UserService userService;
	private boolean isLogged = false;

	@Autowired
	public HomeUserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
	public String loginControl(HttpServletRequest request, Model model ) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
				
		String choice=request.getParameter("choice");
		if(choice != null) {
			switch(choice) {
		
				case "managementUsers":
					return "managementUser";
				
				case "insert":
//					users = userService.getAllUsers();
//					model.addAttribute("users", users);
					return "insertUser";
					
				case "update":
					model.addAttribute("user",userService.getUser(Integer.parseInt(request.getParameter("id"))));
//					users = userService.getAllUsers();
//					model.addAttribute("users", users);
					return "updateUser";
				case "delete":
					
					userService.deleteUser(Integer.parseInt((request.getParameter("id"))));
					users = userService.getAllUsers();
					model.addAttribute("users", users);
					return "managementUser";
				case "indietro":
					return "homeCustomers";
				case "indietroManagementUser":
					return "managementUser";
			}
		}
		
		return "managementUser";
	}
	
	

	@RequestMapping(value = "/showUsers", method = RequestMethod.POST)
	public String loginControlPost(HttpServletRequest request, Model model ) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
			
		String choice=request.getParameter("choice");
	
		if(choice != null) {
			switch(choice) {
				case "insert":
					String username=request.getParameter("username");
					String password=request.getParameter("password");
					String nome=request.getParameter("nome");
					String cognome=request.getParameter("cognome");
					String telefono=request.getParameter("telefono");
					String mail=request.getParameter("mail");
					String partitaiva=request.getParameter("partitaiva");
					String ruolo=request.getParameter("ruolo");
					String nomeAbb=request.getParameter("nomeAbb");
					User u=new User(0,username,password,nome,cognome,telefono,mail,partitaiva,ruolo,nomeAbb);
					
					userService.insertUser(u);
					users = userService.getAllUsers();
					model.addAttribute("users", users);
					return "managementUser";
				case "update":
					
					userService.updateUser(request);
					users = userService.getAllUsers();
					model.addAttribute("users", users);
					return "managementUser";
			}
		}
	
		return "managementUser";
	}
}