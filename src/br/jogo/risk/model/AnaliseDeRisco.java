package br.jogo.risk.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="analisederisco_sequence", allocationSize=1)
public class AnaliseDeRisco {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	@OneToOne
	private Risco risco;
		
	private Character prioridade;
	
	private Character impacto;
	
	private Character probabilidade;
	
	private Character estrategia;
	
	@ManyToOne
	private PlanoDeRiscos planoDeRiscos;
	
	@OneToMany(mappedBy="analise")
	private List<AnaliseAcaoEstrategica> analiseAcoesEstrategicas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Risco getRisco() {
		return risco;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

	public Character getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Character prioridade) {
		this.prioridade = prioridade;
	}

	public Character getImpacto() {
		return impacto;
	}

	public void setImpacto(Character impacto) {
		this.impacto = impacto;
	}

	public Character getProbabilidade() {
		return probabilidade;
	}

	public void setProbabilidade(Character probabilidade) {
		this.probabilidade = probabilidade;
	}

	public Character getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Character estrategia) {
		this.estrategia = estrategia;
	}
	
	public PlanoDeRiscos getPlanoDeRiscos() {
		return planoDeRiscos;
	}

	public void setPlanoDeRiscos(PlanoDeRiscos planoDeRiscos) {
		this.planoDeRiscos = planoDeRiscos;
	}

	public List<AnaliseAcaoEstrategica> getAnaliseAcoesEstrategicas() {
		return analiseAcoesEstrategicas;
	}

	public void setAnaliseAcoesEstrategicas(
			List<AnaliseAcaoEstrategica> analiseAcoesEstrategicas) {
		this.analiseAcoesEstrategicas = analiseAcoesEstrategicas;
	}
}
