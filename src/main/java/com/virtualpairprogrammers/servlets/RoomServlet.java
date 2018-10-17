package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Room;
import com.virtualpairprogrammers.service.RoomService;

/**
 * Servlet implementation class RoomServlet
 */
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomService roomService;
    //RoomManager room;
    private List<Room> l;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String choice = request.getParameter("richiesta");
		RoomService customerService = new RoomService();
		List<Room> rooms = customerService.getAllByRoom();
		System.out.println(choice);
		HttpSession session=request.getSession(true);

        	switch (choice) {
        	case "InsertForm":
        		getServletContext().getRequestDispatcher("/InsertRoom.jsp").forward(request,response);
        		break;
        	case "InsertRoom":
        	
            	String nome = (String) request.getParameter("nome");
            	String descrizione = (String) request.getParameter("description");
            	System.out.println(choice);
            	RoomService newRoomService = new RoomService();

    			Room f = new Room();
    			f.setNomeRoom(nome);
    			f.setDescrizione(descrizione);
    			newRoomService.insertRoom(f);;
    			getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request,response);

            	break;
            	
        	case "ReadRoom":
        		request.setAttribute("rooms",rooms );
        		getServletContext().getRequestDispatcher("/ReadRoom.jsp").forward(request,response);
        		break;
        		
        	case "Return":
        		getServletContext().getRequestDispatcher("/ReadHome.jsp").forward(request,response);
        		break;
        		
        	case "DeleteForm":
        		getServletContext().getRequestDispatcher("/DeleteForm.jsp").forward(request,response);
        		break;
        	
        	case "DeleteRoom":
        		int idRoom= Integer.parseInt(request.getParameter("id_room"));
        		//System.out.println(idRoom);
        		RoomService newRoomService2 = new RoomService();
        		newRoomService2.delete(idRoom);
        		getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request,response);
        		break;
        		
        	case "SearchForm":
        		request.setAttribute("rooms",rooms );
        		getServletContext().getRequestDispatcher("/SearchFormRoom.jsp").forward(request,response);
        		break;
        	
        	case "UpdateRoom":
        		int id = Integer.parseInt(request.getParameter("idselected"));
    			//System.out.println(request.getParameter("selected"));
    			System.out.println(id);
    			Room room= new Room();
    			room= this.roomService.searchRoom(id);
        		switch (Integer.parseInt(request.getParameter("selected"))) {

    			case 1:
    				room.setNomeRoom(request.getParameter("value"));
    				break;
    			case 2:
    				room.setDescrizione(request.getParameter("value"));
    				break;
    			}
    			this.roomService.update(room);
    			getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request, response);
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
