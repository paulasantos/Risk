package br.jogo.risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="risco_sequence", allocationSize=1)
public class Risco {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	@Column(columnDefinition="TEXT")
	private String descricao;
		
	@ManyToOne
	private Projeto projeto;
	
	@ManyToOne
	private Categoria categoria;

}
