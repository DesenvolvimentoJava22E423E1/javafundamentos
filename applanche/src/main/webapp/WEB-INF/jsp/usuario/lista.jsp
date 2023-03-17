<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!--  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"> -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>AppLanche</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<h3>Listagem de Usu�rios</h3>

		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Aten��o!</strong> ${mensagem}
			</div>		
		</c:if>
		
		<c:if test="${empty usuarios}">
			<h5>N�o existem usu�rios cadastrados!!!</h5>
		</c:if>
		
		<c:if test="${not empty usuarios}">
			<h5>Quantidade de usu�rios cadastrados: ${usuarios.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Senha</th>
			      <th>E-mail</th>
			      <th>Caracter�sticas</th>
			      <th>Tipo</th>
			      <th>Setor</th>
			      <th>Idade</th>
			      <th>Sal�rio</th>
			      <th>Solicitantes</th>
			      <th>Produtos</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="u" items="${usuarios}">
				    <tr>
				      <td>${u.id}</td>
				      <td>${u.nome}</td>
				      <td>${u.senha}</td>
				      <td>${u.email}</td>
				      <td>${u.caracteristicas}</td>
				      <td>${u.tipo}</td>
				      <td>${u.setor}</td>
				      <td>${u.idade}</td>
				      <td>${u.salario}</td>
				      <td>${u.solicitantes.size()}</td>
				      <td>${u.produtos.size()}</td>
				      <td><a href="/usuario/${u.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>
	</div>

</body>
</html>