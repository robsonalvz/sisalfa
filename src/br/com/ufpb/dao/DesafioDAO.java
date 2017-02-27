package br.com.ufpb.dao;

import br.com.ufpb.modelo.Desafio;

public class DesafioDAO extends GenericDAO <Desafio> {
	
	public long retornaIdDesafio(){
		DesafioDAO dao = new DesafioDAO();
		int ultimo = dao.findAll().size();
		return dao.findAll().get(ultimo-1).getId();
	}
}
