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
	public Long id;
	
	public String nome;

	@OneToMany(mappedBy="faseDeRealizacao")
	public List<AnaliseAcaoEstrategica> analiseAcaoEstrategicas;
	
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

	public List<AnaliseAcaoEstrategica> getAnaliseAcaoEstrategicas() {
		return analiseAcaoEstrategicas;
	}

	public void setAnaliseAcaoEstrategicas(
			List<AnaliseAcaoEstrategica> analiseAcaoEstrategicas) {
		this.analiseAcaoEstrategicas = analiseAcaoEstrategicas;
	}
}
