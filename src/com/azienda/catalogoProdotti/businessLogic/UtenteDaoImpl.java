package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.model.Utente;

public class UtenteDaoImpl implements DaoInterface<Utente> {

	private EntityManager em = null;

	public UtenteDaoImpl() {
		this(null);
	}

	public UtenteDaoImpl(EntityManager manager) {
		setManager(manager);
	}
	
	public EntityManager getManager() {
		return em;
	}

	public void setManager(EntityManager manager) {
		this.em = manager;
	}
	
	@Override
	public void create(Utente obj) {
		em.persist(obj);
	}

	@Override
	public List<Utente> retrieve() {
		List<Utente> listaUtenti = em.createQuery("from Utente").getResultList();
		return listaUtenti;
	}

	@Override
	public void update(Utente obj) {
		em.persist(obj);
	}

	@Override
	public void delete(Utente obj) {
		em.remove(obj);
	}
	
	public List<Utente> findByUsernameAndPassword(String user,String pwd){
		List<Utente> users = em.createQuery("select x from Utente x where x.username = :user and x.password = :pwd").setParameter("user",user).setParameter("pwd", pwd).getResultList();
		return users;
	}

}
