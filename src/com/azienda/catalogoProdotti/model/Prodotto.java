package com.azienda.catalogoProdotti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@Column
	private Float prezzo;
	
	public Prodotto() {
		this(null, null);
	}

	public Prodotto(String nome, Float prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getId() {
		return id;
	}

}
