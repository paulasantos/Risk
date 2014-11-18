package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.PlanoDeRiscos;

public interface PlanoDeRiscoDao extends GenericDao {

	public PlanoDeRiscos findByProjetoAndJogo(Long projetoId, Long jogoId);

	public List<PlanoDeRiscos> findPlanosCompartilhados();

	public List<PlanoDeRiscos> findMyPlanos(Long professorId);

}
