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
import org.springframework.web.bind.annotation.RequestParam;

import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.model.Thing;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.ThingService;

@Controller
@RequestMapping("/Thing")
public class ThingController {

	private ThingService thingService;
	private BuildingService buildingService;
	
	@Autowired
	public ThingController(ThingService thingService, BuildingService buildingService) {
		this.thingService = thingService;
		this.buildingService = buildingService;
	}
	
	// CREATE 
		@RequestMapping(value = "/new", method = RequestMethod.POST)
		public ThingDTO newThing(
				@RequestParam(value = "buildingId") long buildingId,
				@RequestParam(value = "numUscite") int numUscite) {
			ThingDTO thingDTO = new ThingDTO();
			BuildingDTO buildingDTO = buildingService.findByPrimaryKey(buildingId);
			double prezzo = 5 + numUscite;
			thingDTO.setBuilding(buildingDTO);
			thingDTO.setNumUscite(numUscite);
			thingDTO.setPrezzo(prezzo);
			thingDTO = thingService.create(thingDTO);
			return thingDTO;
		}
		
	// READ
		@RequestMapping(value="", method = RequestMethod.GET)
		public ThingDTO getOne(@RequestParam(value="thingId") long thingId) {
			ThingDTO thingDTO = thingService.searchThing(thingId);
			return thingDTO;
		}
	
	// UPDATE
		@RequestMapping(value="/edit", method = RequestMethod.POST)
		public ThingDTO updateThing(
				@RequestParam(value="thingId") long thingId,
				@RequestParam(value = "numUscite") int numUscite){
			ThingDTO thing = thingService.searchThing(thingId);
			thing.setNumUscite(numUscite);
			thing.setPrezzo(5+numUscite);
			return thingService.update(thing);
			
		}
		
	// DELETE
		@RequestMapping(value="/delete", method = RequestMethod.GET)
		public boolean delete(@RequestParam(value="thingId") long thingId) {
			return thingService.delete(thingId);
		}
	
	
//
//	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
//	public String insertForm(HttpServletRequest request) {
//		return "newThing";
//	}
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	public String insert(HttpServletRequest request) {
//		String nomeThing = request.getParameter("thingName");
//		int numeroUscite = Integer.parseInt(request.getParameter("numeroUscite"));
//		ThingDTO thing = new ThingDTO();
//		thing.setNumUscite(numeroUscite);
//		thingService.create(thing);
//		return goBack(request);
//	}
//	@RequestMapping(value = "/read", method = RequestMethod.GET)
//	public String read(HttpServletRequest request) {
//		
//		/*
//		 * 		Vedete cosa vi serve fare qui....
//		 * 
//		 * 
//		 * 
//		 */	
//		
//	//	List<ThingDTO> listaPerBuilding = new ArrayList<>();
//	//	listaPerBuilding = thingService.getAllItems();
//	//	request.setAttribute("things", listaPerBuilding);
//		return "ReadThing";
//		//RequestDispatcher view = request.getRequestDispatcher("/ReadThing.jsp");
//		//view.include(request, response);
//	}
//	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
//	public String updateForm(HttpServletRequest request) {
//		return "UpdateThing";
//	}
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String update(HttpServletRequest request) {
//		int numberPort = Integer.parseInt(request.getParameter("numberPort"));
//		String nameThing = request.getParameter("nameThing");
//		String roomid = (String) request.getParameter("thingId");
//		ThingDTO newThing = new ThingDTO();
//		newThing.setNumUscite(numberPort);
//		thingService.update(newThing);
//		return "thingManager";
//	}
//	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
//	public String deleteForm(HttpServletRequest request) {
//		return "DeleteFormThing";
//	}
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String delete(HttpServletRequest request) {
//		int idThing = Integer.parseInt(request.getParameter("id_thing"));
//		thingService.delete(idThing);
//		return "thingManager";
//	}
//	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
//	public String goBack(HttpServletRequest request) {
//		return "thingManager";
//	}
//	
}
