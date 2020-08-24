package com.azienda.catalogoProdotti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@OneToMany(mappedBy = "profilo")
	private List<Utente> utenti = null;
	
	public Profilo() {
		this(null, null);
	}

	public Profilo(String nome, List<Utente> utenti) {
		super();
		this.nome = nome;
		this.utenti = utenti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Utente> getProfili() {
		return utenti;
	}

	public void setProfili(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public Integer getId() {
		return id;
	}

}
