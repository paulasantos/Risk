package br.jogo.risk.dao;

import java.util.List;

import br.jogo.risk.model.Turma;


public interface TurmaDao extends GenericDao{

	public List<Turma> findByProfessor(Long professorId);
	
	public Turma find(Long turmaId);
}