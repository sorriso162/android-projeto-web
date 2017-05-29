<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
	<div class="row-fluid">
		<div class="col-md-9 col-md-offset-1">
			<h3>Lista de Chamados</h3>
		
<table class="table table-striped table-hover tabPad">
		<tr>
			<td>ID</td>
			<td>Nome do Usuário</td>
			<td>Descrição</td>
			<td>Data Início</td>
			<td>Data de Encerramento</td>
			<td>Status</td>
			<td>Nome do Solucionador</td>
		</tr>
	<c:forEach var="todosChamados" items="${todosChamados}">
	
				<tr>
				<td>${todosChamados.id}</td>
				<td class="capitalize center">${todosChamados.nomeUsuario}</td>
		<td><form action="chamadoView" method="post">
		<input type="hidden" id="id" name="id" value="${todosChamados.id}">
						<button type="submit" class="span6 btn-link">${todosChamados.descricao}</button>
					</form>
				<td>${todosChamados.dateInicio}</td>
				<td>${todosChamados.dataFim}</td>
				<td>${todosChamados.status}</td>
				<td class="capitalize center">${todosChamados.nomeSolucionador}
				</tr>
				
	</c:forEach>
	</table>
			</div>
	</div>
</div>
<c:import url="footer.jsp" />