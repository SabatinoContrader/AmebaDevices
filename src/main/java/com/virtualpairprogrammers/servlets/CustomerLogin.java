package com.virtualpairprogrammers.servlets;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.service.LoginService;



/**
 * Servlet implementation class CustomerLogin
 */

public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		loginService= new LoginService();
		if (request != null) {
		String nomeUtente = request.getParameter("username").toString();
	    String password = request.getParameter("password").toString();
	    int choice= 2;
	    //System.out.println(choice+ password);
        HttpSession session = request.getSession();
        session.setAttribute("utente", null);
       // System.out.println(nomeUtente+" "+ password+ " "+ choice);
       // System.out.println(nomeUtente);
        if (loginService.login(nomeUtente, password,choice)) {
        	//System.out.println(choice+ password);
            session.setAttribute("utente", nomeUtente);
            request.setAttribute("password", password);
            request.setAttribute("choice", choice);
            //response.sendRedirect("home.jsp");
            getServletContext().getRequestDispatcher("/CustomerHome.jsp").forward(request,response);
        }
        else
            //response.sendRedirect("login.jsp");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
			
		}
	}

}
