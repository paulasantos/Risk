package br.jogo.risk.model;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy="planoDeRiscos", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AnaliseDeRisco> analisesDeRiscos;
	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AnaliseDeRisco> getAnalisesDeRiscos() {
		return analisesDeRiscos;
	}

	public void setAnalisesDeRiscos(List<AnaliseDeRisco> analisesDeRiscos) {
		this.analisesDeRiscos = analisesDeRiscos;
	}
}