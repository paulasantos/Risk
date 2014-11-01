package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.RiscoDao;
import br.jogo.risk.model.Risco;

@Component
@RequestScoped
public class RiscoDaoImpl extends GenericDaoImpl implements RiscoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Risco> findRiscosByProjeto(Long projetoId) {
		return (List<Risco>) getSession().createCriteria(Risco.class, "r").add(Restrictions.eq("r.projeto.id", projetoId));
	}
}
