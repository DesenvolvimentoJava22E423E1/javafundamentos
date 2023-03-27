<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Pedidos</title>
</head>
<body>
	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<form action="/pedido/incluir" method="post">
			<h3>Cadastro de Pedidos</h3>

			<div class="form-group">
				<label>Descrição:</label> 	
				<input type="text" name="descricao" value="Primeiro Pedido Cadastrado" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Características:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="web" value="true" class="form-check-input" > Atendimento Web
			      </label>
			    </div>
			</div>
			
<!-- 			<div class="form-group"> -->
<!-- 				<label>Data:</label> 	 -->
<!-- 				<input type="text" name="data" value="16/03/2023" class="form-control"> -->
<!-- 			</div> -->

			<div class="form-group">
				<c:if test="${not empty solicitantes}">
					<label>Solicitante:</label>
					<select name="solicitante" class="form-control">
						<c:forEach var="s" items="${solicitantes}">
							<option value="${s.id}">${s.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty solicitantes}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem solicitantes cadastrados!</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${not empty produtos}">
					<label>Produtos:</label>
				    <c:forEach var="p" items="${produtos}">
				    <div class="form-check">
				      <label class="form-check-label">
			        		<input type="checkbox" name="produtos" value="${p.id}" class="form-check-input"> ${p.nome}
				      </label>
				    </div>
				    </c:forEach>
				</c:if>
				<c:if test="${empty produtos}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem produtos cadastrados!</label>
				</c:if>
			</div>
			
			<button ${botao} type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>