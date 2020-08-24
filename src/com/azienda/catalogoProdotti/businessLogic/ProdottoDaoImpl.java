package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.model.Prodotto;

public class ProdottoDaoImpl implements DaoInterface<Prodotto> {
	
	private EntityManager em = null;
	
	public ProdottoDaoImpl() {
		this(null);
	}
	
	public ProdottoDaoImpl(EntityManager manager) {
		setManager(manager);
	}
	
	public EntityManager getManager() {
		return em;
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}

	@Override
	public void create(Prodotto obj) {
		em.persist(obj);
	}

	@Override
	public List<Prodotto> retrieve() {
		List<Prodotto> listaProdotti = em.createQuery("from Prodotto").getResultList();
		return listaProdotti;
	}

	@Override
	public void update(Prodotto obj) {
		em.persist(obj);
	}

	@Override
	public void delete(Prodotto obj) {
		em.remove(obj);
	}
	
	public List<Prodotto> findByNome(String nome) {
		List<Prodotto> result = em.createQuery("select p from Prodotto p where p.nome LIKE '" + nome + "%'").getResultList();
		return result;
	}
	
	public List<Prodotto> findByPrezzoMinoreDi(Float prezzo) {
		List<Prodotto> result = em.createQuery("select p from Prodotto p where p.prezzo <= '" + prezzo + "'").getResultList();
		return result;
	}
	
	public List<Prodotto> findByNomeAndPrezzoMinoreDi(String nome, Float prezzo) {
		List<Prodotto> result = em.createQuery("select p from Prodotto p where p.nome LIKE'" + nome + "%' AND p.prezzo <= '" + prezzo + "'").getResultList();
		return result;
	}

}
