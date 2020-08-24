package com.azienda.catalogoProdotti.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.catalogoProdotti.model.Prodotto;
import com.azienda.catalogoProdotti.model.Utente;
import com.azienda.catalogoProdotti.util.Costanti;

public class BusinessLogic {

	private EntityManager em;
	private UtenteDaoImpl utenteDao;
	private ProdottoDaoImpl prodottoDao;

	public BusinessLogic(EntityManager em, UtenteDaoImpl utenteDao, ProdottoDaoImpl prodottoDao) {
		this.em = em;
		this.utenteDao = utenteDao;
		this.prodottoDao = prodottoDao;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public UtenteDaoImpl getUtenteDao() {
		return utenteDao;
	}

	public void setUtenteDao(UtenteDaoImpl utenteDao) {
		this.utenteDao = utenteDao;
	}

	public void createUtente(Utente utente) {
		em.getTransaction().begin();

		try {
			utenteDao.create(utente);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void createProdotto(String nome, Float prezzo) {
		em.getTransaction().begin();

		try {
			Prodotto prodotto = new Prodotto(nome, prezzo);
			prodottoDao.create(prodotto);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Utente login(String username, String password) {
		List<Utente> utenti = utenteDao.findByUsernameAndPassword(username, password);
		if (utenti != null && utenti.size() == 1) {
			return utenti.get(0);
		} else if (utenti != null && utenti.size() == 0) {
			return null;
		} else {
			throw new RuntimeException("Bug applicativo");
		}
	}

	public boolean isAdmin(String username, String password) {
		
		Utente utente = login(username, password);
		String tipoProfilo = utente.getProfilo().getNome();
		
		if (utente != null && utente.getProfilo() != null && (tipoProfilo.equals(Costanti.ADMIN) || tipoProfilo.equals("amministratore"))) {
			return true;
		}
		return false;
	}

	public List<Prodotto> getProdotti(String nome, Float prezzo) {
		
		if (nome != null && (prezzo == null || prezzo == 0)) {
			System.out.println("primo if");
			return prodottoDao.findByNome(nome);
		} else if ((nome == null || nome.equals("")) && (prezzo != null || prezzo != 0)) {
			System.out.println("secondo if");
			return prodottoDao.findByPrezzoMinoreDi(prezzo);
		} else if (nome != null && (prezzo != null || prezzo != 0)) {
			System.out.println("terzo if");
			return prodottoDao.findByNomeAndPrezzoMinoreDi(nome, prezzo);
		}
		return prodottoDao.retrieve();
	}

}
