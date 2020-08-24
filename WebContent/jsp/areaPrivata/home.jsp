<%@page import="com.azienda.catalogoProdotti.util.Costanti"%>
<jsp:include page="/jsp/pubblica/header.jsp"></jsp:include>

	<div class="jumbotron">
	  <h1 class="display-4">Benvenuto <%= request.getSession().getAttribute(Costanti.LOGGATO) %></h1>
	  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  <hr class="my-4">
	  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
	</div>

<jsp:include page="/jsp/pubblica/footer.jsp"></jsp:include>