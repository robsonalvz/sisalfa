<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Listar Desafios</title>
</head>
<body>
 <h3>Desafios cadastrados</h3>
<table class="tabela">
	<tr class="nome">  
		<td>Id</td>
		<td>Palavra</td>
		<td>Imagem</td>
		<td>Som</td>   
		<td>Vídeo</td> 
		<td>Usuário</td> 
		<td>Contexto</td>
	</tr> 
 
	<c:forEach var="desafio" items="${lista}">
	<tr class="valores">
		<td>${desafio.palavra}</td>
		<td>${desafio.imagem}</td> 
		<td>${desafio.som}</td>	  
		<td>${desafio.video}</td>
		<td>${desafio.contexto.nome}</td>	  	    
	</tr>   
	</c:forEach>    	    	           
</table><br> 
       		  
<a href="index.html">
		<button>Início</button>
	</a> 


</body>
</html>