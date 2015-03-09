package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.AcaoEstrategica;

public interface AcaoEstrategicaDao extends GenericDao{

	public List<AcaoEstrategica> findByAnalise(Long analiseId);
}
