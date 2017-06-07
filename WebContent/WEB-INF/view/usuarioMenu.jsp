<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />
<h1>Meus Chamados</h1>
<table class="table table-striped table-hover tabPad">
		<tr>
			<td>ID</td>
			<td>DESCRICAO</td>
			<td>DATA DE INICIO</td>
			<td>DATA DE ENCERRAMENTO</td>
			<td>STATUS</td>
		</tr>
	<c:forEach var="meusChamados" items="${meusChamados}">
	<c:set var="id" value="${usuario.id}" />
		<c:set var="idUsuario" value="${meusChamados.idUsuario}" />
				<c:if test="${ id == idUsuario}" >
				<tr>
				<td>${meusChamados.id}</td>
		<td><form action="chamadoView" method="post">
		<input type="hidden" id="id" name="id" value="${meusChamados.id}">
						<button type="submit" class="span6 btn-link">${meusChamados.descricao}</button>
					</form>
				<td>${meusChamados.dateInicio}</td>
				<td>${meusChamados.dataFim}</td>
				<td>${meusChamados.status}</td>
				</tr>
				</c:if>
	</c:forEach>
	</table>
<c:import url="footer.jsp" />