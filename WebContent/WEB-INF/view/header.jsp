<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <link href="css/style.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  
    <div class="container-fluid"> 
    
		<div class="row-fluid">
		
			<div class="span3">
				
				<div class="menu-lat">
					<h3 position="center" font-color="white">LOGADO COMO: ${usuario.nome}</h3>
					<ul class="nav nav-list">
    						<li><a href="pagina_inicial">inicio</a></li>
   						    <c:set var="tipoUsuario" value="${usuario.tipo}" />
							<c:set var="administrador" value="administrador" />
							<c:set var="usuario1" value="usuario" />
							
							<c:if  test="${tipoUsuario == administrador}" >
    							<li><a href="cria_solucionador">Adicionar solucionador</a></li>
    							<li><a href="cria_usuario">Adicionar usuario</a></li>
    							<li><a href="lista_solucionador">Todos os Solucionadores</a></li>
    							<li><a href="lista_de_usuarios">Todos os Usuarios</a></li>
    							<li><a href="lista_chamado">Todos os Chamados</a></li>
    							
    						</c:if>
    						<c:if test="${tipoUsuario == usuario1}">
    							<li><a href="fazer_chamado">fazer Chamado</a></li>
    						<form class="navbar-form navbar-left"action="usuario_menu" method="post">
    						<input   type="hidden" value="${usuario.id}" name="id"/>
    					<li><a><input type="submit" class="span6 btn-link"value="meus chamados"></a></li>
   				 </form>
   				 			</c:if>
    							
    							<li><a href="logout">logout</a></li> 
   						 </ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
		<div class="span9">
  
</head>
<body>
