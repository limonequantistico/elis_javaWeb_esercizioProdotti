package com.azienda.catalogoProdotti.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.businessLogic.ProdottoDaoImpl;
import com.azienda.catalogoProdotti.businessLogic.UtenteDaoImpl;
import com.azienda.catalogoProdotti.model.Profilo;
import com.azienda.catalogoProdotti.model.Utente;

@WebServlet(value="/InitServlet", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
    public void init() throws ServletException {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Paperino");
    	EntityManager em = emf.createEntityManager();
    	
    	ProdottoDaoImpl prodottoDao = new ProdottoDaoImpl(em);
    	UtenteDaoImpl utenteDao = new UtenteDaoImpl(em);
    	BusinessLogic businessLogic = new BusinessLogic(em, utenteDao, prodottoDao);
    	
    	getServletContext().setAttribute("servletContext", businessLogic);
    	
    }

}
