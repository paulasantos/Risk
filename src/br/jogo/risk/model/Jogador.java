package br.jogo.risk.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="jogador_sequence", allocationSize=1)
public class Jogador extends Usuario{
	
	@ManyToOne
	private Curso curso;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
