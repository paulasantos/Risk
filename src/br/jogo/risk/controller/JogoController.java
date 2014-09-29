package br.jogo.risk.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.jogo.risk.dao.ProjetoDao;
import br.jogo.risk.model.Projeto;

@Resource
@Path("/projeto")
public class JogoController {

	
	private Result result;

	public JogoController(Result result, ProjetoDao projetoDao) {
		this.result = result;
	}
	
	@Get("")
	public void inicio() {
		List<Projeto> projetos = new ArrayList<Projeto>();
		Projeto projeto = new Projeto();
		projeto.setId(1L);
		projeto.setDescrcao("dadad");
		projeto.setNome("Projeto Base");
		projetos.add(projeto);
		result.include("projetos", projetos);
	}
	
	@Get("/{projetoId}/find")
	public void find(Long projetoId){
		
	}

}
