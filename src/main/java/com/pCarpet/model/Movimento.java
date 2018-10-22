package com.pCarpet.model;

public class Movimento {

	private int idbadgereader;
	private int idbadge;
	private String orainizio;
	private String orafine;
	
	public Movimento(int idbadgereader, int idbadge, String orainizio, String orafine) {
		this.idbadgereader = idbadgereader;
		this.idbadge = idbadge;
		this.orainizio = orainizio;
		this.orafine = orafine;
	}

	public int getIdbadgereader() {
		return idbadgereader;
	}

	public void setIdbadgereader(int idbadgereader) {
		this.idbadgereader = idbadgereader;
	}

	public int getIdbadge() {
		return idbadge;
	}

	public void setIdbadge(int idbadge) {
		this.idbadge = idbadge;
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

	
	
	
	
}
