package br.com.ufpb.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.ContextoDAO;
import br.com.ufpb.modelo.Contexto;

public class ExcluirContextoLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ContextoDAO contextoDao = new ContextoDAO();
		String id = request.getParameter("idContexto");
		long idContexto = Long.parseLong(id);
		Contexto contexto = new Contexto();
		contexto = contextoDao.getById(idContexto);
		contextoDao.delete(contexto);
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.html");
		rd.forward(request,response);
	}

}
