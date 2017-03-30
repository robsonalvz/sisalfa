package br.com.ufpb.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.DesafioDAO;
import br.com.ufpb.modelo.Desafio;

public class AlterarDesafioLogica implements Logica {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Desafio desafio = new Desafio();
		DesafioDAO desafioDao = new DesafioDAO();
		String ids = request.getParameter("idDesafio");
		String palavra = request.getParameter("palavra");	
		long id = Long.parseLong(ids);
		desafio = desafioDao.getById(id);
		desafio.setPalavra(palavra);
		desafioDao.update(desafio);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.html");
		rd.forward(request, response);
	}

}
