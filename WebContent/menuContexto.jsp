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
	<a href="index.html">S i s a l f a</a>
		<ul>
			<li><a href="index.html">Inicio</a></li>
			<li><a href="cadastrarContexto.html">Contextos</a></li>
			<li><a href="cadastrarDesafio.html">Desafios</a></li>
			<li><a href="">Contribua</a></li>
			<li><a href="sobre.html">Sobre</a></li>
		</ul>
	</nav>
	<section id="conteudo">	
		<h3>Menu Contexto</h3>
			<a href="cadastrarContexto.html"><button>Cadastrar Contexto</button></a><br>
			<h3>Contextos :</h3>
					<jsp:useBean id="dao" class="br.com.ufpb.dao.ContextoDAO"/>
					  <!-- for -->
					  <c:forEach var="contato" items="${dao.findAll()}">
					   	  <fieldset> 
					   	  		<label>${contato.nome}</label>
					      		<img src="${contato.imagem}" alt="imagem">
					      </fieldset>
					  </c:forEach> 
	</section>
	<footer>
		<h4>Desenvolvido por Robson Alves.</h4>
	</footer>
</body>
</html>