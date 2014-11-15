package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.RiscoAnalisadoDao;
import br.jogo.risk.model.RiscoAnalisado;

@Component
@RequestScoped
public class RiscoAnalisadoDaoImpl extends GenericDaoImpl implements RiscoAnalisadoDao {

	@Override
	public RiscoAnalisado find(Long riscoSelecionado, Long projetoId) {
		return (RiscoAnalisado) getSession().createCriteria(RiscoAnalisado.class, "ra")
				.createCriteria("ra.planoDeProjeto", "pp")
				.add(Restrictions.eq("ra.id", riscoSelecionado))
				.add(Restrictions.eq("pp.projeto.id", projetoId))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiscoAnalisado> list(Long projetoId) {
		return  getSession().createCriteria(RiscoAnalisado.class, "ra")
				.createCriteria("ra.planoDeProjeto", "pp")
				.add(Restrictions.eq("pp.projeto.id", projetoId))
				.list();
	}	
}
