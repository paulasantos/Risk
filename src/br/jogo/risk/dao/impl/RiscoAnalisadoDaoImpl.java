package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.RiscoAnalisadoDao;
import br.jogo.risk.model.AnaliseDeRisco;

@Component
@RequestScoped
public class RiscoAnalisadoDaoImpl extends GenericDaoImpl implements RiscoAnalisadoDao{

	@Override
	public AnaliseDeRisco find(Long riscoSelecionado, Long projetoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnaliseDeRisco> list(Long projetoId) {
		return getSession().createCriteria(AnaliseDeRisco.class, "analise").createCriteria("analise.planoDeRiscos", "plr").
				add(Restrictions.eq("plr.projeto.id", projetoId)).list();
	}
		
}
