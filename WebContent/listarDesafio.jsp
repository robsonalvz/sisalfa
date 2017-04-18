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
	<h3>Desafios</h3>
	<a href="cadastrarDesafio.html"><button>Novo Desafio</button></a><br>
	<section id="conteudoDesafio">	
	
		<jsp:useBean id="dao" class="br.com.ufpb.dao.DesafioDAO"/>
		
		   <table>
		  		<c:forEach var="desafio" items="${dao.findAll()}">
		  		<tr>
			   		<th>Palavra</th>
			   		<th>Imagem</th>
			   		<th>Video</th>
					<th>Som</th>
					<th>Contexto</th>			   	
			  	</tr>
			  	
				<tr class="valores">
					<td>${desafio.palavra}</td>
					<td><img src="${desafio.imagem}"alt="imagem"></td>
					<td>
						<video width="320" height="240" controls="controls">
						<source src="${desafio.video}" type="video/mp4"></video>
					</td>
					<td><audio  controls="controls" src="${desafio.som}"></audio></td>
					<td>${desafio.contexto.nome}</td>
				</tr>
		  		</c:forEach> 	 
		  </table> 
	</section>
</body>
</html>