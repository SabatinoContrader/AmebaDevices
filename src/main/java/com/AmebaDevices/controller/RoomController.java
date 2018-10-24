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
    private RoomService fs;
    
@Autowired
    public RoomController(RoomService fs) {
	this.fs=fs;
	
	}

@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
	String id = (String) request.getAttribute("floorId");
		return "InsertRoom";
	}

@RequestMapping(value="/insert", method=RequestMethod.POST)
public String insert(HttpServletRequest request) {
	String nome = (String) request.getParameter("nome");
	String descrizione = (String) request.getParameter("description");
	String id = (String) request.getParameter("floorId");
	System.out.println(nome + " "+descrizione+" "+id);
	Room f = new Room();
	f.setNomeRoom(nome);
	f.setDescrizione(descrizione);
	f.setIdfloor(Integer.parseInt(id));
	fs.insertRoom(f);
	request.setAttribute("floorId", id);
	List <Room> listaPerFloor = new ArrayList<>();
	listaPerFloor = fs.getAllByFloor(Integer.parseInt(id));
	request.setAttribute("rooms", listaPerFloor);
	return "RoomHome";
}

@RequestMapping(value = "/menu", method = RequestMethod.GET)
public String menu(HttpServletRequest request) {
	int floorId =Integer.parseInt(request.getParameter("floorId"));
	request.setAttribute("floorId",String.valueOf(floorId));
	List <Room> listaPerFloor = new ArrayList<>();
	listaPerFloor = fs.getAllByFloor(floorId);
	request.setAttribute("rooms", listaPerFloor);
	return "RoomHome";
}



@RequestMapping(value="/updateForm", method= RequestMethod.GET)
public String updateForm(HttpServletRequest request) {
	int floorId =Integer.parseInt(request.getParameter("floorId"));
	request.setAttribute("floorId",String.valueOf(floorId));
	List <Room> listaPerFloor = new ArrayList<>();
	listaPerFloor = fs.getAllByFloor(floorId);
	request.setAttribute("rooms", listaPerFloor);
	return "UpdateRoom";
}

@RequestMapping(value="/update", method=RequestMethod.POST)
public String update(HttpServletRequest request) {
	String newName = request.getParameter("roomName");
	String newDescription = request.getParameter("roomDescription");
	String roomid = (String) request.getParameter("roomId");
	String floorid=(String) request.getParameter("floorId");
	Room newRoom = new Room();
	newRoom.setId(Integer.parseInt(roomid));
	newRoom.setNomeRoom(newName);
	newRoom.setDescrizione(newDescription);
	newRoom.setIdfloor(Integer.parseInt(floorid));
	fs.update(newRoom);	
	List <Room> listaPerFloor = new ArrayList<>();
	listaPerFloor = fs.getAllByFloor(Integer.parseInt(floorid));
	request.setAttribute("rooms", listaPerFloor);
	System.out.println(listaPerFloor.size());
	return "RoomHome";	
}

@RequestMapping(value="/deleteForm",method=RequestMethod.GET)
public String deleteForm(HttpServletRequest request) {
	int floorId =Integer.parseInt(request.getParameter("floorId"));
	request.setAttribute("floorId",String.valueOf(floorId));
	List <Room> listaPerFloor = new ArrayList<>();
	listaPerFloor = fs.getAllByFloor(floorId);
	request.setAttribute("rooms", listaPerFloor);
	return "DeleteForm";
}

@RequestMapping(value="/delete", method=RequestMethod.POST)
public String delete(HttpServletRequest request) {
	String idRoom= request.getParameter("roomid");
	if (idRoom!= null) System.out.println(idRoom);
	else System.out.println("idroom is null");
	String floorId = request.getParameter("floorId");
	if(floorId!= null) System.out.println(floorId);
	else System.out.println("floorid is null");
	fs.delete(Integer.parseInt(idRoom));
	List <Room> listaPerFloor = fs.getAllByFloor(Integer.parseInt(floorId));
	request.setAttribute("rooms", listaPerFloor);
	return "RoomHome";
}
	

}
