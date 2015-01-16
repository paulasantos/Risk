package br.jogo.risk.model;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Risco risco;
		
	private Character prioridade;
	
	private Character impacto;
	
	private Character probabilidade;
	
	private Character estrategia;
	
	private Character tipo;
	
	@ManyToOne
	private PlanoDeRiscos planoDeRiscos;
	
	@OneToMany(mappedBy="analiseDeRisco", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AcaoEstrategica> acoesEstrategicas;

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

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public List<AcaoEstrategica> getAcoesEstrategicas() {
		return acoesEstrategicas;
	}

	public void setAcoesEstrategicas(List<AcaoEstrategica> acoesEstrategicas) {
		this.acoesEstrategicas = acoesEstrategicas;
	}
}
