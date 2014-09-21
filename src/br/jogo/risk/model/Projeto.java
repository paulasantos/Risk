package br.jogo.risk.model;

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
	
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescrcao(String descricao) {
		this.descricao = descricao;
	}
}
