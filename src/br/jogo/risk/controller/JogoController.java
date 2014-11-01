package br.jogo.risk.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.dao.RiscoDao;
import br.jogo.risk.model.Projeto;
import br.jogo.risk.model.Risco;

@Resource
@Path("/jogo")
public class JogoController {
	
	private Result result;
	private ProjetoDao projetoDao;
	private RiscoDao riscoDao;

	public JogoController(Result result, ProjetoDao projetoDao, RiscoDao riscoDao) {
		this.result = result;
		this.projetoDao = projetoDao;
		this.riscoDao = riscoDao;
	}
	
	@Get("")
	public void inicio() {
		List<Projeto> projetos = projetoDao.findAll();
		result.include("projetos", projetos);
	}
	
	@Post
	public void jogar(Projeto projeto) {
		result.include("projeto",  projetoDao.find(projeto.getId()));
	}

	@Get
	public void riscos(Long projetoId){
		List<Risco> riscos = riscoDao.findRiscosByProjeto(projetoId);
		
		
	}
}
