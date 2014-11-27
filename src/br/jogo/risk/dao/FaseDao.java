package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.Fase;

public interface FaseDao extends GenericDao{

	public List<Fase> findAll();
	
}