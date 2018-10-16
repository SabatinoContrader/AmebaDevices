package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.model.Customer;
import com.virtualpairprogrammers.service.CustomerService;

/**
 * Servlet implementation class CustomerServlet
 */
public class InsertCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String mode=request.getParameter("mode");
CustomerService customerService= new CustomerService();
	switch(mode) {
	case "InsertForm":
		getServletContext().getRequestDispatcher("/customer.jsp").forward(request,response);
		break;
	
	case "InsertDb":
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String data= request.getParameter("dataDiNascita").toString();
		String email= request.getParameter("email");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		Customer customer= new Customer(nome,cognome,data,email,username,password);
		customerService.insertCustomer(customer);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		System.out.println("sono  nella servlet"); 
	break;
	}		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
