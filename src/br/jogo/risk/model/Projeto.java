package br.jogo.risk.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="projeto")
	private List<PlanoDeRiscos> planoDeRiscos;
	
	@OneToMany(mappedBy="projeto")
	private List<Jogo> jogos;
	
	@OneToMany(mappedBy="projeto")
	private List<Turma> turmas;

	@ManyToOne 
	private Usuario professor;

	@ManyToOne
	private Fase fase;

	private String orcamento;
	
	private Integer cronograma;
	
	private Integer qtdMembros;

	private Character tipo;
	
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

	public List<PlanoDeRiscos> getPlanoDeRiscos() {
		return planoDeRiscos;
	}

	public void setPlanoDeRiscos(List<PlanoDeRiscos> planoDeRiscos) {
		this.planoDeRiscos = planoDeRiscos;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public String getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
	}
	
	public Integer getCronograma() {
		return cronograma;
	}

	public void setCronograma(Integer cronograma) {
		this.cronograma = cronograma;
	}

	public Integer getQtdMembros() {
		return qtdMembros;
	}

	public void setQtdMembros(Integer qtdMembros) {
		this.qtdMembros = qtdMembros;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

}