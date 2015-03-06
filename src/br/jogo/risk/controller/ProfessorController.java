package br.jogo.risk.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.FaseDao;
import br.jogo.risk.dao.PlanoDeRiscoDao;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.dao.TurmaDao;
import br.jogo.risk.dao.UsuarioDao;
import br.jogo.risk.dao.UsuarioSession;
import br.jogo.risk.model.AcaoEstrategica;
import br.jogo.risk.model.AnaliseDeRisco;
import br.jogo.risk.model.PlanoDeRiscos;
import br.jogo.risk.model.Projeto;
import br.jogo.risk.model.Turma;
import br.jogo.risk.util.enums.TipoDeProjeto;

@Resource
@Path("/professores")
public class ProfessorController {
	
	private Result result;
	private FaseDao faseDao;
	private TurmaDao turmaDao;
	private ProjetoDao projetoDao;
	private UsuarioDao usuarioDao;
	private PlanoDeRiscoDao planoDeRiscoDao;
	private UsuarioSession usuarioSession;

	public ProfessorController(Result result, ProjetoDao projetoDao, PlanoDeRiscoDao planoDeRiscoDao, FaseDao faseDao, UsuarioSession usuarioSession, 
			UsuarioDao usuarioDao, TurmaDao turmaDao) {
		this.result = result;
		this.projetoDao = projetoDao;
		this.planoDeRiscoDao = planoDeRiscoDao;
		this.usuarioSession = usuarioSession;
		this.faseDao = faseDao;
		this.usuarioDao = usuarioDao;
		this.turmaDao = turmaDao;
	}
	
	@Get({"", "/"})
	public void projetos() {
		result.include("projetos", projetoDao.findProjetoByProfessor(usuarioSession.getJogador().getId()));
	}
	
	@Get("/projeto/new")
	public void formularioProjeto(){}

	@Get("/projeto/{projetoId}/edit")
	public void editProjeto(Long projetoId) {
		result.include("projeto", projetoDao.find(projetoId))
		.forwardTo(this).formularioProjeto();
	}

	@Post("/projeto")
	public void saveProjeto(Projeto projeto){
		projeto.setProfessor(usuarioSession.getJogador());
		projeto.setTipo(TipoDeProjeto.INDIVIDUAL.getTipo());
		projetoDao.save(projeto);
		result.redirectTo(this).projetos();
	}
	
	@Put("/projeto")
	public void updateProjeto(Projeto projeto){
		projeto.setProfessor(usuarioSession.getJogador());
		projeto.setTipo(TipoDeProjeto.INDIVIDUAL.getTipo());
		projetoDao.update(projeto);
		result.redirectTo(this).projetos();
	}

	@Delete("/projeto/delete/{id}")
	public void deleteProjeto( Long id ){
		Projeto projeto = projetoDao.find(id);
		if(projeto != null){
			projetoDao.delete(projeto);
		}
		result.include("Projeto deletado com sucesso.", "success").redirectTo(this).projetos();
	}
	
	@Get("/turmas")
	public void turmas(){
		result.include("turmas", turmaDao.findByProfessor(usuarioSession.getJogador().getId()));
	}
	
	@Get("/turma/new")
	public void formularioTurma(){
		result.include("projetos", projetoDao.findAll());
	}
	
	@Post("/turma")
	public void saveTurma(Turma turma){
		turmaDao.save(turma);
		result.redirectTo(this).turmas();
	}

	@Get("/turma/{turmaId}/edit")
	public void editTurma(Long turmaId) {
		result.include("turma", turmaDao.find(turmaId))
		.forwardTo(this).formularioTurma();
	}
	
	@Put("/turma")
	public void updateTurma(Turma turma){
		turmaDao.update(turma);
		result.redirectTo(this).turmas();
	}
	
	@Delete("/turma/delete/{id}")
	public void deleteTurma( Long id ){
		Turma turma = turmaDao.find(id);
		if(turma != null){
			projetoDao.delete(turma);
		}
		result.include("Turma deletada com sucesso.", "success").redirectTo(this).turmas();
	}

	@Get("/turma/alunos/{turmaId}")
	public void turmaAdicionarAlunos(Long turmaId){
	}
	
	@Get("/plano/new")
	public void formularioPlanoDeRisco(){
	}

	@Get("/plano/{projetoId}")
	public void plano(Long projetoId){
		result.include("projeto", projetoDao.find(projetoId)).include("fases", faseDao.findAll()).redirectTo(this).formularioPlanoDeRisco();
	}
	
	@Get("/plano/{planoId}/edit")
	public void editPlano(Long planoId) {
		result.include("projeto", projetoDao.find(planoId))
		.redirectTo(this).formularioPlanoDeRisco();
	}

	@Post("/plano")
	public void savePlano(PlanoDeRiscos planoDeRiscos){
		planoDeRiscos = formatarPlanoDeRiscos(planoDeRiscos);
		planoDeRiscos.setUsuario(usuarioSession.getJogador());
		planoDeRiscoDao.save(planoDeRiscos);
		
		result.redirectTo(this).projetos();;
	}

	@Put("/plano")
	public void updatePlano(PlanoDeRiscos planoDeRiscos){
		planoDeRiscoDao.update(planoDeRiscos);
		result.redirectTo(this).projetos();
	}
	
	private PlanoDeRiscos formatarPlanoDeRiscos(PlanoDeRiscos planoDeRiscos) {
		List<AnaliseDeRisco> analisesDeRiscos = planoDeRiscos.getAnalisesDeRiscos();

		for (AnaliseDeRisco analiseDeRisco : analisesDeRiscos) {
			analiseDeRisco.setPlanoDeRiscos(planoDeRiscos);
			List<AcaoEstrategica> acoesEstrategicas = analiseDeRisco.getAcoesEstrategicas();
			for (AcaoEstrategica acaoEstrategica : acoesEstrategicas) {
				acaoEstrategica.setAnaliseDeRisco(analiseDeRisco);
			}
		}
		planoDeRiscos.setAnalisesDeRiscos(analisesDeRiscos);
		return planoDeRiscos;
	}
}