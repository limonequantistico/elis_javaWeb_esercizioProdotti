<%@page import="com.azienda.catalogoProdotti.util.Costanti"%>

<jsp:include page="/jsp/pubblica/header.jsp"></jsp:include>

	<div class="container">
		<h1>Cerca prodotto</h1>
		<em><h6 class="text-muted">Cerca per nome, per prezzo o entrambi.</h6></em>
		<form action="/elis_javaWeb_esercizioVacanze/ProdottoServlet" method="POST">
		
		  <% request.getSession().setAttribute(Costanti.OPERAZIONE, "ricerca"); %>
	
		  <div class="form-group">
		    <label for="nome">Nome prodotto</label>
		    <input type="text" class="form-control" id="nome" name=<%= Costanti.NOME_PRODOTTO %>>
		  </div> 
		  
		  <div class="form-group">
		    <label for="prezzo">Prezzo prodotto (minore di)</label>
		    <input type="text" class="form-control" id="prezzo" name=<%= Costanti.PREZZO_PRODOTTO %>>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

<jsp:include page="/jsp/pubblica/footer.jsp"></jsp:include>

