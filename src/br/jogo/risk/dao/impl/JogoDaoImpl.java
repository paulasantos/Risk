package br.jogo.risk.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.JogoDao;
import br.jogo.risk.model.Jogo;
import br.jogo.risk.util.enums.StatusJogo;

@Component
@RequestScoped
public class JogoDaoImpl extends GenericDaoImpl implements JogoDao{

	@Override
	public Jogo findJogoIniciado(Long projetoId, Long jogadorId) {
		return (Jogo) getSession().createCriteria(Jogo.class, "j").
		add(Restrictions.eq("j.projeto.id", projetoId)).
		add(Restrictions.eq("j.jogador.id", jogadorId)).
		add(Restrictions.eq("j.status", StatusJogo.INICIADO.getStatus())).uniqueResult();
	}	
}
