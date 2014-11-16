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
		Risco risco = new Risco();
		risco.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco.setId(2L);
		
		Risco risco3 = new Risco();
		risco3.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco3.setId(3L);
		
		Risco risco4 = new Risco();
		risco4.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco4.setId(4L);
		
		Risco risco5 = new Risco();
		risco5.setDescricao("saad  asdsfsf  sdfadsfdsfdsf   dsfdsfdsfsafdsfsaad"
				+ "asdsfsfsdf  adsfdsfdsfd  sfdsfdsfsafdsf  saadasdsfsfsdfadsfds    fdsfds  fdsfdsfs  afdsf");
		risco5.setId(5L);
		
		Risco risco6 = new Risco();
		risco6.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco6.setId(6L);
		
		Risco risco7 = new Risco();
		risco7.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco7.setId(7L);
		
		Risco risco8 = new Risco();
		risco8.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco8.setId(8L);
		
		Risco risco9 = new Risco();
		risco9.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco9.setId(2L);
		
		Risco risco10 = new Risco();
		risco10.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco10.setId(10L);
		
		Risco risco11 = new Risco();
		risco11.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco11.setId(11L);
		
		Risco risco12 = new Risco();
		risco12.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco12.setId(22L);
		
		Risco risco13 = new Risco();
		risco13.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco13.setId(13L);
		
		Risco risco14 = new Risco();
		risco14.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco14.setId(14L);
		
		Risco risco15 = new Risco();
		risco15.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco15.setId(15L);
		
		Risco risco16 = new Risco();
		risco16.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco16.setId(16L);
		
		Risco risco17 = new Risco();
		risco17.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco17.setId(17L);
		
		Risco risco18 = new Risco();
		risco18.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco18.setId(18L);
		
		Risco risco19 = new Risco();
		risco19.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco19.setId(19L);
		
		Risco risco20 = new Risco();
		risco20.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco20.setId(20L);
		
		Risco risco21 = new Risco();
		risco21.setDescricao("saadasdsfsfsdfadsfdsfdsfdsfdsfdsfsafdsf");
		risco21.setId(21L);
		
		riscos.add(risco3); riscos.add(risco4); riscos.add(risco5); riscos.add(risco6); riscos.add(risco7); riscos.add(risco8);
		riscos.add(risco9);riscos.add(risco10);riscos.add(risco11);riscos.add(risco12);riscos.add(risco13);riscos.add(risco14);
		riscos.add(risco15);riscos.add(risco16);riscos.add(risco17);riscos.add(risco18);riscos.add(risco19);riscos.add(risco20);riscos.add(risco21); 
		
		
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
