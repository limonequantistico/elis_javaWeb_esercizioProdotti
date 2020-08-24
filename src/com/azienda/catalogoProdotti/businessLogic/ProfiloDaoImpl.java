package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.model.Profilo;

public class ProfiloDaoImpl implements DaoInterface<Profilo> {

	private EntityManager em = null;

	public ProfiloDaoImpl() {
		this(null);
	}

	public ProfiloDaoImpl(EntityManager manager) {
		setManager(manager);
	}
	
	public EntityManager getManager() {
		return em;
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}

	@Override
	public void create(Profilo obj) {
		em.persist(obj);
	}

	@Override
	public List<Profilo> retrieve() {
		List<Profilo> listaProfili = em.createQuery("from Profilo").getResultList();
		return listaProfili;
	}

	@Override
	public void update(Profilo obj) {
		em.persist(obj);
	}

	@Override
	public void delete(Profilo obj) {
		em.remove(obj);
	}

}
