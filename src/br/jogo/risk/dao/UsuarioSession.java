package br.jogo.risk.dao;

import br.jogo.risk.model.Usuario;

public interface UsuarioSession {
	
	public Usuario getJogador();
	public void setUsuario(Usuario jogador);
	
}
