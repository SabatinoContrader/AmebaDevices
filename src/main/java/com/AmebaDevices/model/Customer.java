package com.AmebaDevices.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.AmebaDevices.services.BuildingService;

@Entity
public class Customer implements Buildable {

	@Id
	@Column
	@NotNull
	private int id;

	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private String dataNascita;
	@Column
	private String email;
	@Column
	@NotNull
	private String username;
	@Column
	private String password;

	@Column
	@NotNull
	private Integer user_role;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String nome, String cognome, String dataNascita, String email, String username, String password,Integer role) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.username = username;
		this.password = password;
		this.user_role=role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getId() {
		return String.valueOf(this.id);
	}

	@Override
	public Element getElement() {
		Element toReturn = new Element(this.getClass().getSimpleName().toLowerCase());
		toReturn.setAttribute(new Attribute("id", this.getId()));
		toReturn.addContent(new Element("nome").setText(this.getNome()));
		toReturn.addContent(new Element("cognome").setText(this.getCognome()));
		toReturn.addContent(new Element("username").setText(this.getUsername()));
		toReturn.addContent(new Element("datanascita").setText(this.getDataNascita()));
		Element buildingsFather = new Element("buildings");
		Element buildingsElement;
		BuildingService bs = new BuildingService();
		List<Building> buildings = bs.getAll(this.username);
		for (int i = 0; i < buildings.size(); i++) {
			buildingsElement = buildings.get(i).getElement();
			buildingsFather.addContent(buildingsElement);
		}
		toReturn.addContent(buildingsFather);
		return toReturn;
	}

}
