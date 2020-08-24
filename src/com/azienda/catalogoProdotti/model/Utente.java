package com.azienda.catalogoProdotti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String username;

	@Column
	private String password;

	@ManyToOne
	@JoinColumn(name = "profiloUtente")
	private Profilo profilo;
	
	public Utente() {
		this(null, null, null);
	}

	public Utente(String username, String password, Profilo profilo) {
		this.username = username;
		this.password = password;
		this.profilo = profilo;
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

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public Integer getId() {
		return id;
	}

}
