package br.jogo.risk.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.PerfilDao;
import br.jogo.risk.dao.UsuarioDao;
import br.jogo.risk.dao.UsuarioSession;
import br.jogo.risk.model.Usuario;
import br.jogo.risk.util.enums.Perfil;

@Resource
@Path("")
public class IndexController {
	
	private Result result;
	private UsuarioDao usuarioDao;
	private UsuarioSession usuarioSession;
	private PerfilDao perfilDao;

	public IndexController(Result result, UsuarioDao usuarioDao, UsuarioSession usuarioSession, PerfilDao perfilDao) {
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.usuarioSession = usuarioSession;
		this.perfilDao = perfilDao;
	}
	
	@Get("/redefinirSenha")
	public void redefinirSenha(){
		
	}
	
	@Get("/efetuarCadastro")
	public void formulario(){	
		result.include("perfis", perfilDao.findAll());
	}
	
	@Post("/cadastrarJogador")
	public void salvar(Usuario usuario){
		usuarioDao.save(usuario);
		usuario = usuarioDao.find(usuario);
		
		usuarioSession.setUsuario(usuario);
		
		if(usuario.getPerfil().getNome().equals(Perfil.JOGADOR.getPerfil()))
			result.redirectTo(JogoController.class).inicio();
		else
			result.redirectTo(ProfessorController.class).cadastro();
	}

	@Post("/atualizarSenha")
	public void atualizarSenha(Usuario usuario){
		usuarioDao.updateByLogin(usuario);
		usuario = usuarioDao.find(usuario);
		
		usuarioSession.setUsuario(usuario);
		
		if(usuario.getPerfil().getNome().equals(Perfil.JOGADOR.getPerfil()))
			result.redirectTo(JogoController.class).inicio();
		else
			result.redirectTo(ProfessorController.class).cadastro();
	}
	
	@Get("/verificarDisponibilidade/{login}")
	public void verificarDisponibilidade(String login){
		result.use(json()).from(usuarioDao.verificarDisponibilidade(login)).serialize();
	}
}