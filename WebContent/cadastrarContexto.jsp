<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
	<title>Cadastrar Contexto</title>
</head>
<body>
<form class="formulario" action="uploadServlet" method="POST" enctype="multipart/form-data"> 
			
			<fieldset id="fieldset">
			<legend class="contexto">Cadastrar Contexto</legend>
			<label class="nome">Nome:</label> <input placeholder="Digite o nome do contexto..." type="text" name="nome" /><br /> 
			<label class="nome">ID Usuário:</label> <input placeholder="Digite o id..." type="text" name="idUsuario" /><br /> 
			<label>Imagem:</label>  <input type="file" name="fileImagem" size="60" /><br />		
			<label>Som:</label>  <input type="file" name="fileSom" size="60" /><br />	
			<label>Video:</label>  <input type="file" name="fileVideo" size="60" /><br />	
				
			</fieldset><br>
			<input type="hidden" value="CadastrarContextoLogica" name="logica" />		
			<input type="submit" class="botao"value="Gravar" />
</form>  
		<a href="index.html">
			<button>Inicio</button>
		</a> 
	<label>${mensagem}!</label> 
</body>
</html>