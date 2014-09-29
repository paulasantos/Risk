package br.jogo.risk.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.JogadorDao;
import br.jogo.risk.model.Jogador;

@Component
@RequestScoped
public class JogadorDaoImpl extends GenericDaoImpl implements JogadorDao{

	@Override
	public boolean jogadorExist(Long jogadorId) {
		Criteria criteria = getSession().createCriteria(Jogador.class, "j");
		
		criteria.add(Restrictions.eq("j.id", jogadorId));

		return (criteria.list().size() > 0);
	}

	@Override
	public Jogador find(String login, String senha) {
		return (Jogador) getSession().createCriteria(Jogador.class, "j")
				.add(Restrictions.eq("j.login", login))
				.add(Restrictions.eq("j.senha", senha))
				.uniqueResult();
	}

}
