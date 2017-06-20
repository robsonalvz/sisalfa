<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Contextos</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	 <script>
		$(document).ready(function(){
			$.getJSON("http://localhost:8080/meuProjetoWeb/webapi/contextos/getAll", function(result){
				$.each(result, function(indice, value){
					$("#contextos").append('<tr> <td>' + value.id + '</td>' + 
						'<td>' + value.nome + '</td>' + 
						'<td><img src="' + value.imagem + '"></td>' + 
						'<td>'+ value.som +'</td>' +
						'<td>'+ value.video +'</td>' +
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
	<h3>Contextos</h3><br>
	<a href="cadastrarContexto.html"><button>Novo Contexto</button></a>
	<section id="conteudoContexto">			
			   <table>
			   <thead>
				  	<tr>
				  		<th>id</th>
				   		<th>Nome</th>
				   		<th>Imagem</th>
				   		<th>Video</th>
						<th>Som</th>			   	
				  	</tr>
				</thead>
				  	<tbody id="contextos"></tbody>     		
	
			  </table>
	</section>
</body>
</html>