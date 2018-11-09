package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ListinoDTO;
import com.AmebaDevices.model.Listino;

public class ListinoConverter {
	
	public static ListinoDTO convertToDTO(Listino l) {
		ListinoDTO listino = new ListinoDTO();
		listino.setId(l.getId());
		listino.setAnno(l.getAnno());
		listino.setNomeListino(l.getNomeListino());
		listino.setManufacturer(l.getManufacturer());
		return listino;
	}
	
	public static Listino convertToListino(ListinoDTO l) {
		Listino listino = new Listino();
		listino.setId(l.getId());
		listino.setAnno(l.getAnno());
		listino.setNomeListino(l.getNomeListino());
		listino.setManufacturer(l.getManufacturer());
		return listino;
	}
}
