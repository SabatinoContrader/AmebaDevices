package com.virtualpairprogrammers.model;

import org.jdom2.Element;

public class ItemEntity implements Buildable {
	private String id, seriale, consumoEnergetico, 
				idRoom, idItemType, thing;
	
	public ItemEntity(
			String _id,
			String _seriale,
			String _consumoEnergetico,
			String _idRoom,
			String _idItemType,
			String _thing) 
	{
		this.id = _id;
		this.seriale = _seriale;
		this.consumoEnergetico = _consumoEnergetico;
		this.idRoom = _idRoom;
		this.idItemType = _idItemType;
		this.thing = _thing;
	}
	
	public ItemEntity() {}

	@Override
	public String getId() {
		return this.id;
	}
	
	public String getSeriale() {
		return this.seriale;
	}
	
	public String getConsumoEnergetico() {
		return this.consumoEnergetico;
	}
	
	public String getIdRoom() {
		return this.idRoom;
	}
	
	public String getItemType() {
		return this.idItemType;
	}
	
	public String getThing() {
		return this.thing;
	}
	
	public void setId(String _id) {
		this.id = _id;
	}
	
	public void setConsumoEnergetico(String _consumoEnergetico) {
		this.consumoEnergetico = _consumoEnergetico;
	}
	
	public void setSeriale(String _seriale) {
		this.seriale = _seriale;
	}
	
	public void setIdRoom(String _idRoom) {
		this.idRoom = _idRoom;
	}
	
	public void setThing(String thing) {
		this.thing = thing;
	}
	
	public String getIdItemType() {
		return this.idItemType;
	}
	
	public String toString() {
		return "id: " + id + 
				"\nConsumo Energetico: " + consumoEnergetico + 
				"\nSeriale: " + seriale + 
				"\nId Room: " + idRoom + 
				"\nThing: " + thing +
				"\nTipologia Item" + idItemType;
	}
	
	public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        ItemEntity i = (ItemEntity) o;
	        return id == i.id&&consumoEnergetico.equals(i.consumoEnergetico)&&seriale.equals(i.seriale)&&idRoom.equals(i.idRoom)&&thing.equals(i.thing)&&idItemType.equals(i.idItemType);
	 }

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
