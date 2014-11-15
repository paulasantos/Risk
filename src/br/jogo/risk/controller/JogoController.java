package br.jogo.risk.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.PlanoDeRiscoDao;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.dao.RiscoAnalisadoDao;
import br.jogo.risk.dao.RiscoDao;
import br.jogo.risk.model.PlanoDeRiscos;
import br.jogo.risk.model.Projeto;
import br.jogo.risk.model.Risco;
import br.jogo.risk.model.RiscoAnalisado;

@Resource
@Path("/jogo")
public class JogoController {
	
	private Result result;
	private ProjetoDao projetoDao;
	private RiscoDao riscoDao;
	private PlanoDeRiscoDao planoDeRiscoDao;
	private RiscoAnalisadoDao riscoAnalisadoDao;

	public JogoController(Result result, ProjetoDao projetoDao, RiscoDao riscoDao, PlanoDeRiscoDao planoDeRiscoDao, RiscoAnalisadoDao riscoAnalisadoDao) {
		this.result = result;
		this.projetoDao = projetoDao;
		this.riscoDao = riscoDao;
		this.planoDeRiscoDao = planoDeRiscoDao;
		this.riscoAnalisadoDao = riscoAnalisadoDao;
	}
	
	@Get("")
	public void inicio() {
		result.include("projetos",projetoDao.findAll());
	}
	
	@Post
	public void jogar(Projeto projeto) {
		List<Risco> riscos = riscoDao.find();
		PlanoDeRiscos planoDeRiscos = new PlanoDeRiscos();
		result.include("projeto",  projetoDao.find(projeto.getId())).include("riscos", riscos).include("planoDeRiscos",planoDeRiscos);
	}
	
	@Post("/riscos")
	public void riscos(ArrayList<RiscoAnalisado> selecionados, Projeto projeto){
		System.out.println(selecionados.get(0).getRisco().getId());
		PlanoDeRiscos planoDeRiscos = new PlanoDeRiscos();
		planoDeRiscos.setRiscosAnalisados(selecionados);
		planoDeRiscos.setRiscosAnalisados(selecionados);
		planoDeRiscos.setProjeto(projeto);
		planoDeRiscoDao.save(planoDeRiscos);
		result.include(planoDeRiscos);
	}
		
	@Get("/riscos/{riscoSelecionado}/{projetoId}")
	public void analise(Long riscoSelecionado, Long projetoId){
		if(riscoSelecionado != null)
			result.include("riscoAnalisado", riscoAnalisadoDao.find(riscoSelecionado, projetoId));

		result.include("riscosSelecionados", riscoAnalisadoDao.list(projetoId));
	}
	
	@Post("/riscos")
	public void saveRiscosAnalisados(RiscoAnalisado riscoSelecionado){
		riscoAnalisadoDao.save(riscoSelecionado);
		result.redirectTo(this).analise(riscoSelecionado.getId(), riscoSelecionado.getPlanoDeRiscos().getProjeto().getId());
	}
}
