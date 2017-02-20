package br.com.ufpb.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.DesafioDAO;

public class ListarDesafioLogica implements Logica {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		DesafioDAO dao = new DesafioDAO();
		request.setAttribute("lista", dao.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/listarDesafios.jsp");
		rd.forward(request, response);
	}

}
