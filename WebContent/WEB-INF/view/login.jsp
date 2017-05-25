<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

 
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="login-form ">
	<form method="post" action="fazer_login">
			<div class="text-login">
				<h1 class="text-login">Login</h1>
			</div>
		<input type="text" name="cpf"/><br>
		<input type="password" name="senha"/><br>
		<button type="submit" id="btnLogin">Clique Aqui</button>
	</form>
	</div>
</body>	
</html>