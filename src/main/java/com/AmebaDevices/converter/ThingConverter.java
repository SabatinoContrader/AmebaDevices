package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.model.Thing;

public class ThingConverter {

	public static ThingDTO convertToDto(Thing t) {
		ThingDTO thing = new ThingDTO();
		thing.setId(t.getId());
		thing.setNome(t.getNome());
		thing.setNumUscite(t.getNumUscite());
		// thing.setItems(t.getItems());
		return thing;
	}

	public static Thing convertToThing(ThingDTO t) {
		Thing thing = new Thing();
		thing.setId(t.getId());
		thing.setNome(t.getNome());
		thing.setNumUscite(t.getNumUscite());
		//thing.setItems(t.getItems());
		return thing;
	}

}
