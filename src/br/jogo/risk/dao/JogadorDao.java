package br.jogo.risk.dao;

import br.jogo.risk.model.Jogador;

public interface JogadorDao extends GenericDao{

	boolean jogadorExist(Long jogadorId);

	public Jogador find(String login, String senha);

	public boolean verificarDisponibilidade(String login);

	public void updateJogadorByLogin(Jogador jogador);

}
