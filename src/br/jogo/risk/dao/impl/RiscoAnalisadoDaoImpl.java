package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.RiscoAnalisadoDao;
import br.jogo.risk.model.AnaliseDeRisco;

@Component
@RequestScoped
public class RiscoAnalisadoDaoImpl extends GenericDaoImpl implements RiscoAnalisadoDao {

	@Override
	public AnaliseDeRisco find(Long riscoSelecionado, Long projetoId) {
		return (AnaliseDeRisco) getSession().createCriteria(AnaliseDeRisco.class, "ra")
				.createCriteria("ra.planoDeProjeto", "pp")
				.add(Restrictions.eq("ra.id", riscoSelecionado))
				.add(Restrictions.eq("pp.projeto.id", projetoId))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnaliseDeRisco> list(Long projetoId) {
		return  getSession().createCriteria(AnaliseDeRisco.class, "ra")
				.createCriteria("ra.planoDeRiscos", "pp")
				.add(Restrictions.eq("pp.projeto.id", projetoId))
				.list();
	}	
}
