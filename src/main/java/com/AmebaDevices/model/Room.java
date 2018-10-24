package com.AmebaDevices.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.jdom2.Attribute;
import org.jdom2.Element;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Room", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Room {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	@Null
	private String nomeRoom;

	@Column
	@Null
	private String descrizione;

	@Column
	@Null
	private int idfloor;

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(String nomeRoom, String descrizione) {
		this.nomeRoom = nomeRoom;
		this.descrizione = descrizione;
	}

	@ManyToOne
	@JoinColumn(name = "id")
	private Floor floor;

	@Override
	public String toString() {
		return "Room [id=" + id + ", nomeRoom=" + nomeRoom + ", descrizione=" + descrizione + ", idfloor=" + idfloor
				+ "]";
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, nomeRoom, descrizione, idfloor);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Room))
			return false;
		Room that = (Room) o;
		return Integer.compare(that.id, id) == 0 && Objects.equals(nomeRoom, that.nomeRoom)
				&& Objects.equals(descrizione, that.descrizione) && Objects.equals(idfloor, that.idfloor);

	}

}
