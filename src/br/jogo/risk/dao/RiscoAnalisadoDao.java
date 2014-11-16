package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.AnaliseDoRisco;

public interface RiscoAnalisadoDao extends GenericDao{

	public AnaliseDoRisco find(Long riscoSelecionado, Long projetoId);

	public List<AnaliseDoRisco> list(Long projetoId);

}
