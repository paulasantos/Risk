package br.jogo.risk.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sequence", sequenceName="planoderiscos_sequence", allocationSize=1)
public class PlanoDeRiscos {

	@Id @GeneratedValue(strategy=GenerationType.AUTO, generator="sequence")
	private Long id;
	
	@OneToOne
	private Projeto projeto;
	
	@OneToMany(mappedBy="planoDeRiscos")
	private List<RiscoAnalisado> riscosAnalisados;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<RiscoAnalisado> getRiscosAnalisados() {
		return riscosAnalisados;
	}

	public void setRiscosAnalisados(List<RiscoAnalisado> riscosAnalisados) {
		this.riscosAnalisados = riscosAnalisados;
	}
}
