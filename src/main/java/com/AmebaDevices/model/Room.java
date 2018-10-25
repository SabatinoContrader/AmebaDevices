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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Room", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Room {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String nomeRoom;

	@Column
	private String descrizione;

	@ManyToOne
	@JoinColumn (name ="idfloor")
	private Floor floor;

}
