package com.AmebaDevices.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.model.Thing;
import com.AmebaDevices.services.ThingService;

@Controller
@RequestMapping("/Thing")
public class ThingManager {

	@Autowired
	public ThingManager() {
		super();
	}

	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "newThing";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		ThingService thingService= new ThingService();
		String nomeThing = request.getParameter("thingName");
		int numeroUscite = Integer.parseInt(request.getParameter("numeroUscite"));
		Thing thing = new Thing(numeroUscite);
		thing.setNome(nomeThing);
		thingService.create(thing);
		return "thingManager";
	}
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		ThingService thingService= new ThingService();
		List<Thing> listaPerBuilding = new ArrayList<>();
		listaPerBuilding = thingService.getAllItem();
		request.setAttribute("things", listaPerBuilding);
		return "ReadThing";
		//RequestDispatcher view = request.getRequestDispatcher("/ReadThing.jsp");
		//view.include(request, response);
	}
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		return "UpdateThing";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		ThingService thingService= new ThingService();
		int numberPort = Integer.parseInt(request.getParameter("numberPort"));
		String nameThing = request.getParameter("nameThing");
		String roomid = (String) request.getParameter("thingId");
		Thing newThing = new Thing();
		newThing.setId(roomid);
		newThing.setNumUscite(numberPort);
		newThing.setNome(nameThing);
		thingService.update(newThing);
		return "thingManager";
	}
	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		return "DeleteFormThing";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idThing = Integer.parseInt(request.getParameter("id_thing"));
		ThingService thingService = new ThingService();
		thingService.delete(idThing);
		return "thingManager";
	}
	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "thingManager";
	}
	
}
