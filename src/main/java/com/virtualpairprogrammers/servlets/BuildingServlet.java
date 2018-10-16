package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuildingServlet
 */
public class BuildingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		switch (scelta) {
			case "InserisciBuilding":
			getServletContext().getRequestDispatcher("/InsertBuilding.jsp").forward(request, response);
			break;
			case "VisualizzaBuilding":
				getServletContext().getRequestDispatcher("/ReadBuilding.jsp").forward(request, response);
			break;
			case "ModificaBuilding":
				getServletContext().getRequestDispatcher("/UpdateBuilding.jsp").forward(request, response);
			break;
			case "EliminaBuilding":
				getServletContext().getRequestDispatcher("/DeleteBuilding.jsp").forward(request, response);
			break;
			case "goBack":
				getServletContext().getRequestDispatcher("/BuildingMenu.jsp").forward(request, response);;
			break;
		}
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
