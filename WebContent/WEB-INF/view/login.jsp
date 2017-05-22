<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

	<form method="post" action="fazerLogin">
		<input type="text" name="cpf"/>
		<input type="password" name="senha"/>
	</form>
	
<jsp:include page="footer.jsp" />