<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Contextos</title>
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
		<h3>Menu Contexto</h3>
			<a href="cadastrarContexto.html"><button>Novo Contexto</button></a><br>
			<h3>Contextos :</h3>
					<jsp:useBean id="dao" class="br.com.ufpb.dao.ContextoDAO"/>
					  <!-- for -->
					  <c:forEach var="contexto" items="${dao.findAll()}">
					  			
						   	  		<label>Nome : ${contexto.nome} <br> scr: ${contexto.imagem}</label>
						   	  		
						      		<img src="${contexto.imagem}" alt="imagem">
						      		<br>
						      		<label>src : ${contexto.video}</label>
						      		<video width="320" height="240" controls="controls" autoplay="autoplay">
									<source src="${contexto.video}" type="video/mp4"></video>
						      		<br>
						      		<audio src="${contexto.som}"></audio>
								
					  </c:forEach> 
					  
	</section>
</body>
</html>