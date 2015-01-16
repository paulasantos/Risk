package br.jogo.risk.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="fase_sequence", allocationSize=1)
public class Fase {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	private String nome;

	@OneToMany(mappedBy="faseDeRealizacao")
	private List<AcaoEstrategica> acoesEstrategicas;
	
	@OneToMany(mappedBy="fase")
	private List<Projeto> projetos;
	
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

	public List<AcaoEstrategica> getAcoesEstrategicas() {
		return acoesEstrategicas;
	}

	public void setAcoesEstrategicas(
			List<AcaoEstrategica> analiseAcaoEstrategicas) {
		this.acoesEstrategicas = analiseAcaoEstrategicas;
	}
}
