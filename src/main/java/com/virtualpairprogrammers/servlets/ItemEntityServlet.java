package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.model.ItemEntity;

/**
 * Servlet implementation class ItemEntity
 */
public class ItemEntityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemEntityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		
		switch(mode) {
			case "MainMenu":
				getServletContext().getRequestDispatcher("/ItemEntityMainMenu.jsp").forward(request,response);
				break;
			case "InsertItemEntityForm":
				getServletContext().getRequestDispatcher("/InsertItemEntityForm.jsp").forward(request,response);
				break;
			case "Insert":
				String seriale = request.getParameter("seriale");
				String consumoEnergetico = request.getParameter("consumo_energetico");
				String roomId = request.getParameter("roomId");
				String itemTypeId = request.getParameter("idItemType");
				String thingId = request.getParameter("thingId");
				
				ItemEntity itemEntity = new ItemEntity(null, seriale, consumoEnergetico, roomId, itemTypeId, thingId);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
