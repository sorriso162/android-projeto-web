<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
	<div class="row-fluid">
		<div class="col-md-8 col-md-offset-2">
			<h3>Lista de Usuários</h3>
			<table class="table table-striped table-hover tabPad">
				<tr>
					<td>ID</td>
					<td>Nome</td>
					<td>CPF</td>
					<td>Senha</td>
					<td>Tipo</td>
				</tr>
				<c:forEach var="listaDeUsuairos" items="${listaDeUsuairos}">
					<tr>
						<td>${listaDeUsuairos.id}</td>
						<td>
							<form action="usuarioView" method="post">
								<input type="hidden" id="id" name="id" value="${listaDeUsuairos.id}">
								<button type="submit" class="span6 btn-link capitalize">${listaDeUsuairos.nome}</button>
							</form>
						</td>
						<td>${listaDeUsuairos.cpf}</td>
						<td>${listaDeUsuairos.senha}</td>
						<td>${listaDeUsuairos.tipo}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<c:import url="footer.jsp" />