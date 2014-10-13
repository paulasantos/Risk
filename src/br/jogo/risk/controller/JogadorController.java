package br.jogo.risk.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.JogadorDao;

@Resource
@Path("/jogadores")
public class JogadorController {
	
	private Result result;
	private JogadorDao jogadorDao;

	public JogadorController(Result result, JogadorDao jogadorDao) {
		this.result = result;
		this.jogadorDao = jogadorDao;
	}
	
	public void isJogadorExister(Long id){
		jogadorDao.jogadorExist(id);
	}
}
