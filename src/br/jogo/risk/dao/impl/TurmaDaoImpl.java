package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.SessionScoped;
import br.jogo.risk.dao.TurmaDao;
import br.jogo.risk.model.Turma;

@Component
@SessionScoped
public class TurmaDaoImpl extends GenericDaoImpl implements TurmaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> findByProfessor(Long professorId) {
		Criteria criteria = getSession().createCriteria(Turma.class, "t");
		criteria.createCriteria("t.projeto", "p");
		criteria.add(Restrictions.eq("p.professor.id", professorId));
		return criteria.list();
	}

	@Override
	public Turma find(Long turmaId) {
		return (Turma) getSession().createCriteria(Turma.class,"p")
				.add(Restrictions.eq("p.id", turmaId))
				.uniqueResult();
	}
	
}
