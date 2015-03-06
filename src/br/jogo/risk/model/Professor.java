package br.jogo.risk.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="usuario_sequence", allocationSize=1)
public class Professor extends Usuario{
	
	@OneToMany(mappedBy="professor")
	private List<Projeto> projetos;

}
