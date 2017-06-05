<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema Chamado</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <link href="css/style.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</head>    

<body>
<c:set var="tipoUsuario" value="${usuario.tipo}" />
<c:set var="administrador" value="administrador" />
<c:set var="solucionador" value="solucionador" />
<c:set var="usuario1" value="usuario" />

    <nav class="navbar navbar-inverse">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="pagina_inicial"><span class="label label-success text-capitalize">Sistema de Chamados</span></a>
        </div>
    <div class="collapse navbar-collapse" id="example-1">		
				<ul class="nav navbar-nav navbar-right">
							<c:if  test="${tipoUsuario == administrador || tipoUsuario == usuario1}" >
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastrar<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<c:if  test="${tipoUsuario == administrador}" >
	                		<li><a href="cria_solucionador">Solucionador</a></li>
							<li><a href="cria_usuario">Usuário</a></li>
							</c:if>
							<li><a href="fazer_chamado">Chamado</a></li>
						</ul>
					</li>
					</c:if>
	                <li><button type="button" class="btn btn-success navbar-btn btn-circle"><a id="logout" href="logout">Logout</a></button></li>
				</ul>
				
				<c:if  test="${tipoUsuario == administrador || tipoUsuario == solucionador}" >
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Listar<span class="caret"></span></a>
						<ul class="dropdown-menu">
								<c:if  test="${tipoUsuario == administrador}" >
	    							<li><a href="lista_solucionador">Todos os Solucionadores</a></li>
	    							<li><a href="lista_de_usuarios">Todos os Usuarios</a></li>    							
	    							<li><a href="lista_chamado">Todos os Chamados</a></li>
	    						</c:if>
	    						<c:if  test="${tipoUsuario == solucionador}" >
	    							<li><a href="chamados_abertos">Chamados Abertos</a>
	    							<li><a href="chamados_atendimento">Minha lista de chamados</a>
	    							<li><a href="historico">Historico</a>
	    						</c:if>						
						</ul>
					</li>
				</ul>
			</c:if>
			<c:if test="${tipoUsuario == usuario1}">
	<form class="btn btn-success navbar-btn btn-circle"action="usuario_menu" method="post">
		<input   type="hidden" value="${usuario.id}" name="id"/>
		<input type="submit" id="logout" class="span6 btn-link"value="meus chamados">
  	</form>
</c:if>
		</div><!-- /.navbar-collapse -->
		
      </div>
    </nav>

