package com.AmebaDevices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AmebaDevices.converter.ItemConverter;
import com.AmebaDevices.dto.BasicItemDTO;
import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.dto.NewItemDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.ItemType;
import com.AmebaDevices.model.Room;
import com.AmebaDevices.services.ItemService;
import com.AmebaDevices.services.ItemTypeService;
import com.AmebaDevices.services.RoomService;
import com.AmebaDevices.services.ThingService;
import com.AmebaDevices.utils.GestoreEccezioni;

@RestController
@RequestMapping("/Item")
@CrossOrigin
public class ItemController {

	private ItemService itemService;
	private RoomService roomService;
	private ItemTypeService itemTypeService;
	private ThingService thingService;

	@Autowired
	public ItemController(ItemService itemService, RoomService roomService, ItemTypeService itemTypeService,
			ThingService thingService) {
		this.itemService = itemService;
		this.roomService = roomService;
		this.itemTypeService = itemTypeService;
		this.thingService = thingService;
	}

	// INSERT
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@CrossOrigin
	public ItemDTO newItem(@RequestParam(value = "roomId") long roomId,
			@RequestParam(value = "itemTypeId") long itemTypeId,
			@RequestParam(value = "thingId", required = false) Long thingId,
			@RequestParam(value = "consumoEnergetico", required = false) String consumo,
			@RequestParam(value = "seriale", required = false) String seriale) {
		ItemDTO idto = new ItemDTO();
		RoomDTO room = roomService.findByPrimaryKey(roomId);
		ThingDTO thing = null;
		if (thingId != null) {
			thing = thingService.searchThing(thingId);
		}
		ItemTypeDTO itemType = itemTypeService.findByPrimaryKey(itemTypeId);
		if (room != null)
			idto.setRoom(room);
		if (itemType != null)
			idto.setItemType(itemType);
		if (thing != null)
			idto.setThing(thing);
		if (consumo != null)
			idto.setConsumoEnergetico(consumo);
		if (seriale != null)
			idto.setSeriale(seriale);

		idto = itemService.insertItem(idto);
		return idto;

	}

	// READ
	@RequestMapping(value = "", method = RequestMethod.GET)
	@CrossOrigin
	public ItemDTO getOne(@RequestParam(value = "itemId") long itemId) {
		return itemService.searchItem(itemId);
	}

	// UPDATE
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@CrossOrigin
	public ItemDTO updateItem(@RequestParam(value = "roomId", required = false) long roomId,
			@RequestParam(value = "itemTypeId", required = false) long itemTypeId,
			@RequestParam(value = "thingId", required = false) long thingId,
			@RequestParam(value = "consumoEnergetico", required = false) String consumo,
			@RequestParam(value = "seriale", required = false) String seriale,
			@RequestParam(value = "itemId") long itemId) {
		ItemDTO myItem = itemService.searchItem(itemId);
		ItemTypeDTO itemType = itemTypeService.searchItemType(itemTypeId);
		RoomDTO room = roomService.findByPrimaryKey(roomId);
		ThingDTO thing = thingService.searchThing(thingId);
		if (itemType != null) {
			myItem.setItemType(itemType);
		}
		if (room != null) {
			myItem.setRoom(room);
		}
		if (thing != null) {
			myItem.setThing(thing);
		}
		if (consumo != null) {
			myItem.setConsumoEnergetico(consumo);
		}
		if (seriale != null) {
			myItem.setSeriale(seriale);
		}

		return itemService.updateItem(myItem);
	}

	// DELETE
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@CrossOrigin
	public boolean delete(@RequestParam(value = "itemId") long itemId) {
		System.err.println("deleting " + itemId);
		return itemService.deleteItem(itemId);
	}

	@RequestMapping(value = "byRoom", method = RequestMethod.GET)
	@CrossOrigin
	public List<BasicItemDTO> findByRoom(@RequestParam(value = "roomId") long roomId) {

		List<ItemDTO> items = itemService.getAllByRoom(roomService.findByPrimaryKey(roomId));
		List<BasicItemDTO> baseItems = new ArrayList<>();

		for (int i = 0; i < items.size(); i++) {
			baseItems.add(new BasicItemDTO(items.get(i).getId(), items.get(i).getRoom(), items.get(i).getItemType()));
		}

		return baseItems;
	}
	
	@RequestMapping(value = "byBuilding", method = RequestMethod.GET)
	@CrossOrigin
	public List<NewItemDTO> findByBuilding(@RequestParam(value = "buildingId") long buildingId){
		
		List <BasicItemDTO> toReturn = itemService.getByBuilding(buildingId);
		List<NewItemDTO> lista=new ArrayList<>();
		toReturn.forEach(t->{
			NewItemDTO n= new NewItemDTO();
			n.setId(t.getId());
			if(t.getItemType()==null)
			{
				
//				ItemDTO item= itemService.searchItem(t.getId());
//				System.out.println(item.getItemType().getManufacturer().getId()+"   ------------");
//				System.out.println("schifooooo -> "+itemService.searchItem(t.getId()));
//				n.setItemType(t.getItemType());
//				System.out.println("è diverso da null per id= "+ n.getId() + " che ha itemType " + t.getItemType().getId());
//				n.setManufacturer(itemTypeService.searchItemType(t.getItemType().getId()).getManufacturer());
				//n.setManufacturer(t.getItemType().getManufacturer());
				n.setRoom(t.getRoom());
				lista.add(n);
			}
			//System.out.println("aggiungo "+ n.getId()+ " con manufacturer "+ n.getManufacturer().getId());
		});
		return lista;
	}

//		
//		
//	@RequestMapping(value = "insertForm", method = RequestMethod.GET)
//	public String insertForm(HttpServletRequest request) {
//		String id = (String) request.getAttribute("roomId");
//		return "CensimentoItemForm";
//	}
//
//	@RequestMapping(value = "insert", method = RequestMethod.POST)
//	public String insert(HttpServletRequest request) {
//		String consumoEnergetico = request.getParameter("consumoEnergetico");
//		String seriale = request.getParameter("seriale");
//		String id = (String) request.getParameter("roomId");
//		RoomDTO room= roomService.findByPrimaryKey(Long.parseLong(id));
//		ItemDTO item = new ItemDTO();
//		item.setConsumoEnergetico(consumoEnergetico);
//		item.setSeriale(seriale);
//		item.setRoom(room);
//		itemService.insertItem(item);
//		request.setAttribute("roomId", id);
//		List <ItemDTO> listaPerRoom = new ArrayList<>();
//		listaPerRoom = itemService.getAllByRoom(room);
//		request.setAttribute("items", listaPerRoom);
//		return "ItemMenu";
//	}
//
//	@RequestMapping(value = "/menu", method = RequestMethod.GET)
//	public String menu(HttpServletRequest request) {
//		long roomId=Long.parseLong(request.getParameter("roomId"));
//		RoomDTO room= roomService.findByPrimaryKey(roomId);
//		List<ItemTypeDTO> tipologieDisponibili= new ArrayList<>();
//		tipologieDisponibili= itemTypeService.getAllItemType();
//		if (tipologieDisponibili.size() == 0) tipologieDisponibili = new ArrayList<>();
//		System.out.println(tipologieDisponibili.size());
//		request.setAttribute("availableItems", tipologieDisponibili);
//		List <ItemDTO> yourItems = itemService.getAllByRoom(room);
//		if (yourItems.size() == 0) yourItems = new ArrayList<>();
//		System.out.println(yourItems.size());
//		request.setAttribute("yourItems", yourItems);
//		request.setAttribute("roomId", String.valueOf(roomId));
//		return "ItemMenu";
//	}
//
//
//	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
//	public String updateForm(HttpServletRequest request) {
//		long roomId=Long.parseLong(request.getParameter("roomId"));
//		request.setAttribute("roomId", String.valueOf(roomId));
//		return "ModificaItemForm";
//	}
//
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String update(HttpServletRequest request) {
//		Long id = (long) Integer.parseInt(request.getParameter("id"));
//		String consumoEnergetico = request.getParameter("consumoEnergetico");
//		String seriale = request.getParameter("seriale");
//		String roomdiD= request.getParameter("roomId");
//		RoomDTO room= roomService.findByPrimaryKey(Long.parseLong(roomdiD));
//
//		ItemDTO item = new ItemDTO();
//		item.setId(id);
//		item.setConsumoEnergetico(consumoEnergetico);
//		item.setSeriale(seriale);
//		item.setRoom(room);
//		itemService.updateItem(item);
//		List<ItemDTO> listaPerRoom= new ArrayList<>();
//		listaPerRoom= itemService.getAllByRoom(room); 
//		request.setAttribute("items", listaPerRoom);
//
//		//ItemType updatedItem = itemTypeService.searchItemType(id);
//		//request.setAttribute("item", updatedItem);
//		return "ItemMenu";
//	}
//	
//	@RequestMapping(value = "/addInRoom", method = RequestMethod.GET)
//	public String addNewItem(HttpServletRequest request) {
//		
//		long itemTypeId = Long.parseLong(request.getParameter("itemId"));
//		long roomId=Long.parseLong(request.getParameter("roomId"));
//		String consumoEnergetico = request.getParameter("consumoEnergetico");
//		String seriale = request.getParameter("seriale");
//		RoomDTO room= roomService.findByPrimaryKey(roomId);
//		ItemTypeDTO it = itemTypeService.findByPrimaryKey(itemTypeId);
//		ItemDTO item = new ItemDTO();
//		item.setConsumoEnergetico(consumoEnergetico);
//		item.setSeriale(seriale);
//		item.setRoom(room);
//		item.setItemType(it);
//		itemService.insertItem(item);
//		request.setAttribute("roomId", String.valueOf(roomId));
//		List<ItemTypeDTO> tipologieDisponibili= new ArrayList<>();
//		tipologieDisponibili= itemTypeService.getAllItemType();
//		request.setAttribute("availableItems", tipologieDisponibili);
//		List <ItemDTO> yourItems = itemService.getAllByRoom(room);
//		request.setAttribute("yourItems", yourItems);
//		return "ItemMenu";
//	}
//	
//	@RequestMapping(value = "/removeFromRoom", method = RequestMethod.GET)
//	public String removeFromRoom(HttpServletRequest request) {
//		
//		long itemId = Long.parseLong(request.getParameter("itemId"));
//		long roomId=Long.parseLong(request.getParameter("roomId"));
//		RoomDTO room= roomService.findByPrimaryKey(roomId);
//		itemService.deleteItem(itemId);
//		
//		request.setAttribute("roomId", String.valueOf(roomId));
//		List<ItemTypeDTO> tipologieDisponibili= itemTypeService.getAllItemType();
//		if (tipologieDisponibili.size() == 0) tipologieDisponibili = new ArrayList<>();
//		request.setAttribute("availableItems", tipologieDisponibili);
//		List <ItemDTO> yourItems = itemService.getAllByRoom(room);
//		if (yourItems.size() == 0 ) yourItems = new ArrayList<>();
//		request.setAttribute("yourItems", yourItems);
//		return "ItemMenu";
//	}
//
//	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
//	public String deleteForm(HttpServletRequest request) {
//		long roomId=Long.parseLong(request.getParameter("roomId"));
//		request.setAttribute("roomId", String.valueOf(roomId));
//		return "EliminaItemForm";
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String delete(HttpServletRequest request) {
//		String deleteId = request.getParameter("id");
//		long roomId = Long.parseLong(request.getParameter("roomId"));
//		RoomDTO room = roomService.findByPrimaryKey(roomId);
//		
//		itemService.deleteItem((long) Integer.parseInt(deleteId));
//		List<ItemDTO> listaPerRoom= new ArrayList<>();
//		listaPerRoom= itemService.getAllByRoom(room); 
//		request.setAttribute("items", listaPerRoom);
//		return "ItemMenu";
//	}
//
//	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
//	public String goBack(HttpServletRequest request) {
//		return "ItemMenu";
//	}
}
