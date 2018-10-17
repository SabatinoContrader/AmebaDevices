package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.model.Thing;
import com.virtualpairprogrammers.service.ThingService;

/**
 * Servlet implementation class ThingManager
 */
public class ThingManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThingManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String operation = request.getParameter("operation");
		System.out.println(operation);
		ThingService ts = new ThingService();
		switch (operation) {
		case "create":
			dispatcher = request.getRequestDispatcher("newThing.jsp");
			break;
		case "sendDataForInsert":
			String nomeThing = request.getParameter("thingName");
			int numeroUscite = Integer.parseInt(request.getParameter("numeroUscite"));
			System.out.println(nomeThing+ " "+numeroUscite);
			Thing thing = new Thing(numeroUscite);
			thing.setNome(nomeThing);
			ts.create(thing);
			dispatcher = request.getRequestDispatcher("thingManager.jsp");
			break;
	
		}
		dispatcher.forward(request, response);

	}

}
