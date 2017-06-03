<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
	<div class="row-fluid">
		<div class="col-md-8 col-md-offset-2">
		<h3>Digite o nome do Solucionador:</h3><br>
			<form action="pesquisar_solucionador" method="post">
			<input type="text" class="form-control" name="chave" placeholder="Aperte enter para pesquisar!" >
			</form>
			<h3>Lista de Solucionadores</h3>
			<table class="table table-striped table-hover tabPad">
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>CPF</td>
			<td>Senha</td>
			<td>Tipo</td>
		</tr>
	<c:forEach var="listaDeSolucionadores" items="${listaDeSolucionadores}">
				<tr>
				<td>${listaDeSolucionadores.id}</td>
		<td><form action="solucionadorView" method="post">
		<input type="hidden" id="id" name="id" value="${listaDeSolucionadores.id}">
						<button type="submit" class="span6 btn-link capitalize">${listaDeSolucionadores.nome}</button>
					</form>
				<td>${listaDeSolucionadores.cpf}</td>
				<td>${listaDeSolucionadores.senha}</td>
				<td>${listaDeSolucionadores.tipo}</td>
				
				</tr>
				
	</c:forEach>
	</table>
		</div>
	</div>
</div>
<c:import url="footer.jsp" />