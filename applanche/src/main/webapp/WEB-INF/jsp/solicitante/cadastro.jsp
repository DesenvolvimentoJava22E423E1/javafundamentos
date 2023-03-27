<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Solicitantes</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<form action="/solicitante/incluir" method="post">
			<h3>Cadastro de Solicitantes</h3>
		
			<div class="form-group">
				<label>Nome:</label> 	
				<input type="text" name="nome" value="Elberth Moraes" class="form-control">
			</div>

			<div class="form-group">
				<label>CPF:</label> 	
				<input type="text" name="cpf" value="098765432-21" class="form-control">
			</div>

			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" name="email" value="elberth@gmail.com" class="form-control">
			</div>
			
			<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp"/>			

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>