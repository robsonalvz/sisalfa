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
	<br>
	<h3>Contextos</h3><br>
	<a href="cadastrarContexto.html"><button>Novo Contexto</button></a>
	<section id="conteudoContexto">
			<jsp:useBean id="dao" class="br.com.ufpb.dao.ContextoDAO"/>
			  <!-- for -->
			   <table>
			  <c:forEach var="contexto" items="${dao.findAll()}">
			   	<tr>
			   		<th>Nome</th>
			   		<th>Imagem</th>
			   		<th>Video</th>
					<th>Som</th>			   	
			   	</tr>
				<tr class="valores">
					<td>${contexto.nome }</td>
					<td><img src="${contexto.imagem}"alt="imagem"></td>
					<td>
						<video width="320" height="240" controls="controls">
						<source src="${contexto.video}" type="video/mp4"></video>
					</td>
					<td><audio  controls="controls" src="${contexto.som}"></audio></td>
				</tr>      		
						
			  </c:forEach> 
			  </table>
	</section>
</body>
</html>