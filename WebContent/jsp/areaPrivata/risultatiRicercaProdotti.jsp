<%@page import="com.azienda.catalogoProdotti.model.Prodotto"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/jsp/pubblica/header.jsp"></jsp:include>

	<div class="container">
	
		<h1>Risultato ricerca</h1>
	
		<% ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>)request.getAttribute("result");
		
		if(prodotti.size() < 1) { %>
			<h3 class="text-center mt-5">Nessun risultato.</h3>
		<% } else { %>
			<table class="table table-striped">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Nome</th>
			      <th scope="col">Prezzo</th>
			    </tr>
			  </thead>
			  <tbody>
		<% for(Prodotto p : prodotti){ %>
		
			    <tr>
			      <td><%= p.getNome() %></td>
			      <td><%= p.getPrezzo() %></td>
			    </tr>
			  
		<% } %>
		     </tbody>
		   </table>
		<% } %>
		
		 <a class="btn btn-secondary" href="/elis_javaWeb_esercizioVacanze/jsp/areaPrivata/ricercaProdotti.jsp">Back</a>
		
	</div>
	<%-- <%= request.getAttribute("result").toString() %> --%>

<jsp:include page="/jsp/pubblica/footer.jsp"></jsp:include>