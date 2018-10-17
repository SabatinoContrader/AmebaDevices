package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.service.BuildingService;

/**
 * Servlet implementation class BuildingServlet
 */
public class BuildingServlet extends HttpServlet {
	
	private BuildingService buildingService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingServlet() {
        super();
        // TODO Auto-generated constructor stub
        buildingService = new BuildingService();
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
			case "newBuilding":
				String indirizzo = request.getParameter("indirizzo");
				String interno = request.getParameter("interno");
				String citta = request.getParameter("citta");
				String cap = request.getParameter("cap");
				System.out.println(indirizzo+" "+interno+" "+citta+" "+cap);
				Building mynewBuilding = new Building(indirizzo, citta, cap, interno); 
				this.buildingService.create("pippo", mynewBuilding);
				getServletContext().getRequestDispatcher("/BuildingMenu.jsp").forward(request, response);
			break;
			case "VisualizzaBuilding":
		//		List<Buildings> Buildings = this.buildingService.getAll("ower");
				getServletContext().getRequestDispatcher("/ReadBuilding.jsp").forward(request, response);
			break;
			case "ModificaBuilding":
				getServletContext().getRequestDispatcher("/UpdateBuilding.jsp").forward(request, response);
			break;
			case "UpdateBuilding":
				String newindirizzo = request.getParameter("newindirizzo");
				String newinterno = request.getParameter("newinterno");
				String newcittà = request.getParameter("newcittà");
				String newcap = request.getParameter("newcap");
				Building newValues = new Building(newindirizzo, newinterno, newcittà, newcap);
			//	this.buildingService.update(building, newValues, username);
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
