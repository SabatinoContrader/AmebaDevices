package com.AmebaDevices.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.services.ItemService;
import com.AmebaDevices.utils.GestoreEccezioni;

@Controller
@RequestMapping("/Item")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemService itemService;

	@Autowired
	public ItemController() {
		itemService = new ItemService();
	}

	@RequestMapping(value = "insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "CensimentoItemForm";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String marca = request.getParameter("marca");
		String modello = request.getParameter("modello");
		String categoria = request.getParameter("categoria");
		String descrizione = request.getParameter("descrizione");

		Item item = new Item(null, categoria, marca, modello, descrizione);
		itemService.insertItem(item);
		return "ItemMenu";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		return "ItemMenu";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		List<Item> items = itemService.getAllItem();
		request.setAttribute("items", items);
		return "VisualizzaItems";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		return "ModificaItemForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String marca = request.getParameter("marca");
		String modello = request.getParameter("modello");
		String categoria = request.getParameter("categoria");
		String descrizione = request.getParameter("descrizione");

		Item item = new Item(id, categoria, marca, modello, descrizione);
		itemService.updateItem(item);

		Item updatedItem = itemService.searchItem(id);
		request.setAttribute("item", updatedItem);
		return "UpdateItemResult";
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		return "EliminaItemForm";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String deleteId = request.getParameter("id");
		itemService.deleteItem(deleteId);
		return "DeleteItemResult";
	}

	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "ItemMenu";
	}
}
