package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.TreeItemDTO;
import com.AmebaDevices.model.Item;

public class TreeItemConverter {
	public static TreeItemDTO convertToDto(Item i) {
		TreeItemDTO item = new TreeItemDTO();
		item.setId(i.getId());
		item.setSeriale(i.getSeriale());
		return item;
	}
}
