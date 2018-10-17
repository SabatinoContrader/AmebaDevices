package com.virtualpairprogrammers.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.service.LoginService;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private LoginService loginService;
	
	
    public Login() {
    	super();
    	loginService = new LoginService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeUtente =request.getParameter("username");
        String password = request.getParameter("password");
        request.getSession().setAttribute("username", nomeUtente);
        System.out.println(nomeUtente + " "+ password);
     
        if (loginService.login(nomeUtente, password)==1) {
        	// Il login è andato a buon fine
        	System.out.println("si");
        	getServletContext().getRequestDispatcher("/superuserhome.jsp").forward(request,response);
         }
        else if (loginService.login(nomeUtente, password)==2) {
        	// Il login è andato a buon fine
        	System.out.println("si");
        	getServletContext().getRequestDispatcher("/CustomerHome.jsp").forward(request,response);
         }
        else {
        	// Il login non è andato a buon fine
        	System.out.println("NO");
        	getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		
        }
	}

}
