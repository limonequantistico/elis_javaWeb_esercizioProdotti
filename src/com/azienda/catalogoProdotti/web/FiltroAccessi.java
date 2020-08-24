package com.azienda.catalogoProdotti.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.azienda.catalogoProdotti.model.Utente;
import com.azienda.catalogoProdotti.util.Costanti;

@WebFilter("/jsp/areaPrivata/*")
public class FiltroAccessi implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		System.out.println("Filtro attivo");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String utente = (String)httpRequest.getSession().getAttribute(Costanti.LOGGATO);
		
		System.out.println("Loggato:" + httpRequest.getSession().getAttribute(Costanti.LOGGATO));
		
		if (utente != null) {
//			System.out.println("Utente non null");
			chain.doFilter(request, response); 
		} else {
			request.setAttribute(Costanti.LOGIN_ERROR, "Devi prima effettuare il login per accedere a questa risorsa.");
//			httpRequest.getSession().setAttribute(Costanti.LOGIN_ERROR, "Devi prima effettuare il login per accedere a questa risorsa.");
//			System.out.println(httpRequest.getSession().getAttribute(Costanti.LOGIN_ERROR));
			httpRequest.getRequestDispatcher("/jsp/pubblica/login.jsp").forward(request, response);
		}
		
	}

}
