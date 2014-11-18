package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.AnaliseDeRisco;

public interface RiscoAnalisadoDao extends GenericDao{

	public AnaliseDeRisco find(Long riscoSelecionado, Long projetoId);

	public List<AnaliseDeRisco> list(Long projetoId);

}
