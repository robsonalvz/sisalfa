<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Menu Contexto</title>
</head>
<body>
	<nav>
	<a href="">S i s a l f a</a>
		<ul>
			<li><a href="">Inicio</a></li>
			<li><a href="">Contextos</a></li>
			<li><a href="">Desafios</a></li>
			<li><a href="">Contribua</a></li>
		</ul>
	</nav>
	<%@ page import="java.util.*, br.com.ufpb.dao.*, br.com.ufpb.modelo.*" %> 
	<section id="conteudo">	
		<h3>Menu Contexto</h3>
			<a href="cadastrarContexto.html"><button>Cadastrar Contexto</button></a><br>
			<h3>Contextos :</h3>
			 <%
			 	ContextoDAO dao = new ContextoDAO();
			  	List<Contexto> contextos = dao.findAll();
			  	for (Contexto contexto : contextos) {
			 %>
			<h3>	<%=contexto.getNome()%> </h3>
	       <% } %> 		 
		<a href="index.html">
			<button>Início</button>
		</a> 
	</section>
	<footer>
		<h3>Desenvolvido por Robson Alves.</h3>
	</footer>
</body>
</html>