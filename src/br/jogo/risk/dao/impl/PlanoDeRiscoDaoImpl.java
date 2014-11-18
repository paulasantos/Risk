package br.jogo.risk.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.PlanoDeRiscoDao;
import br.jogo.risk.model.PlanoDeRiscos;
import br.jogo.risk.util.enums.StatusJogo;

@Component
@RequestScoped
public class PlanoDeRiscoDaoImpl extends GenericDaoImpl implements PlanoDeRiscoDao{

	@Override
	public PlanoDeRiscos findByProjetoAndJogo(Long projetoId, Long jogoId){
		return (PlanoDeRiscos) getSession().createCriteria(PlanoDeRiscos.class, "pr")
		.createCriteria("pr.projeto", "p")
		.createAlias("p.jogos", "j")
		.add(Restrictions.eq("p.id", projetoId))
		.add(Restrictions.eq("j.id", jogoId))
		.add(Restrictions.eq("j.status", StatusJogo.INICIADO.getStatus()))
		.uniqueResult();
	}
}