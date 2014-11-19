package br.jogo.risk.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.JogoDao;
import br.jogo.risk.dao.PerfilDao;
import br.jogo.risk.dao.PlanoDeRiscoDao;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.dao.RiscoAnalisadoDao;
import br.jogo.risk.dao.RiscoDao;
import br.jogo.risk.dao.UsuarioSession;

@Resource
@Path("/professores")
public class ProfessorController {
	
	private Result result;
	private ProjetoDao projetoDao;
	private RiscoDao riscoDao;
	private PlanoDeRiscoDao planoDeRiscoDao;
	private RiscoAnalisadoDao riscoAnalisadoDao;
	private UsuarioSession jogadorSession;
	private JogoDao jogoDao;
	private PerfilDao perfilDao;

	public ProfessorController(Result result, ProjetoDao projetoDao, RiscoDao riscoDao, PlanoDeRiscoDao planoDeRiscoDao, 
			RiscoAnalisadoDao riscoAnalisadoDao, UsuarioSession jogadorSession, JogoDao jogoDao, PerfilDao perfilDao) {
		this.result = result;
		this.projetoDao = projetoDao;
		this.riscoDao = riscoDao;
		this.planoDeRiscoDao = planoDeRiscoDao;
		this.riscoAnalisadoDao = riscoAnalisadoDao;
		this.jogadorSession = jogadorSession;
		this.jogoDao = jogoDao;
		this.perfilDao = perfilDao;
	}
	
	@Get({"", "/"})
	public void cadastro() {
//		result.include("projetos",projetoDao.findAll());
		result.include("projetos", projetoDao.findProjetoByProfessor(jogadorSession.getJogador().getId()));
	}
	
	@Get("/{projetoId}/edit")
	public void editProjeto(Long projetoId) {
//		result.include("projetos",projetoDao.findAll());
		result.include("projeto", projetoDao.find(projetoId))
		.redirectTo(this).formularioProjeto();
	}
	
	@Get("/projeto/new")
	public void formularioProjeto(){
		
	}

	@Get("/projetosCompartilhados")
	public void projetosCompartilhados(){
		result.include("projetos", projetoDao.findProjetoCompartilhados());
	}

	@Get("/meusPlanos")
	public void meusPlanos(){
		planoDeRiscoDao.findMyPlanos(jogadorSession.getJogador().getId());
	}
	
	@Get("/planosCompartilhados")
	public void planosCompartilhados(){
		planoDeRiscoDao.findPlanosCompartilhados();
	}
}
