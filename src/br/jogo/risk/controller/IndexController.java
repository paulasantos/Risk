package br.jogo.risk.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.JogadorDao;
import br.jogo.risk.dao.JogadorSession;
import br.jogo.risk.model.Jogador;

@Resource
@Path("")
public class IndexController {
	
	private Result result;
	private JogadorDao jogadorDao;
	private JogadorSession jogadorSession;

	public IndexController(Result result, JogadorDao jogadorDao, JogadorSession jogadorSession) {
		this.result = result;
		this.jogadorDao = jogadorDao;
		this.jogadorSession = jogadorSession;
	}
	
	@Get("/redefinirSenha")
	public void redefinirSenha(){
		
	}
	
	@Get("/efetuarCadastro")
	public void formulario(){	
	}
	
	@Post("/cadastrarJogador")
	public void salvar(Jogador jogador){
		jogadorDao.save(jogador);
		jogadorSession.setJogador(jogador);
		result.redirectTo(JogoController.class).inicio();
	}
}
