package br.jogo.risk.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.SessionScoped;
import br.jogo.risk.dao.AcaoEstrategicaDao;
import br.jogo.risk.model.AcaoEstrategica;

@Component
@SessionScoped
public class AcaoEstrategicaDaoImpl extends GenericDaoImpl implements AcaoEstrategicaDao {

	@SuppressWarnings("unchecked")
	public List<AcaoEstrategica> findByAnalise(Long analiseId){
		return getSession().createCriteria(AcaoEstrategica.class, "ae")
				.add(Restrictions.eq("ae.analiseDeRisco.id", analiseId))
				.list();
		
	}
}
