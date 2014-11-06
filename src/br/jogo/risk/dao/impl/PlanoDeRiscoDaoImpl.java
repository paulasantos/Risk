package br.jogo.risk.dao.impl;

import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.PlanoDeRiscoDao;

@Component
@RequestScoped
public class PlanoDeRiscoDaoImpl extends GenericDaoImpl implements PlanoDeRiscoDao{
}
