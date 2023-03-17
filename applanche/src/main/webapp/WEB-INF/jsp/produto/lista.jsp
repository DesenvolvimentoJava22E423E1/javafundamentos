<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Listagem de Produtos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Produtos</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Aten��o!</strong> ${mensagem}
			</div>		
		</c:if>

		<c:if test="${empty produtos}">
			<h5>N�o existem produtos cadastrados!!!</h5>
		</c:if>
	
		<c:if test="${not empty produtos}">
			<h5>Quantidade de produtos cadastrados: ${produtos.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>C�digo</th>
			      <th>Nome</th>
			      <th>Valor</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="p" items="${produtos}">
				    <tr>
				      <td>${p.id}</td>
				      <td>${p.codigo}</td>
				      <td>${p.nome}</td>
				      <td>${p.valor}</td>
				      <td><a href="/produto/${p.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>