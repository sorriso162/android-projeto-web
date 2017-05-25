<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />
<table class="table table-striped table-hover tabPad">
		<tr>
			<td>ID</td>
			<td>NOME</td>
			<td>CPF</td>
			<td>SENHA</td>
			<td>TIPO</td>
		</tr>
	<c:forEach var="listaDeUsuairos" items="${listaDeUsuairos}">
				<tr>
				<td>${listaDeUsuairos.id}</td>
		<td><form action="usuarioView" method="post">
		<input type="hidden" id="id" name="id" value="${listaDeUsuairos.id}">
						<button type="submit" class="span6 btn-link">${listaDeUsuairos.nome}</button>
					</form>
				<td>${listaDeUsuairos.cpf}</td>
				<td>${listaDeUsuairos.senha}</td>
				<td>${listaDeUsuairos.tipo}</td>
				
				</tr>
				
	</c:forEach>
	</table>
<c:import url="footer.jsp" />