package br.jogo.risk.dao;

import br.jogo.risk.model.PlanoDeRiscos;

public interface PlanoDeRiscoDao extends GenericDao {

	public PlanoDeRiscos findByProjetoAndJogo(Long projetoId, Long jogoId);

}
