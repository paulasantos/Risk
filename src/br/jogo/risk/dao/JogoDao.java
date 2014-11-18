package br.jogo.risk.dao;

import br.jogo.risk.model.Jogo;

public interface JogoDao  extends GenericDao{

	public Jogo findJogoIniciado(Long projetoId, Long jogadorId);

}
