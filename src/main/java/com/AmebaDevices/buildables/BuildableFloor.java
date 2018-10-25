package com.AmebaDevices.buildables;

import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Element;

import com.AmebaDevices.model.*;
import com.AmebaDevices.services.RoomService;

public class BuildableFloor implements Buildable {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	private Floor f;
	private String id;

	public BuildableFloor(Floor f) {
		this.id = String.valueOf(f.getId());
	}

	@Override
	public Element getElement() {
		Element toReturn = new Element(this.getClass().getSimpleName().toLowerCase());
		toReturn.setAttribute(new Attribute("id", this.getId()));
		toReturn.addContent(new Element("nome").setText(f.getNomeFloor()));
		toReturn.addContent(new Element("descrizione").setText(f.getDescrizione()));
		Element roomsFather = new Element("rooms");
		Element roomsElement;
		RoomService rs = new RoomService();
		if (Integer.parseInt(this.id) != 0) {
			List<Room> rooms = rs.getAllByFloor((Integer.parseInt(id)));
			for (int i = 0; i < rooms.size(); i++) {
				roomsElement = rooms.get(i).getElement();
				roomsFather.addContent(roomsElement);
			}

			toReturn.addContent(roomsFather);
		}
		return toReturn;

	}

	@Override
	public String getId() {
		return this.id;
	}
	*/
}
