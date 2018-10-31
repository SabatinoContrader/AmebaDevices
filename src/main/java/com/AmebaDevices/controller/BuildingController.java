package com.AmebaDevices.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.CustomerService;

@RestController
@RequestMapping("/Building")
public class BuildingController {

	private BuildingService buildingService;
	private CustomerService customerService;

	@Autowired
	public BuildingController(BuildingService bs, CustomerService cs) {
		buildingService = bs;
		customerService = cs;
	}
	
	
	// INSERT -> TESTED
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public BuildingDTO newBuilding(HttpServletRequest request) {		
		String indirizzo =(String) request.getParameter("indirizzo");
		Integer interno = Integer.parseInt(request.getParameter("interno"));
		String city = (String) request.getParameter("city");
		String cap = (String) request.getParameter("cap");
		String ownerUsername = (String) request.getParameter("username");
		BuildingDTO myNewBuilding = new BuildingDTO();
		myNewBuilding.setAddress(indirizzo);
		myNewBuilding.setInterno(interno);
		myNewBuilding.setCity(city);
		myNewBuilding.setCap(cap);
		myNewBuilding.setOwner(customerService.findByUsername(ownerUsername));
		myNewBuilding = buildingService.create(myNewBuilding);
		return myNewBuilding;
	}
	
	
	
	// READ -> TESTED
	@RequestMapping(value="", method = RequestMethod.GET)
	public BuildingDTO getOne(@RequestParam(value="buildingId") long buildingId) {
		BuildingDTO bdto = buildingService.findByPrimaryKey(buildingId);
		return bdto;
		
	}
	
	// DELETE -> TESTED
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public boolean delete(@RequestParam(value="buildingId") long buildingId) {
		BuildingDTO bdto = buildingService.findByPrimaryKey(buildingId);
		if (buildingService.delete(bdto)) return true;
		return false;
		
	}
	
	
	// UPDATE -> TESTED
	@RequestMapping(value="/edit", method= RequestMethod.POST)
	public BuildingDTO updateBuilding (HttpServletRequest request, @RequestParam(value="buildingId") long buildingId){
		String indirizzo =(String) request.getParameter("indirizzo");
		String interno = request.getParameter("interno");
		String city = (String) request.getParameter("city");
		String cap = (String) request.getParameter("cap");
		
		System.err.println(buildingId+" "+indirizzo +" "+ interno+" " + city +" "+ cap);

		
		BuildingDTO bdto = buildingService.findByPrimaryKey(buildingId);
		
		if (indirizzo != null) {
		bdto.setAddress(indirizzo);
		}
		if (interno != null) {
		bdto.setInterno(Integer.parseInt(interno));
		}
		if (city != null) {
		bdto.setCity(city);
		}
		if (cap != null) {
		bdto.setCap(cap);
		}
		bdto = buildingService.update(bdto);
		return bdto;
	}


	/*
	
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
		BuildingDTO mynewBuilding = new BuildingDTO();
		mynewBuilding.setAddress(indirizzo);
		mynewBuilding.setInterno(Long.parseLong(interno));
		mynewBuilding.setCity(citta);
		mynewBuilding.setCap(cap);
		System.out.println("Called create");
		this.buildingService.create(mynewBuilding, username);
		List<BuildingDTO> buildings = this.buildingService.getAll(username);
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
		List<BuildingDTO> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "ReadBuilding";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List<BuildingDTO> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "UpdateBuilding";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		long buildingId = Long.parseLong(request.getParameter("idselected"));
		String newindirizzo = request.getParameter("newindirizzo");
		String newinterno = request.getParameter("newinterno");
		String newcitta = request.getParameter("newcitta");
		String newcap = request.getParameter("newcap");
		BuildingDTO newValues = new BuildingDTO();
		newValues.setId(buildingId);
		newValues.setAddress(newindirizzo);
		newValues.setInterno(Long.parseLong(newinterno));
		newValues.setCity(newcitta);
		newValues.setCap(newcap);
		this.buildingService.update(newValues, username);
		List<BuildingDTO> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "CustomerHome";
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List<BuildingDTO> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "DeleteBuilding";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		int toDelete = Integer.parseInt(request.getParameter("idselected"));
		BuildingDTO toDestroy = buildingService.findByPrimaryKey(toDelete);
		this.buildingService.delete(toDestroy);
		List<BuildingDTO> buildings = this.buildingService.getAll(username);
		request.setAttribute("buildings", buildings);
		return "CustomerHome";
	}
	
	
	
	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "CustomerHome";
	}

	*/
}
