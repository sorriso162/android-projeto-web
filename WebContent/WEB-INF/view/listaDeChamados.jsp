<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
	<div class="row-fluid">
		<div class="col-md-9 col-md-offset-1">
			
			<form action="pesquisar_chamados" method="post">
			<input type="text" class="form-control" name="chave" placeholder="Aperte enter para pesquisar!" >
			</form>
	<c:set var="tipoUsuario" value="${usuario.tipo}" />
	<c:set var="solucionador" value="solucionador" />
		
<table class="table table-striped table-hover tabPad">
		<tr>
			<td>ID</td>
			<td>Nome do Usu�rio</td>
			<td>Descri��o</td>
			<td>Data In�cio</td>
			<td>Data de Encerramento</td>
			<td>Status</td>
			<c:if test="${tipoUsuario != solucionador}">
			<td>Nome do Solucionador</td>
			</c:if>
			<c:if test="${tipoUsuario == solucionador}">
			<td class="capitalize center">A��es</td>
			</c:if>
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
				<c:if test="${tipoUsuario != solucionador}">
				<td class="capitalize center">${todosChamados.nomeSolucionador}</td>
				</c:if>
				<c:if test="${tipoUsuario == solucionador}">
				<td><form action="atualizar_chamado" method="post">
						<input type="hidden" value="${usuario.id}" name="idSolucionador">
						<input type="hidden" value="${todosChamados.id}" name="id">
							<button tipe="submit" class="btn btn-success">Atender</button> 
						</form>
				</td>
				</c:if>
				</tr>
				
	</c:forEach>
	</table>
			</div>
	</div>
</div>
<c:import url="footer.jsp" />