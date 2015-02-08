package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.Usuario;

public interface UsuarioDao extends GenericDao{

	boolean jogadorExist(Long jogadorId);

	public Usuario find(Usuario usuario);

	public boolean verificarDisponibilidade(String login);

	public void updateByLogin(Usuario jogador);

	public List<Usuario> findAllJogadores();

}
