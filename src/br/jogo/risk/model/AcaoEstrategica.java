package br.jogo.risk.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="acaoestrategica_sequence", allocationSize=1)
public class AcaoEstrategica {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	private String descricao;
	
	@OneToMany(mappedBy="estrategia")
	private List<AnaliseAcaoEstrategica> analiseAcoes;
		
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

	public List<AnaliseAcaoEstrategica> getAnaliseAcoes() {
		return analiseAcoes;
	}

	public void setAnaliseAcoes(List<AnaliseAcaoEstrategica> analiseAcoes) {
		this.analiseAcoes = analiseAcoes;
	}
}