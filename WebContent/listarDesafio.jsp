<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Desafios</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	 <script>
		$(document).ready(function(){
			$.getJSON("http://localhost:8080/Sisalfa/getAllChallenge", function(result){
				$.each(result, function(indice, value){
					$("#desafios").append('<tr> <td>' + value.id + '</td>' + 
						'<td>' + value.palavra + '</td>' + 
						'<td><img src="' + value.imagem + '"></td>' + 
						'<td>'+ value.som +'</td>' +
						'<td>'+ value.video +'</td>' +
						'<td>'+ value.contexto.id +'</td>' +
						'<td>'+ value.usuario.id +'</td>' +
						'</tr>'
					);	
				});
			});
		});
	</script>
</head>
<body>
	<nav>
	<a href="index.html">S i s a l f a</a>
		<ul>
			<li><a href="index.html">Inicio</a></li>
			<li><a href="listarContexto.jsp">Contextos</a></li>
			<li><a href="listarDesafio.jsp">Desafios</a></li>
			<li><a href="cadastrarUsuario.html">Usuario</a></li>
			<li><a href="sobre.html">Sobre</a></li>
		</ul>
	</nav>
	<br>
	<h3>Desafios</h3><br>
	<a href="cadastrarDesafio.html"><button>Novo Desafio</button></a>
	<section id="conteudoContexto">	
	
			
			   <table>
			   <thead>
				  	<tr>
				  		<th>id</th>
				   		<th>Palavra</th>
				   		<th>Imagem</th>
				   		<th>Video</th>
						<th>Som</th>
						<th>Contexto</th>	
						<th>Usuario</th>			   	
				  	</tr>
				</thead>
				  <tbody id="desafios"></tbody>     		
				  	    		

			  </table>
	</section>
</body>
</html>