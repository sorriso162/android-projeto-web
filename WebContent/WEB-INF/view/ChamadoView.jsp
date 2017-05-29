<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="container">
    <div class="row">
        <fieldset class="for-panel">
          <legend>Descrição da Chamada</legend>
          <div class="row">
            <div class="col-sm-6">
              <div class="form-horizontal">               
                  <label class="col-xs-5 control-label">Nome do Usuário:</label>
                  <p class="form-control-static capitalize">${view.nomeUsuario}</p>
       		      <label class="col-xs-5 control-label">Nome do Solucionador:</label>
                  <p class="form-control-static capitalize">${view.nomeSolucionador}</p>               
                  <label class="col-xs-5 control-label">Descrição do Chamado:</label>
                  <p class="form-control-static">${view.descricao}</p>               
                  <label class="col-xs-5 control-label">Tipo:</label>
                  <p class="form-control-static">${view.tipo}</p>                           
              </div>
            </div>
            <div class="col-sm-6">
              <div class="form-horizontal">               
                  <label class="col-xs-4 control-label">Status:</label>
                  <p class="form-control-static">${view.status}</p>             
                  <label class="col-xs-4 control-label">Data da Abertura:</label>
                  <p class="form-control-static">${view.dateInicio}</p>              
                  <label class="col-xs-4 control-label">Data de Fechamento:</label>
                  <p class="form-control-static">${view.dataFim}</p>
              </div>
            </div>
          </div>
        </fieldset>
    </div>
</div>
<c:import url="footer.jsp" />