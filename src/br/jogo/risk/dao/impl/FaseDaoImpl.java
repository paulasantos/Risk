package br.jogo.risk.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.SessionScoped;
import br.jogo.risk.dao.FaseDao;
import br.jogo.risk.model.Fase;

@Component
@SessionScoped
public class FaseDaoImpl extends GenericDaoImpl implements FaseDao {

	@SuppressWarnings("unchecked")
	public List<Fase> findAll() {
		return getSession().createCriteria(Fase.class, "f").list();
	}
}
