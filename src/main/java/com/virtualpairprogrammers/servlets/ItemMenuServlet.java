package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.model.Item;
import com.virtualpairprogrammers.service.ItemService;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

/**
 * Servlet implementation class ItemMenuServlet
 */
public class ItemMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemService itemService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemMenuServlet() {
        super();
        itemService = new ItemService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String mode = request.getParameter("mode");
		
		switch(mode) {
			case "censimentoForm":
				getServletContext().getRequestDispatcher("/CensimentoItemForm.jsp").forward(request,response);
				break;
			case "Censimento":
				try {
					String marca = request.getParameter("marca");
					String modello = request.getParameter("modello");
					String categoria = request.getParameter("categoria");
					String descrizione = request.getParameter("descrizione");
					
					Item item = new Item(null, categoria, marca, modello, descrizione);
					itemService.insertItem(item);
					
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					try {
				         out.println("<!DOCTYPE html>");
				         out.println("<html><head>");
				         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				         out.println("<title>Censimento Item Response</title></head>");
				         out.println("<body>");
				         out.println("<h1>Censimento andato a buon fine, riepilogo:</h1>");
				         out.println("<p>Categoria: " + categoria + "</p>");
				         out.println("<p>Marca: " + marca + "</p>");
				         out.println("<p>Modello: " + modello + "</p>");
				         out.println("<a href=\"ItemMenu?mode=censimentoForm\">Torna indietro</a>");
				         out.println("</body>");
				         out.println("</html>");
				      } finally {
				         out.close();  // Always close the output writer
				      }
					
				} catch(Exception e) {
					GestoreEccezioni.getInstance().gestisciEccezione(e);
				}
				break;
			case "visualizzaItem":
				List<Item> items = itemService.getAllItem();
				request.setAttribute("items", items);
				getServletContext().getRequestDispatcher("/VisualizzaItems.jsp").forward(request,response);
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
