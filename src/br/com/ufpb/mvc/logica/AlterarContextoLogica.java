package br.com.ufpb.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.ContextoDAO;
import br.com.ufpb.modelo.Contexto;

public class AlterarContextoLogica implements Logica{
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Contexto contexto = new Contexto();
		ContextoDAO contextoDao = new ContextoDAO();
		String ids = request.getParameter("idContexto");
		String nome = request.getParameter("nome");	
		long id = Long.parseLong(ids);
		contexto = contextoDao.getById(id);
		contexto.setNome(nome);
		contextoDao.update(contexto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.html");
		rd.forward(request,response);
		
	}

}
