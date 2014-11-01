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
@Path("/")
public class LoginController {
	
	private Result result;
	private JogadorDao jogadorDao;
	private JogadorSession jogadorSession;

	public LoginController(Result result, JogadorDao jogadorDao, JogadorSession jogadorSession) {
		this.result = result;
		this.jogadorDao = jogadorDao;
		this.jogadorSession = jogadorSession;
	}
	
	@Get("")
	public void login(){
		
	}
	
	@Post("efetuarLogin")
	public void logar(Jogador jogador){
		Jogador jogadorTemp = jogadorDao.find(jogador.getLogin(), jogador.getSenha());
		if(jogadorTemp != null){
			jogadorSession.setJogador(jogadorTemp);
			result.redirectTo(JogoController.class).inicio();
		}
		else{
			result.include("message", "Login ou senha inválidos").redirectTo(this).login();
		}
	}
	
}
