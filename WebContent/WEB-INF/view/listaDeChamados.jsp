<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />
<h1>TODOS OS CHAMADOS</h1>
<table class="table table-striped table-hover tabPad">
		<tr>
			<td>ID</td>
			<td>NOME DO USUARIO</td>
			<td>DESCRICAO</td>
			<td>DATA DE INICIO</td>
			<td>DATA DE ENCERRAMENTO</td>
			<td>STATUS</td>
			<td>NOME DO SOLUCIONADOR</td>
		</tr>
	<c:forEach var="todosChamados" items="${todosChamados}">
	
				<tr>
				<td>${todosChamados.id}</td>
				<td>${todosChamados.nomeUsuario}</td>
		<td><form action="chamadoView" method="post">
		<input type="hidden" id="id" name="id" value="${todosChamados.id}">
						<button type="submit" class="span6 btn-link">${todosChamados.descricao}</button>
					</form>
				<td>${todosChamados.dateInicio}</td>
				<td>${todosChamados.dataFim}</td>
				<td>${todosChamados.status}</td>
				<td>${todosChamados.nomeSolucionador}
				</tr>
				
	</c:forEach>
	</table>
<c:import url="footer.jsp" />