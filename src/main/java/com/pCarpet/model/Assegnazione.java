package com.pCarpet.model;

public class Assegnazione {

	private int iduser;
	private int idbadge;
	private String dataassegnazione;
	
    public Assegnazione(int iduser,int idbadge,String dataassegnazione) {
    	this.iduser = iduser;
    	this.idbadge = idbadge;
        this.dataassegnazione = dataassegnazione;
    }
    public int getIdUtente() {
    	return iduser;
    }
    public int getIdBadge() {
    	return idbadge;
    }
    public String getData() {
    	return dataassegnazione;
    }

    @Override
    public String toString() {
        return "\nIdUser:" + iduser + "\n1)IdBadge: " + idbadge + "\n2)Data assegnazione: " + dataassegnazione +"\n";
    }
}
