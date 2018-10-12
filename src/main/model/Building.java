package main.model;

public class Building {
	
	private int buildingId;
	private String indirizzo;
	private String citta;
	private String cap;
	private String interno;
	
	// in futuro all'interno di questa classe si prevede di inserire la lista di item
	// associati al building stesso
	
	
	public int getBuildingId() {
		return buildingId;
	}
	
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public Building(int buildingId, String indirizzo, String citta, String cap,String interno) {
		this.buildingId = buildingId;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.interno=interno;
	}
	public Building(String indirizzo, String citta, String cap, String interno) {
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.interno=interno;
	}
	public Building() {
	}
	
	public void setInterno(String interno) {
		this.interno = interno;
	}

	public String getInterno() {
		// TODO Auto-generated method stub
		return this.interno;
	}
	
	
}
