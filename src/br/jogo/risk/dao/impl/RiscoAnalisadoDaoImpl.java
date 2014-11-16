package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.RiscoAnalisadoDao;
import br.jogo.risk.model.AnaliseDoRisco;

@Component
@RequestScoped
public class RiscoAnalisadoDaoImpl extends GenericDaoImpl implements RiscoAnalisadoDao {

	@Override
	public AnaliseDoRisco find(Long riscoSelecionado, Long projetoId) {
		return (AnaliseDoRisco) getSession().createCriteria(AnaliseDoRisco.class, "ra")
				.createCriteria("ra.planoDeProjeto", "pp")
				.add(Restrictions.eq("ra.id", riscoSelecionado))
				.add(Restrictions.eq("pp.projeto.id", projetoId))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnaliseDoRisco> list(Long projetoId) {
		return  getSession().createCriteria(AnaliseDoRisco.class, "ra")
				.createCriteria("ra.planoDeRiscos", "pp")
				.add(Restrictions.eq("pp.projeto.id", projetoId))
				.list();
	}	
}
