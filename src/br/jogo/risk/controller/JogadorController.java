package br.jogo.risk.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.JogadorDao;
import br.jogo.risk.model.Jogador;

@Resource
@Path("/jogadores")
public class JogadorController {
	
	private Result result;
	private JogadorDao jogadorDao;

	public JogadorController(Result result, JogadorDao jogadorDao) {
		this.result = result;
		this.jogadorDao = jogadorDao;
	}

	@Get("/new")
	public void formulario(){	
	}
	
	@Post("")
	public void salvar(Jogador jogador){
		jogadorDao.save(jogador);
		result.redirectTo(LoginController.class).login();
	}

}
