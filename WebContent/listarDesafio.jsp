<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Desafios</title>
</head>
<body>
	<nav>
	<a href="index.html">S i s a l f a</a>
		<ul>
			<li><a href="index.html">Inicio</a></li>
			<li><a href="listarContexto.jsp">Contextos</a></li>
			<li><a href="listarDesafio.jsp">Desafios</a></li>
			<li><a href="">Contribua</a></li>
			<li><a href="sobre.html">Sobre</a></li>
		</ul>
	</nav>
	<section id="conteudo">	
		<h3>Menu Desafio</h3>
			<a href="cadastrarDesafio.html"><button>Novo Desafio</button></a><br>
			<h3>Desafios :</h3>
					<jsp:useBean id="dao" class="br.com.ufpb.dao.DesafioDAO"/>
					  <!-- for -->
					  <c:forEach var="desafio" items="${dao.findAll()}">
					   	  		Palavra: <br><label>${desafio.palavra}</label>
					      		<img src="${desafio.imagem}" alt="imagem">
					  </c:forEach> 
					  
	</section>
</body>
</html>