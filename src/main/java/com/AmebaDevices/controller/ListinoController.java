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
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ListinoDTO newListino (
			@RequestParam(value = "nomeListino") String nomeListino,
			@RequestParam(value = "anno") int anno,
			@RequestParam(value = "idManufacturer") Customer manufacturer) {
		ListinoDTO myNewListino = new ListinoDTO();
		myNewListino.setNomeListino(nomeListino);
		myNewListino.setAnno(anno);
		myNewListino.setManufacturer(manufacturer);
		return listinoService.insert(myNewListino);
	}
	
	//update
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public ListinoDTO updateListino(
			@RequestParam(value = "nomeListino") String nomeListino,
			@RequestParam(value = "anno") int anno,
			@RequestParam(value = "idManufacturer") Customer manufacturer) {
		ListinoDTO listDTO = listinoService.findByNomeListino(nomeListino);
		listDTO.setNomeListino(nomeListino);
		listDTO.setAnno(anno);
		listDTO.setManufacturer(manufacturer);
		listinoService.edit(listDTO);
		return listDTO;
	}
	
	//read
	@RequestMapping(value="/read",method = RequestMethod.GET)
	public List<ListinoDTO> readAll(){
		List<ListinoDTO> listini = listinoService.readAll();
		return listini;
	}
	
	//delete
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public boolean delete(@RequestParam(value="id") long id) {
		listinoService.delete(ListinoConverter.convertToListino(listinoService.findById(id)));
		return true;
	}
	
	
}
