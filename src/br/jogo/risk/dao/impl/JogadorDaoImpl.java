package br.jogo.risk.dao.impl;

import org.springframework.stereotype.Component;

import br.com.caelum.vraptor.ioc.RequestScoped;
import br.jogo.risk.dao.JogadorDao;

@Component
@RequestScoped
public class JogadorDaoImpl extends GenericDaoImpl implements JogadorDao{

}