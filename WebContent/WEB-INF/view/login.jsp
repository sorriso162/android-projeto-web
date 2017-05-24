<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<h1>Hello, world!</h1>
	<form method="post" action="fazer_login">
		<input type="text" name="cpf"/>
		<input type="password" name="senha"/>
		<button type="submit">Clique Aqui</button>
	</form>
	
<jsp:include page="footer.jsp" />