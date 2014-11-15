package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.RiscoAnalisado;

public interface RiscoAnalisadoDao extends GenericDao{

	public RiscoAnalisado find(Long riscoSelecionado, Long projetoId);

	public List<RiscoAnalisado> list(Long projetoId);

}
