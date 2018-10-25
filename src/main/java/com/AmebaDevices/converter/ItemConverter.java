package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.model.Item;

public class ItemConverter {

	public static ItemDTO convertToDto(Item i) {
		ItemDTO item = new ItemDTO();
		item.setId(i.getId());
		item.setDescrizione(i.getDescrizione());
		item.setCategoria(i.getCategoria());
		item.setMarca(i.getMarca());
		item.setModello(i.getModello());
		return item;
	}

	public static Item convertToItem(ItemDTO i) {
		Item item = new Item();
		item.setId(i.getId());
		item.setDescrizione(i.getDescrizione());
		item.setCategoria(i.getCategoria());
		item.setMarca(i.getMarca());
		item.setModello(i.getModello());
		return item;
	}
}
