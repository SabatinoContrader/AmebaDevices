package com.AmebaDevices.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Room;
import com.AmebaDevices.services.RoomService;

@Controller
@RequestMapping("/Room")
public class RoomController {
    private int floorId;
    RoomService fs;
    
@Autowired
    public RoomController() {
        super();
        fs= new RoomService();
    }

@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "InsertRoom";
	}

@RequestMapping(value="/insert", method=RequestMethod.POST)
public String insert(HttpServletRequest request) {
	String nome = (String) request.getParameter("nome");
	String descrizione = (String) request.getParameter("description");
	String id2 = (String) request.getAttribute("floorId");
	RoomService newRoomService = new RoomService();

	Room f = new Room();
	f.setNomeRoom(nome);
	f.setDescrizione(descrizione);
	f.setIdFloor(id2);
	newRoomService.insertRoom(f);
	System.out.println(newRoomService);
	return "RoomHome";
}

@RequestMapping(value = "/menu", method = RequestMethod.GET)
public String menu(HttpServletRequest request) {
	return "RoomHome";
}

@RequestMapping(value = "/read", method = RequestMethod.GET)
public String read(HttpServletRequest request) {
	int floorId =Integer.parseInt(request.getParameter("floorId"));
	request.setAttribute("floorId",String.valueOf(floorId));
	List <Room> listaPerFloor = new ArrayList<>();
	listaPerFloor = fs.getAllByFloor(floorId);
	request.setAttribute("rooms", listaPerFloor);
	return "ReadRoom";
}

@RequestMapping(value="/updateForm", method= RequestMethod.GET)
public String updateForm(HttpServletRequest request) {
	return "UpdateRoom";
}

@RequestMapping(value="/update", method=RequestMethod.POST)
public String update(HttpServletRequest request) {
	String newName = request.getParameter("roomName");
	String newDescription = request.getParameter("roomDescription");
	String roomid = (String) request.getParameter("roomId");
	String floorid=(String) request.getAttribute("floorId");
	Room newRoom = new Room();
	newRoom.setId(Integer.parseInt(roomid));
	newRoom.setNomeRoom(newName);
	newRoom.setDescrizione(newDescription);
	newRoom.setIdFloor(floorid);
	fs.update(newRoom);
	return "RoomHome";	
}

@RequestMapping(value="/deleteForm",method=RequestMethod.GET)
public String deleteForm(HttpServletRequest request) {
	return "DeleteForm";
}

@RequestMapping(value="/delete", method=RequestMethod.POST)
public String delete(HttpServletRequest request) {
	int idRoom= Integer.parseInt(request.getParameter("id_room"));
	//System.out.println(idRoom);
	RoomService newRoomService2 = new RoomService();
	newRoomService2.delete(idRoom);
	return "RoomHome";
}
	

}
