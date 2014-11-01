package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.SessionScoped;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.model.Projeto;

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
}
