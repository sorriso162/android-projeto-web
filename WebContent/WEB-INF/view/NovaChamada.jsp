<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />
<title>Criar CHamada</title>
<form action="criar_chamado" method="post">
<input type="hidden" name="idUsuario" value="${usuario.id}"/>
<input type="text"   name="descricao" />
<input type="text" name="tipo"/>
<button type="submit">CLique aqui</button>
</form>

<form action="usuario_menu" method="post">
<input type="hidden" name="id" value="${usuario.id}">
<button type="submit">Voltar</button>
</form>
<c:import url="footer.jsp" />