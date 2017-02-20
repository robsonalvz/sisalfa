<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Cadastrar Desafio</title>
</head>
<body>
<%@ page import="java.util.*, br.com.ufpb.dao.*, br.com.ufpb.modelo.*" %> 
<form class="formulario" action="uploadServlet" method="POST" enctype="multipart/form-data"> 
	<fieldset id="fieldset">
		<legend class="contexto">Cadastrar Desafio</legend>
		<label class="palavra">Palavra:</label> <input placeholder="Digite a palavra..." type="text" name="palavra" /><br /> 
		<label class="nome">ID Usuário:</label> <input placeholder="Digite o id..." type="text" name="idUsuario" /><br /> 			
		<label>Selecione o Contexto:</label><input placeholder="Digite o id do contexto" type="text" name="idContexto"/><br>
		<!--  <select name="time">
				<%
				 	ContextoDAO dao = new ContextoDAO();
				  	List<Contexto> contextos = dao.findAll();
				  	for (Contexto contexto : contextos) {
				 %> 
		 	
				<option value="idContexto">  <%=contexto.getId()%> </option>
			
			
				<% } %> 
		</select>
		-->
		
		<br>
		<label>Imagem:</label>  <input type="file" name="fileImagem" size="60" /><br />			
		<label>Som:</label> <input type="file" name="fileSom" size="60" /><br />	
		<label>Video:</label> <input type="file" name="fileVideo" size="60" /><br />	
		
		
	</fieldset><br>
	<input type="hidden" name="logica" value="CadastrarDesafioLogica"/>		
	<input type="submit" class="botao"value="Gravar" />
			
</form>	
		<a href="index.html">
		<button>Início</button>
		</a>

</body>
</html>