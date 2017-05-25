<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />
<form action="criar_usuario" method="post">
<label>NOME DO USUARIO:</label><input type="text" name="nome"><br>
<label>CPF:</label><input type="text" name="cpf"><br>
<label>SENHA:</label><input type="text" name="senha"><br>
<button type="submit">Cadastrar</button><br>
</form>
<c:import url="footer.jsp" />
