package br.com.ufpb.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.ContextoDAO;
import br.com.ufpb.dao.DesafioDAO;
import br.com.ufpb.dao.UsuarioDAO;
import br.com.ufpb.modelo.Contexto;
import br.com.ufpb.modelo.Desafio;
import br.com.ufpb.modelo.Usuario;
import br.com.ufpb.mvc.servlet.UploadServlet;

public class CadastrarDesafioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Desafio desafio = new Desafio();
		DesafioDAO desafioDao = new DesafioDAO();
		// palavra imagem som video usuario e contexto
		String palavra = request.getParameter("palavra");
		String idCon = request.getParameter("idContexto");
		
		Contexto contexto = new Contexto();
		ContextoDAO contextoDao = new ContextoDAO();
		
		long idContexto = Long.parseLong(idCon);
		contexto = contextoDao.getById(idContexto);
			
		String imagem = UploadServlet.caminhoImagem;
		String som = UploadServlet.caminhoSom;
		String video = UploadServlet.caminhoVideo;
		String id = request.getParameter("idUsuario");
		long idUsuario = Long.parseLong(id);
		/*
		 * Salvando no MYSQL
		 */
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuario=usuarioDao.getById(idUsuario);
		desafio.setPalavra(palavra);
		desafio.setImagem(imagem);
		desafio.setSom(som);
		desafio.setVideo(video);
		desafio.setUsuario(usuario);
		desafio.setContexto(contexto);
		//salvar no banco
		desafioDao.save(desafio);
		
	}

}
