package br.com.ufpb.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.DesafioDAO;
import br.com.ufpb.modelo.Desafio;

public class ExcluirDesafioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Desafio desafio = new Desafio();
		DesafioDAO desafioDao = new DesafioDAO();
		/*Pegando os atributos*/
		String id = request.getParameter("idDesafio");
		long idDesafio = Long.parseLong(id);
		desafio = desafioDao.getById(idDesafio);
		/*Salvando no banco*/
		desafioDao.delete(desafio);
		/*Dispachando para pagina*/
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.html");
		rd.forward(request,response);
		
	}

}
