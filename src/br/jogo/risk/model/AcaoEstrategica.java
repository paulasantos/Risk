package br.jogo.risk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="acaoestrategica_sequence", allocationSize=1)
public class AcaoEstrategica {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	private String descricao;
	
	@ManyToOne
	private Risco risco;

	@ManyToOne
	private RiscoAnalisado riscoAnalisado;
	
	@ManyToOne
	private Fase faseDeRealizacao;
	
	private String responsáveis;
	
	private Double custo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Risco getRisco() {
		return risco;
	}

	public void setRisco(Risco risco) {
		this.risco = risco;
	}

	public RiscoAnalisado getRiscoAnalisado() {
		return riscoAnalisado;
	}

	public void setRiscoAnalisado(RiscoAnalisado riscoAnalisado) {
		this.riscoAnalisado = riscoAnalisado;
	}

	public Fase getFaseDeRealizacao() {
		return faseDeRealizacao;
	}

	public void setFaseDeRealizacao(Fase faseDeRealizacao) {
		this.faseDeRealizacao = faseDeRealizacao;
	}

	public String getResponsáveis() {
		return responsáveis;
	}

	public void setResponsáveis(String responsáveis) {
		this.responsáveis = responsáveis;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
}
