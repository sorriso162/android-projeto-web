<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
	<div class="row-fluid">
		<div class="col-md-8 col-md-offset-2">
<h3 style="text-align:center">Cadastrar Usuário</h3>
<form action="criar_usuario" method="post" id="form">
  <div class="form-group">
    <label>Nome do Usuário</label>
    <input type="text" class="form-control" name="nome" placeholder="Nome" required>
  </div>
  <div class="form-group">
    <label >CPF do Usuário</label>
    <input type="text" class="form-control" name="cpf"placeholder="CPF" required>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Senha do Usuário:</label>
    <input type="password" class="form-control" name="senha" placeholder="Senha" required>
  </div>
  <button type="submit" class="btn btn-success" style="float: right">Cadastrar</button>
</form>

		</div>
	</div>
</div>

<c:import url="footer.jsp" />
