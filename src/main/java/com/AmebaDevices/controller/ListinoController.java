package com.AmebaDevices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AmebaDevices.converter.ListinoConverter;
import com.AmebaDevices.dto.ListinoDTO;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.services.ListinoService;

@RestController
@CrossOrigin
@RequestMapping("/Listino")
public class ListinoController {
	private ListinoService listinoService;
	
	@Autowired
	public ListinoController(ListinoService listinoService) {
		this.listinoService = listinoService;
	}
	
	//insert
	@CrossOrigin
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ListinoDTO newListino (
			@RequestParam(value = "nomeListino") String nomeListino,
			@RequestParam(value = "anno") String anno,
			@RequestParam(value = "idManufacturer") Customer manufacturer) {
		//int newAnno= Integer.parseInt(anno);
		ListinoDTO myNewListino = new ListinoDTO();
		myNewListino.setNomeListino(nomeListino);
		myNewListino.setAnno(anno);
		myNewListino.setManufacturer(manufacturer);
		return listinoService.insert(myNewListino);
	}
	
	//update
	@CrossOrigin
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public ListinoDTO updateListino(
			@RequestParam(value = "id") long id,
			@RequestParam(value = "nomeListino") String nomeListino,
			@RequestParam(value = "anno") String anno)
			{
		ListinoDTO listDTO = listinoService.findById(id);
		listDTO.setNomeListino(nomeListino);
		listDTO.setAnno(anno);
		listinoService.edit(listDTO);
		return listDTO;
	}
	
	//read
	@CrossOrigin
	@RequestMapping(value="/read",method = RequestMethod.GET)
	public List<ListinoDTO> readAll(){
		List<ListinoDTO> listini = listinoService.readAll();
		return listini;
	}
	
	//delete
	@CrossOrigin
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public boolean delete(@RequestParam(value="id") long id) {
		listinoService.delete(ListinoConverter.convertToListino(listinoService.findById(id)));
		return true;
	}
	
	
}
