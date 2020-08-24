package com.azienda.catalogoProdotti.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.model.Prodotto;
import com.azienda.catalogoProdotti.util.Costanti;

/**
 * Servlet implementation class ProdottoServlet
 */
@WebServlet("/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BusinessLogic businessLogic = (BusinessLogic) getServletContext().getAttribute("servletContext");
		
		String operazione = (String) request.getSession().getAttribute(Costanti.OPERAZIONE);
		String nomeProdotto = (String) request.getParameter(Costanti.NOME_PRODOTTO);
		Float prezzoProdotto = 0f;
		
		if (request.getParameter(Costanti.PREZZO_PRODOTTO) != "") {
			prezzoProdotto = Float.parseFloat(request.getParameter(Costanti.PREZZO_PRODOTTO));
		}
		
		System.out.println("Operazione: " + operazione);
		System.out.println("Nome prodotto inserito: " + nomeProdotto);
		System.out.println("Prezzo prodotto inserito: " + prezzoProdotto);
		
		if (operazione.equals("ricerca")) {
			
			List<Prodotto> result = businessLogic.getProdotti(nomeProdotto, prezzoProdotto);
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("/jsp/areaPrivata/risultatiRicercaProdotti.jsp").forward(request, response);
			
		} else if (operazione.equals("creazione")) {
			
			businessLogic.createProdotto(nomeProdotto, prezzoProdotto);
			request.getRequestDispatcher("/jsp/areaPrivata/esito.jsp").forward(request, response);
			
		} else {
			request.getRequestDispatcher("/jsp/areaPrivata/home.jsp").forward(request, response);
		}
		
	}

}
