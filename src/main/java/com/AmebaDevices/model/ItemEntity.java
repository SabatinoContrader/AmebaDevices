package com.AmebaDevices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ItemEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String seriale;
	
	@Column
	private String consumoEnergetico;
	
	@ManyToOne
	@JoinColumn (name ="idroom")
	private Room idroom;
	
	@ManyToOne
	@JoinColumn (name ="iditemtype")
	private ItemType iditemtype;
	
	public String toString() {
		return "id: " + id + 
				"\nConsumo Energetico: " + consumoEnergetico + 
				"\nSeriale: " + seriale + 
				"\nId Room: " + idroom + 
				"\nTipologia Item" + iditemtype;

	}

	

	public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        ItemEntity i = (ItemEntity) o;
	        return id == i.id&&consumoEnergetico.equals(i.consumoEnergetico)&&seriale.equals(i.seriale)&&idroom.equals(i.idroom)&&iditemtype.equals(i.iditemtype);

	 }
}
