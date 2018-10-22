package com.pCarpet.model;

public class Prenotazione {

	private int iduser;
	private int idasset;
	private String orainizio;
	private String orafine;
	
	public Prenotazione(int iduser, int idasset, String orainizio, String orafine) {
		this.iduser=iduser;
		this.idasset=idasset;
		this.orainizio=orainizio;
		this.orafine=orafine;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getIdasset() {
		return idasset;
	}

	public void setIdasset(int idasset) {
		this.idasset = idasset;
	}

	public String getOrainizio() {
		return orainizio;
	}

	public void setOrainizio(String orainizio) {
		this.orainizio = orainizio;
	}

	public String getOrafine() {
		return orafine;
	}

	public void setOrafine(String orafine) {
		this.orafine = orafine;
	}
	
	public boolean equals(Object o) {
		
		if(!(o instanceof Prenotazione)) 
			return false;
		
		if(o==this)
			return true;
		
		Prenotazione p=(Prenotazione)o;
		
		if(this.iduser==p.iduser && this.idasset==p.idasset && this.orainizio==p.orainizio)
			return true;
		
		return false;
		
	}
	
	public String toString() {
		
		return "ID User:"+iduser+" ID Asset:"+idasset+" Ora inizio:"+orainizio+" Ora fine:"+orafine;
		
	}
	
	
}
