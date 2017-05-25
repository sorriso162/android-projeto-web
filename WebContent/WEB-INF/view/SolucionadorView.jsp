<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />
<h1>UsuarioView</h1>
<p>ID:  ${view.id}</p>
<p>NOME: ${view.nome}</p>
<p>CPF: ${view.cpf}</p>
<p>SENHA: ${view.senha}</p>
<p>TIPO: ${view.tipo}</p>
<fotm action="excluir_solucionador" method="POST">
<button type="submit"class="btn btn-danger">EXCLUIR SOLUCIONADOR</button>
<input type="hidden" value="${view.id}" name="id">
</fotm>
<button class="btn btn-warning"><a href="lista_solucionador">VOLTAR</a></button>
<c:import url="footer.jsp" />