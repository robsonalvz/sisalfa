<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Listar Contextos</title>
	<style type="text/css">
	
	</style>
</head>
<body>
  
 <h3>Contextos cadastrados</h3>
<table  class="tablela">
	<tr class="nome">  
		<td>Id</td>
		<td>Nome</td>
		<td>Imagem </td>
		<td>Som</td>   
		<td>Vídeo</td>
		<td>Usuário</td>
	</tr> 

	<c:forEach var="contato" items="${lista}">
	<tr class="valores">
		<td>${contato.nome}</td>
		<td>${contato.imagem}</td> 
		<td>${contato.som}</td>	  
		<td>${contato.video}</td>
	</tr>   
	</c:forEach>    	    	           
</table><br> 
       		  
<a href="index.html">
		<button>Início</button>
	</a> 


</body>
</html>