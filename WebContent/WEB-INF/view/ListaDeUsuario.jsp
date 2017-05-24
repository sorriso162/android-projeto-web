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
	<c:forEach var="meusChamados" items="${meusChamados}">
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
				
	</c:forEach>
	</table>
<c:import url="footer.jsp" />