package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.Risco;

public interface RiscoDao extends GenericDao{
	
	public List<Risco> findRiscosByProjeto(Long projetoId);

}
