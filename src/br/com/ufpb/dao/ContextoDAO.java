package br.com.ufpb.dao;

import br.com.ufpb.modelo.Contexto;

public class ContextoDAO extends GenericDAO <Contexto>{
	
	public long retornaIdContexto(){
		ContextoDAO contextoDao = new ContextoDAO();
		int ultimo = contextoDao.findAll().size();
		return contextoDao.findAll().get(ultimo-1).getId();
	}

}
