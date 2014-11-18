package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.Perfil;

public interface PerfilDao extends GenericDao{
	
	public List<Perfil> findAll();
}
