<%@page import="com.azienda.catalogoProdotti.util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/pubblica/header.jsp"></jsp:include>

	<div class="container">
	
	<%
	String errorMessage = (String) request.getAttribute(Costanti.LOGIN_ERROR);
	
		if (errorMessage != null && !errorMessage.trim().isEmpty()) {
	%>
	
	<div class="alert alert-danger">
		<%= errorMessage %>
	</div>
	
	<% } %>
    
    <!-- <div  role="alert">
  A simple danger alert—check it out!
</div> -->
    
    <form action="/elis_javaWeb_esercizioVacanze/LoginServlet" method="POST">
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" class="form-control" id="username" name="username">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" id="password" name="password">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
    
    </div>

<jsp:include page="/jsp/pubblica/footer.jsp"></jsp:include>