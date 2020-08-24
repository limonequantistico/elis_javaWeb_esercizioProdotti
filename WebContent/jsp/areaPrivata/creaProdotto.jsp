<%@page import="com.azienda.catalogoProdotti.util.Costanti"%>
<jsp:include page="/jsp/pubblica/header.jsp"></jsp:include>

	<div class="container">

		<h1>Crea Prodotto</h1>
			
		<form action="/elis_javaWeb_esercizioVacanze/ProdottoServlet" method="POST">
		
		<% request.getSession().setAttribute(Costanti.OPERAZIONE, "creazione"); %>
		
		  <div class="form-group">
		    <label for="nomeProdotto">Nome prodotto</label>
		    <input type="text" class="form-control" id="nomeProdotto" name=<%= Costanti.NOME_PRODOTTO %>>
		  </div>
		  <div class="form-group">
		    <label for="password">Prezzo prodotto</label>
		    <input type="text" class="form-control" id="password" name=<%= Costanti.PREZZO_PRODOTTO %>>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	
	</div>

<jsp:include page="/jsp/pubblica/footer.jsp"></jsp:include>