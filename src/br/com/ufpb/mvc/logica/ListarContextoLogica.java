package br.com.ufpb.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ufpb.dao.ContextoDAO;

public class ListarContextoLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ContextoDAO dao = new ContextoDAO();
		
		request.setAttribute("lista", dao.findAll());
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarContextos.jsp");
		rd.forward(request, response);
	}

}
