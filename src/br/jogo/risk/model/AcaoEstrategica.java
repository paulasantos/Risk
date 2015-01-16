package br.jogo.risk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="analiseacaoestrategica_sequence", allocationSize=1)
public class AcaoEstrategica {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	private String acaoEstrategica;

	@ManyToOne
	private AnaliseDeRisco analiseDeRisco;
	
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

	public String getAcaoEstrategica() {
		return acaoEstrategica;
	}

	public void setAcaoEstrategica(String acaoEstrategica) {
		this.acaoEstrategica = acaoEstrategica;
	}

	public AnaliseDeRisco getAnaliseDeRisco() {
		return analiseDeRisco;
	}

	public void setAnaliseDeRisco(AnaliseDeRisco analiseDeRisco) {
		this.analiseDeRisco = analiseDeRisco;
	}
}