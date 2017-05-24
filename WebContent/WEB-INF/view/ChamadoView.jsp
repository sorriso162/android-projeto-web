<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />
<h1>ChamadoView</h1>
<p>NOME DO USUARIO${view.nomeUsuario}</p>
<p>DESCRICAO DO CHAMADO: ${view.descricao}</p>
<p>TIPO: ${view.tipo}</p>
<p>STATUS: ${view.status}</p>
<p>DATA DE ABERTURA ${view.dateInicio}</p>
<p>DATA DE FECHAMENTO ${view.dataFim}</p>
<p>NOME DO SOLUCIONADOR ${view.nomeSolucionador}</p>
<c:import url="footer.jsp" />