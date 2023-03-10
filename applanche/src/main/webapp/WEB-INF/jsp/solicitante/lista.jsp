<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Listagem de Solicitantes</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Solicitantes</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/solicitante" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty solicitantes}">
			<h5>Não existem solicitantes cadastrados!!!</h5>
		</c:if>
	
		<c:if test="${not empty solicitantes}">
			<h5>Quantidade de solicitantes cadastrados: ${solicitantes.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>CPF</th>
			      <th>E-mail</th>
			      <th>Usuário</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="s" items="${solicitantes}">
				    <tr>
				      <td>${s.id}</td>
				      <td>${s.nome}</td>
				      <td>${s.cpf}</td>
				      <td>${s.email}</td>
				      <td>${s.usuario.nome}</td>
				      <td><a href="/solicitante/${s.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>