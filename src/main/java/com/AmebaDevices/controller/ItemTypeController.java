package com.AmebaDevices.controller;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.ItemType;
import com.AmebaDevices.services.ItemTypeService;
import com.AmebaDevices.utils.GestoreEccezioni;

@Controller
@RequestMapping("/ItemType")
public class ItemTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemTypeService itemTypeService;

	@Autowired
	public ItemTypeController(ItemTypeService itemTypeService) {
		this.itemTypeService =itemTypeService; 
	}

	@RequestMapping(value = "insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "CensimentoItemTypeForm";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String marca = request.getParameter("marca");
		String modello = request.getParameter("modello");
		String categoria = request.getParameter("categoria");
		String descrizione = request.getParameter("descrizione");

		ItemTypeDTO item = new ItemTypeDTO();
		item.setCategoria(categoria);
		item.setMarca(marca);
		item.setModello(modello);
		item.setDescrizione(descrizione);
		itemTypeService.insertItemType(item);
		return "ItemTypeMenu";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		return "ItemTypeMenu";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		List<ItemTypeDTO> items = itemTypeService.getAllItemType();
		request.setAttribute("items", items);
		return "VisualizzaItemsType";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		return "ModificaItemTypeForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Long id = (long) Integer.parseInt(request.getParameter("id"));
		String marca = request.getParameter("marca");
		String modello = request.getParameter("modello");
		String categoria = request.getParameter("categoria");
		String descrizione = request.getParameter("descrizione");

		ItemTypeDTO item = new ItemTypeDTO(id, categoria, marca, modello, descrizione);
		itemTypeService.updateItemType(item);

		ItemTypeDTO updatedItem = itemTypeService.searchItemType(id);
		request.setAttribute("item", updatedItem);
		return "UpdateItemTypeResult";
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		return "EliminaItemTypeForm";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		Long deleteId =(long)Integer.parseInt( request.getParameter("id"));
		itemTypeService.deleteItemType(deleteId);
		return "DeleteItemTypeResult";
	}

	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "ItemTypeMenu";
	}
}
