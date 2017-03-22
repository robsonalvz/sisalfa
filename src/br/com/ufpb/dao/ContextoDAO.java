package br.com.ufpb.dao;

import br.com.ufpb.modelo.Contexto;

public class ContextoDAO extends GenericDAO <Contexto>{
	
	public long retornaIdContexto(){
		ContextoDAO dao = new ContextoDAO();
		int ultimo;
		if (dao.findAll().size()==0){
			ultimo= 0;
		}else{
			ultimo  = dao.findAll().size()-1;
		}
		return ultimo;
	}

}
