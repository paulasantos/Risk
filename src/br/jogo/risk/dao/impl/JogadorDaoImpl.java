package br.jogo.risk.dao.impl;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Jogador find(String login, String senha) {
		return (Jogador) getSession().createCriteria(Jogador.class, "j")
				.add(Restrictions.eq("j.login", login))
				.add(Restrictions.eq("j.senha", senha))
				.uniqueResult();
	}

}
