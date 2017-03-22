package br.com.ufpb.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.ContextoDAO;
import br.com.ufpb.dao.UsuarioDAO;
import br.com.ufpb.modelo.Contexto;
import br.com.ufpb.modelo.Usuario;
import br.com.ufpb.mvc.servlet.UploadServlet;

public class CadastrarContextoLogica implements Logica {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Contexto contexto = new Contexto();
		Usuario usuario = new Usuario();
		ContextoDAO contextoDao = new ContextoDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		// pegando da pagina
		String nome = request.getParameter("nome");
		String imagem = UploadServlet.caminhoImagem;
		String som = UploadServlet.caminhoSom;
		String video = UploadServlet.caminhoVideo;
		// usuariow
		String idS = request.getParameter("idUsuario");
		long id = Long.parseLong(idS);
		usuario = usuarioDao.getById(id);
		/*
		 * Salvando no MYSQL
		 */
		contexto.setNome(nome);
		contexto.setImagem(imagem);
		contexto.setSom(som);
		contexto.setVideo(video);
		contexto.setUsuario(usuario);
		contextoDao.save(contexto);

	}

}
