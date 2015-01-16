package br.jogo.risk.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.AnaliseAcaoEstrategicaDao;
import br.jogo.risk.dao.FaseDao;
import br.jogo.risk.dao.PlanoDeRiscoDao;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.dao.RiscoDao;
import br.jogo.risk.dao.UsuarioSession;
import br.jogo.risk.model.AcaoEstrategica;
import br.jogo.risk.model.AnaliseDeRisco;
import br.jogo.risk.model.PlanoDeRiscos;
import br.jogo.risk.model.Projeto;
import br.jogo.risk.util.enums.TipoDeProjeto;

@Resource
@Path("/professores")
public class ProfessorController {
	
	private Result result;
	private ProjetoDao projetoDao;
	private RiscoDao riscoDao;
	private PlanoDeRiscoDao planoDeRiscoDao;
	private UsuarioSession jogadorSession;
	private FaseDao faseDao;
	private AnaliseAcaoEstrategicaDao analiseAcaoEstrategicaDao;

	public ProfessorController(Result result, ProjetoDao projetoDao, RiscoDao riscoDao, PlanoDeRiscoDao planoDeRiscoDao, FaseDao faseDao, AnaliseAcaoEstrategicaDao acaoEstrategicaDao,
			UsuarioSession jogadorSession) {
		this.result = result;
		this.projetoDao = projetoDao;
		this.riscoDao = riscoDao;
		this.planoDeRiscoDao = planoDeRiscoDao;
		this.jogadorSession = jogadorSession;
		this.faseDao = faseDao;
		this.analiseAcaoEstrategicaDao = acaoEstrategicaDao;
	}
	
	@Get({"", "/"})
	public void cadastro() {
		result.include("projetos", projetoDao.findProjetoByProfessor(jogadorSession.getJogador().getId()));
	}
	
	
	@Get("/projeto/new")
	public void formularioProjeto(){}

	@Get("/projeto/{projetoId}/edit")
	public void editProjeto(Long projetoId) {
		result.include("projeto", projetoDao.find(projetoId))
		.redirectTo(this).formularioProjeto();
	}

	@Post("/projeto")
	public void saveProjeto(Projeto projeto){
		projeto.setProfessor(jogadorSession.getJogador());
		projeto.setTipo(TipoDeProjeto.INDIVIDUAL.getTipo());
		projetoDao.save(projeto);
		result.redirectTo(this).cadastro();
	}
	
	@Put("/projeto")
	public void projetoUpdate(Projeto projeto){
		projeto.setProfessor(jogadorSession.getJogador());
		projeto.setTipo(TipoDeProjeto.INDIVIDUAL.getTipo());
		projetoDao.update(projeto);
		result.redirectTo(this).cadastro();
	}

	@Delete("/projeto/delete/{id}")
	public void delete( Long id ){
		Projeto projeto = projetoDao.find(id);
		if(projeto != null){
			projetoDao.delete(projeto);
		}
		result.include("Projeto deletado com sucesso.", "success").redirectTo(this).cadastro();
	}
	
	@Get("/meusPlanos")
	public void meusPlanos(){
		List<PlanoDeRiscos> planos = planoDeRiscoDao.findMyPlanos(jogadorSession.getJogador().getId());
		result.include("planos", planos);		
	}
	
	@Get("/plano/new")
	public void formularioPlanoDeRisco(){
		result.include("projetos", projetoDao.findAll()).include("riscos", riscoDao.find()).include("fases", faseDao.findAll());
	}

	@Get("/plano/{planoId}/edit")
	public void editPlano(Long planoId) {
		result.include("projeto", projetoDao.find(planoId))
		.redirectTo(this).formularioPlanoDeRisco();
	}

	@Post("/plano")
	public void savePlano(PlanoDeRiscos planoDeRiscos){
		List<AnaliseDeRisco> analiseDeRiscos = planoDeRiscos.getAnalisesDeRiscos();

		for (AnaliseDeRisco analiseDeRisco : analiseDeRiscos) {
			List<AcaoEstrategica> analisesAcoesEstrategicas = analiseDeRisco.getAcoesEstrategicas();
			if(analisesAcoesEstrategicas != null)
				for (AcaoEstrategica analiseAcaoEstrategica : analisesAcoesEstrategicas) {
					if(analiseAcaoEstrategica != null)
//					analiseAcaoEstrategicaDao.save(analiseAcaoEstrategica.getEstrategia());
					analiseAcaoEstrategica.setAnaliseDeRisco(analiseDeRisco);
//					analiseAcaoEstrategica.setEstrategia(analiseAcaoEstrategica.getEstrategia());
				}
//			analiseDeRisco.setAnaliseAcoesEstrategicas(analisesAcoesEstrategicas);
		}
		
		planoDeRiscos.setAnalisesDeRiscos(analiseDeRiscos);		
		planoDeRiscos.setUsuario(jogadorSession.getJogador());
		planoDeRiscoDao.save(planoDeRiscos);
		
		result.redirectTo(this).meusPlanos();
	}
	
	@Put("/plano")
	public void updatePlano(PlanoDeRiscos planoDeRiscos){
		planoDeRiscoDao.update(planoDeRiscos);
		result.redirectTo(this).meusPlanos();
	}
	
	@Get("/projetosCompartilhados")
	public void projetosCompartilhados(){
		result.include("projetos", projetoDao.findProjetoCompartilhados());
	}
	
	@Get("/planosCompartilhados")
	public void planosCompartilhados(){
		planoDeRiscoDao.findPlanosCompartilhados();
	}
}