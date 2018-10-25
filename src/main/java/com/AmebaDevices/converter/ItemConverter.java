package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.model.ItemType;

public class ItemConverter {

	public static ItemDTO convertToDto(ItemType i) {
		ItemDTO item = new ItemDTO();
		item.setId(i.getId());
		item.setDescrizione(i.getDescrizione());
		item.setCategoria(i.getCategoria());
		item.setMarca(i.getMarca());
		item.setModello(i.getModello());
		return item;
	}

	public static ItemType convertToItem(ItemDTO i) {
		ItemType item = new ItemType();
		item.setId(i.getId());
		item.setDescrizione(i.getDescrizione());
		item.setCategoria(i.getCategoria());
		item.setMarca(i.getMarca());
		item.setModello(i.getModello());
		return item;
	}
}
