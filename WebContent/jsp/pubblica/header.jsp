<%@page import="com.azienda.catalogoProdotti.util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Programma prodotti</title>
</head>

<body>

		<% 
	
			HttpServletRequest httpRequest = (HttpServletRequest) request;
   	  		String utente = (String)httpRequest.getSession().getAttribute(Costanti.LOGGATO); 
   	  		
   	  		boolean admin = false;
   	  		
   	  		if(request.getSession().getAttribute(Costanti.ADMIN) != null){
   	  			admin = (boolean)request.getSession().getAttribute(Costanti.ADMIN);
   	  		}
    	   
   	   	%>

	  <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav ml-auto">
            <a class="nav-link" href="/elis_javaWeb_esercizioVacanze/jsp/areaPrivata/home.jsp">Home</a>
            <a class="nav-link" href="/elis_javaWeb_esercizioVacanze/jsp/areaPrivata/ricercaProdotti.jsp">Cerca prodotto</a>
            
            <% if(admin) { %>
                <a class="btn btn-warning" href="/elis_javaWeb_esercizioVacanze/jsp/areaPrivata/creaProdotto.jsp">Crea prodotto</a>
            <% }%>
            
            <% if(utente == null) { %>
            <a class="btn btn-primary" href="/elis_javaWeb_esercizioVacanze/jsp/pubblica/login.jsp">Login</a>
            <% }%>

            <% if(utente != null) { %>
                <form action="/elis_javaWeb_esercizioVacanze/LogoutServlet">
					<button class="btn btn-danger" type="submit" style="height:40px">Logout</button>
				</form>
            <% }%>

          </div>
        </div>
      </nav>