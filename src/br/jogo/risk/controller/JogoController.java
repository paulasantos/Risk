package br.jogo.risk.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.JogoDao;
import br.jogo.risk.dao.PerfilDao;
import br.jogo.risk.dao.PlanoDeRiscoDao;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.dao.RiscoAnalisadoDao;
import br.jogo.risk.dao.RiscoDao;
import br.jogo.risk.dao.UsuarioSession;
import br.jogo.risk.model.AnaliseDeRisco;
import br.jogo.risk.model.Jogo;
import br.jogo.risk.model.PlanoDeRiscos;
import br.jogo.risk.model.Projeto;
import br.jogo.risk.model.Risco;
import br.jogo.risk.util.enums.StatusJogo;

@Resource
@Path("/jogo")
public class JogoController {
	
	private Result result;
	private ProjetoDao projetoDao;
	private RiscoDao riscoDao;
	private PlanoDeRiscoDao planoDeRiscoDao;
	private RiscoAnalisadoDao riscoAnalisadoDao;
	private UsuarioSession jogadorSession;
	private JogoDao jogoDao;
	private PerfilDao perfilDao;

	public JogoController(Result result, ProjetoDao projetoDao, RiscoDao riscoDao, PlanoDeRiscoDao planoDeRiscoDao, 
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
	
	@Get("")
	public void inicio() {
		result.include("projetos",projetoDao.findAll());
	}
	
	@Post
	public void iniciarJogo(Projeto projeto) {
		Jogo jogo = jogoDao.findJogoIniciado(projeto.getId(), jogadorSession.getJogador().getId());		
		
		if(jogo == null){
			jogo = new Jogo();
			jogo.setProjeto(projeto);
			jogo.setJogador(jogadorSession.getJogador());
			jogo.setStatus(StatusJogo.INICIADO.getStatus());
			jogoDao.save(jogo);
			
			PlanoDeRiscos planoDeRiscos = new PlanoDeRiscos();
			planoDeRiscos.setProjeto(projeto);
			planoDeRiscos.setUsuario(jogadorSession.getJogador());
			planoDeRiscoDao.save(planoDeRiscos);
		}
		
		result.redirectTo(this).jogar(projeto, jogo);
	}
	
	@Get("/jogar")
	public void jogar(Projeto projeto, Jogo jogo) {
		List<Risco> riscos = riscoDao.find();		
		PlanoDeRiscos planoDeRiscos = planoDeRiscoDao.findByProjetoAndJogo(projeto.getId(), jogo.getId());
		
		result.include("projeto", projetoDao.find(jogo.getProjeto().getId())).
		include("riscos", riscos).
		include("planoDeRiscos",planoDeRiscos);
	}
	
	@Post("/riscos")
	public void saveRiscosASerAnalisados(PlanoDeRiscos planoDeRiscos, Projeto projeto){		
		planoDeRiscoDao.update(planoDeRiscos);
		result.include(planoDeRiscos).redirectTo(this).analise(projeto.getId());;
	}
		
	@Get("/riscos/{riscoSelecionado}/{projetoId}")
	public void analiseRisco(Long riscoSelecionado, Long projetoId){
		if(riscoSelecionado != null)
			result.include("riscoAnalisado", riscoAnalisadoDao.find(riscoSelecionado, projetoId));

		result.include("riscosSelecionados", riscoAnalisadoDao.list(projetoId));
	}
	
	@Get("/riscos/analise")
	public void analise(Long projetoId){
		List<AnaliseDeRisco> riscosSelecionados = riscoAnalisadoDao.list(projetoId);
		
		result.include("riscosSelecionados", riscosSelecionados);
	}

	@Get("/inicioCadastros")
	public void inicioCadastros() {
		
	}
	
}
