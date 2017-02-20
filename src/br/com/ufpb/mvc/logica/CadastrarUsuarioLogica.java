package br.com.ufpb.mvc.logica;



import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.UsuarioDAO;
import br.com.ufpb.modelo.Usuario;

public class CadastrarUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setStatus(true);
		Date data = new Date();
		data.getTime();
		usuario.setDataEntrada(data);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.save(usuario);
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request,response);
	}

}
