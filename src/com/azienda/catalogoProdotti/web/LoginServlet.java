package com.azienda.catalogoProdotti.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.util.Costanti;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BusinessLogic businessLogic = (BusinessLogic) getServletContext().getAttribute("servletContext");
		
		String a = request.getParameter("username");
		String b = request.getParameter("password");
    	
    	if (businessLogic.login(a, b) != null) {
    		request.getSession().setAttribute(Costanti.LOGGATO, businessLogic.login(a, b).getUsername());
//    		System.out.println(businessLogic.login(a, b).getUsername());

    		if (businessLogic.isAdmin(a, b)) {
    			request.getSession().setAttribute(Costanti.ADMIN, true);
			} else {
				request.getSession().setAttribute(Costanti.ADMIN, false);
			}
    		
    		request.getRequestDispatcher("/jsp/areaPrivata/home.jsp").forward(request, response);
    		
		} else {
			request.setAttribute(Costanti.LOGIN_ERROR, "Login errata");
			request.getRequestDispatcher("/jsp/pubblica/login.jsp").forward(request, response);
		}
		
	}

}
