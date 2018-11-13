package com.AmebaDevices.converter;

import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.PrezzoDTO;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.Prezzo;

public class PrezzoConverter {
	
	public static PrezzoDTO convertToDto(Prezzo p) {
		PrezzoDTO prezzo= new PrezzoDTO();
		prezzo.setId(p.getId());
		prezzo.setPrezzo(p.getPrezzo());
		prezzo.setIdItemType(ItemTypeConverter.convertToDto(p.getItemType()));
		prezzo.setIdListino(ListinoConverter.convertToDTO(p.getListino()));
		return prezzo;
	}
	
	public static Prezzo convertToFloor(PrezzoDTO p) {
		Prezzo prezzo= new Prezzo();
		prezzo.setId(p.getId());
		prezzo.setPrezzo(p.getPrezzo());
		prezzo.setItemType(ItemTypeConverter.convertToItem(p.getIdItemType()));
		prezzo.setListino(ListinoConverter.convertToListino(p.getIdListino()));
		return prezzo;
	}

}
