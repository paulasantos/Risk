package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.Projeto;

public interface ProjetoDao extends GenericDao{

	public List<Projeto> findAll();

	public Projeto find(Long projetoId);
}
