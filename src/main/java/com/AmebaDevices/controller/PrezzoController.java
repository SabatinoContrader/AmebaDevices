package com.AmebaDevices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.dto.ListinoDTO;
import com.AmebaDevices.dto.PrezzoDTO;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.FloorService;
import com.AmebaDevices.services.ItemTypeService;
import com.AmebaDevices.services.ListinoService;
import com.AmebaDevices.services.PrezzoService;

@RestController
@RequestMapping("/Prezzo")
@CrossOrigin
public class PrezzoController {
	private PrezzoService ps;
	private ItemTypeService it;
	private ListinoService ls;
	@Autowired
	public PrezzoController(PrezzoService ps, ItemTypeService it, ListinoService ls) {
		this.ps=ps;
		this.it=it;
		this.ls=ls;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@CrossOrigin
	public PrezzoDTO newPrezzo(@RequestParam(value = "prezzo") String prezzo,
			@RequestParam(value = "itemTypeId") long idItemType,
			@RequestParam(value = "idListino") long idListino){
		double newPrezzo= Double.parseDouble(prezzo);
		PrezzoDTO pdto = new PrezzoDTO();
		pdto.setPrezzo(newPrezzo);
		pdto.setIdItemType(it.findByPrimaryKey(idItemType));
		pdto.setIdListino(ls.findById(idListino));
		pdto = ps.insert(pdto);
		return pdto;

	}
}
