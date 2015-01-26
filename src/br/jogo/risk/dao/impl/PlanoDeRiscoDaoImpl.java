package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.PlanoDeRiscoDao;
import br.jogo.risk.model.PlanoDeRiscos;
import br.jogo.risk.util.enums.Perfil;
import br.jogo.risk.util.enums.StatusJogo;
import br.jogo.risk.util.enums.TipoDeProjeto;

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
		.addOrder(Order.asc("pr.id"))
		.setMaxResults(1)
		.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanoDeRiscos> findPlanosCompartilhados() {
		return getSession().createCriteria(PlanoDeRiscos.class, "pr")
				.createCriteria("pr.projeto", "p")
				.createCriteria("pr.usuario", "u")
				.createCriteria("u.perfil", "perf")
				.add(Restrictions.eq("p.tipo", TipoDeProjeto.COMPARTILHADO.getTipo()))
				.add(Restrictions.eq("perf.descricao.", Perfil.PROFESSOR.getPerfil()))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanoDeRiscos> findMyPlanos(Long professorId) {
		return getSession().createCriteria(PlanoDeRiscos.class, "pr")
				.add(Restrictions.eq("pr.usuario.id", professorId))
				.list();
	}
}