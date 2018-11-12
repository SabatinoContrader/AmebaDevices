package com.AmebaDevices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name="prezzo")
public class Prezzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private long id;
	
	@Column
	private double prezzo;
	
	@ManyToOne
	@JoinColumn (name = "idItemType")
	private ItemType itemType;
	
	@ManyToOne
	@JoinColumn (name = "idListino")
	private Listino listino;
}
