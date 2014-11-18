package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.SessionScoped;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.model.Projeto;
import br.jogo.risk.util.enums.TipoDeProjeto;

@Component
@SessionScoped
public class ProjetoDaoImpl extends GenericDaoImpl implements ProjetoDao {

	@SuppressWarnings("unchecked")
	public List<Projeto> findAll() {
		return getSession().createCriteria(Projeto.class, "p").list();
	}

	@Override
	public Projeto find(Long projetoId) {
		return (Projeto) getSession().createCriteria(Projeto.class,"p")
				.add(Restrictions.eq("p.id", projetoId))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> findProjetoByProfessor(Long professorId) {
		return  getSession().createCriteria(Projeto.class,"p")
		.add(Restrictions.eq("p.professor.id", professorId))
		.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> findProjetoCompartilhados() {
		return  getSession().createCriteria(Projeto.class,"p")
				.add(Restrictions.eq("p.tipo", TipoDeProjeto.INDIVIDUAL.getTipo() ))
				.list();
	}
}
