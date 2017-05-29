<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
    <div class="row-fluid">
<div class="col-md-10">
<button class="btn btn-success"><a class="editA" href="lista_solucionador">Voltar</a></button>
</div>
<div class="col-md-2">
<form action="excluir_solucionador" method="POST">
	<button type="submit"class="btn btn-danger">Excluir Usuário</button>
	<input type="hidden" value="${view.id}" name="id">
</form>
</div>
<div class="col-md-12">
        <fieldset class="for-panel">
          <legend>Descrição do Solucionador</legend>
          <div class="row">
            <div class="col-sm-6">
              <div class="form-horizontal">               
                  <label class="col-xs-5 control-label">ID:</label>
                  <p class="form-control-static capitalize">${view.id}</p>
                  <label class="col-xs-5 control-label">Nome do Solucionador:</label>
                  <p class="form-control-static capitalize">${view.nome}</p>             
                  <label class="col-xs-5 control-label">CPF:</label>
                  <p class="form-control-static">${view.cpf}</p>               
                  <label class="col-xs-5 control-label">tipo:</label>
                  <p class="form-control-static">${view.tipo}</p>                           
                  <label class="col-xs-5 control-label">Senha:</label>
                  <p class="form-control-static">${view.senha}</p>
              </div>
            </div>
          </div>
        </fieldset>
</div>
    </div>
</div>

<c:import url="footer.jsp" />