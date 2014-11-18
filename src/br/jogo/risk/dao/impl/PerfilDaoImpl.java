package br.jogo.risk.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.PerfilDao;
import br.jogo.risk.model.Perfil;

@Component
@RequestScoped
public class PerfilDaoImpl extends GenericDaoImpl implements PerfilDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> findAll() {
		return getSession().createCriteria(Perfil.class, "p").list();
	}
}
