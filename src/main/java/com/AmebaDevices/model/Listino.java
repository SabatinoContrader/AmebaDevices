package com.AmebaDevices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Listino {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nomeListino;
	
	@Column
	private int anno;
	
	@ManyToOne
	@NonNull
	@JoinColumn (name ="idManufacturer")
	private Customer manufacturer;
	
	@ManyToOne
	@NonNull
	@JoinColumn (name ="idInstaller")
	private Customer installer;

}
