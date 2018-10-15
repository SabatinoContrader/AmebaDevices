package com.virtualpairprogrammers.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.service.LoginService;

public class SuperuserLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private LoginService loginService;
	
	
    public SuperuserLogin() {
    	super();
    	loginService = new LoginService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeUtente =request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(nomeUtente + " "+ password);
        int choice= 1;
        if (loginService.login(nomeUtente, password,choice)) {
        	// Il login è andato a buon fine
        	System.out.println("si");
         }
        else {
        	// Il login non è andato a buon fine
        	System.out.println("NO");
            
		
        }
	}

}
