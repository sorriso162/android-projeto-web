<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
	<div class="row-fluid">
		<div class="col-md-8 col-md-offset-2">
<center><h3>Cadastrar Chamado</h3></center>
<form action="criar_chamado" method="post" id="form">
<input type="hidden" name="idUsuario" value="${usuario.id}"/>
  <div class="form-group">
    <label>Descrição do Chamado</label>
    <input type="text" class="form-control" name="descricao" placeholder="Descrição" required>
  </div>
  <div class="form-group">
    <label>Tipo do Chamado</label>
    <input type="text" class="form-control" name="tipo" placeholder="Tipo" required>
  </div>
  <button type="submit" class="btn btn-success" style="float: right">Cadastrar</button>
</form>

		</div>
	</div>
</div>

<c:import url="footer.jsp" />