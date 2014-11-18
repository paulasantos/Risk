package br.jogo.risk.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.UsuarioSession;
import br.jogo.risk.dao.PerfilDao;
import br.jogo.risk.dao.UsuarioDao;
import br.jogo.risk.model.Usuario;
import br.jogo.risk.util.enums.Perfil;

@Resource
@Path("/")
public class LoginController {
	
	private Result result;
	private UsuarioDao jogadorDao;
	private UsuarioSession jogadorSession;
	private PerfilDao perfilDao;

	public LoginController(Result result, UsuarioDao jogadorDao, UsuarioSession jogadorSession, PerfilDao perfilDao) {
		this.result = result;
		this.jogadorDao = jogadorDao;
		this.jogadorSession = jogadorSession;
		this.perfilDao = perfilDao;
	}
	
	@Get("")
	public void login(){
		result.include("perfis", perfilDao.findAll());
	}
	
	@Post("efetuarLogin")
	public void logar(Usuario usuario){
		Usuario user = jogadorDao.find(usuario);
		if(user != null){
			jogadorSession.setUsuario(user);
			if(user.getPerfil().getNome().equals(Perfil.JOGADOR.getPerfil()))
				result.redirectTo(JogoController.class).inicio();
			else
				result.redirectTo(ProfessorController.class).cadastro();
		}
		else{
			result.include("message", "Dados incorretos")
			.redirectTo(this).login();
		}
	}
	
}
