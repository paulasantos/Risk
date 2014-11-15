package br.jogo.risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity 
@SequenceGenerator(name="sequence", sequenceName="projeto_sequence", allocationSize=1)
public class Projeto {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	private String nome;
	
	@Column(columnDefinition="TEXT")
	private String resumo;
	
	@Column(columnDefinition="TEXT")
	private String descricao;
	
	private String fase;
	
	private Double orcamento;
	
	private Double cronograma;
	
	private Integer qtdMembros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public Double getCronograma() {
		return cronograma;
	}

	public void setCronograma(Double cronograma) {
		this.cronograma = cronograma;
	}

	public Integer getQtdMembros() {
		return qtdMembros;
	}

	public void setQtdMembros(Integer qtdMembros) {
		this.qtdMembros = qtdMembros;
	}
}
