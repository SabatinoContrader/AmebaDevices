package com.AmebaDevices.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.services.BuildingService;

@Controller
@RequestMapping("/Building")
public class BuildingController {

	private BuildingService buildingService;

	@Autowired
	public BuildingController() {
		buildingService = new BuildingService();
	}

	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "InsertBuilding";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		String indirizzo = request.getParameter("indirizzo");
		String interno = request.getParameter("interno");
		String citta = request.getParameter("citta");
		String cap = request.getParameter("cap");
		Building mynewBuilding = new Building(indirizzo, citta, cap, interno);
		System.out.println("Called create");
		this.buildingService.create(username, mynewBuilding);
		List<Building> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "CustomerHome";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		return "BuildingMenu";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List<Building> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "ReadBuilding";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List<Building> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "UpdateBuilding";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		int buildingId = Integer.parseInt(request.getParameter("idselected"));
		Building building = buildingService.findByPrimaryKey(buildingId);
		String newindirizzo = request.getParameter("newindirizzo");
		String newinterno = request.getParameter("newinterno");
		String newcitta = request.getParameter("newcitta");
		String newcap = request.getParameter("newcap");
		Building newValues = new Building(newindirizzo, newcitta, newcap, newinterno);
		this.buildingService.update(building, newValues, username);
		List<Building> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "CustomerHome";
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List<Building> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "DeleteBuilding";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		int toDelete = Integer.parseInt(request.getParameter("idselected"));
		Building toDestroy = buildingService.findByPrimaryKey(toDelete);
		this.buildingService.delete(toDestroy, username);
		List<Building> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "CustomerHome";
	}

	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "CustomerHome";
	}

}
