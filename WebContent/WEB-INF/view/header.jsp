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
    <p>NOME DO USUARIO :${usuario.nome}</p>
    <!-- Bootstrap -->
    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <p>Menu do Usuario</p>
    <c:set var="tipoUsuario" value="${usuario.tipo}" />
	<c:set var="administrador" value="administrador" />
	<c:if  test="${tipoUsuario == administrador}" >
    <a href="criar_solucionador">criar solucionador</a>
    <a href="cria_usuario">Criar usuario</a>
    </c:if>
    <a href="fazer_chamado">FAzer Chamado</a>
    <form action="usuario_menu" method="post">
    <input type="hidden" value="${usuario.id}" name="id"/>
    <button type="submit" class="span6 btn-link">meus chamados</button>
    </form>
    <a href="pagina_inicial">inicio</a>
    <a href="logout">logout</a> 
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
</head>
<body>
