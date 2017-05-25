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
	<c:forEach var="listaDeSolucionadores" items="${listaDeSolucionadores}">
				<tr>
				<td>${listaDeSolucionadores.id}</td>
		<td><form action="solucionadorView" method="post">
		<input type="hidden" id="id" name="id" value="${listaDeSolucionadores.id}">
						<button type="submit" class="span6 btn-link">${listaDeSolucionadores.nome}</button>
					</form>
				<td>${listaDeSolucionadores.cpf}</td>
				<td>${listaDeSolucionadores.senha}</td>
				<td>${listaDeSolucionadores.tipo}</td>
				
				</tr>
				
	</c:forEach>
	</table>
<c:import url="footer.jsp" />