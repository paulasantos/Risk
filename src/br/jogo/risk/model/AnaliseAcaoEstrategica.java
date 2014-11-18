package br.jogo.risk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="analiseacaoestrategica_sequence", allocationSize=1)
public class AnaliseAcaoEstrategica {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	@ManyToOne
	private AcaoEstrategica estrategia;
	
	@ManyToOne
	private Risco risco;

	@ManyToOne
	private AnaliseDeRisco analise;
	
	@ManyToOne
	private Fase faseDeRealizacao;
	
	private String responsaveis;
	
	private Double custo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AcaoEstrategica getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(AcaoEstrategica estrategia) {
		this.estrategia = estrategia;
	}

	public Risco getRisco() {
		return risco;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

	public AnaliseDeRisco getAnalise() {
		return analise;
	}

	public void setAnalise(AnaliseDeRisco analise) {
		this.analise = analise;
	}

	public Fase getFaseDeRealizacao() {
		return faseDeRealizacao;
	}

	public void setFaseDeRealizacao(Fase faseDeRealizacao) {
		this.faseDeRealizacao = faseDeRealizacao;
	}

	public String getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(String responsaveis) {
		this.responsaveis = responsaveis;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
}
