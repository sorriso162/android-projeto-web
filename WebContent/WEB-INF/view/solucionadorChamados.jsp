<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
	<div class="row-fluid">
		<div class="col-md-9 col-md-offset-1">
			
			
	<c:set var="tipoUsuario" value="${usuario.tipo}" />
	<c:set var="solucionador" value="solucionador" />
		
<table class="table table-striped table-hover tabPad">
		<tr>
			<td >ID</td>
			<td >Nome do Usuário</td>
			<td >Descrição</td>
			<td >Data Início</td>
			<td >Data de Encerramento</td>
			<td >Status</td>
			<td >Nome do Solucionador</td>
			<td >Ação<td>
		</tr>
	<c:forEach var="todosChamado" items="${todosChamado}">
	
				<tr>
				<td >${todosChamado.id}</td>
				<td >${todosChamado.nomeUsuario}</td>
		<td >${todosChamado.descricao}</td>
					
				<td >${todosChamado.dateInicio}</td>
				<td >${todosChamado.dataFim}</td>
				<td > ${todosChamado.status}</td>
				<td >${todosChamado.nomeSolucionador}</td>
				<td >
				<form action="atualizar_chamado" method="post">
				<input type="hidden" name="id" value="${todosChamado.id}">
				<input type="hidden" name="status" value="fechado">
				<button class="btn btn-danger">Fechar</button>
				</form>
				</tr>		
	</c:forEach>
	</table>
			</div>
	</div>
</div>
<c:import url="footer.jsp" />