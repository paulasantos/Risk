package br.jogo.risk.util.enums;

public enum Impacto {
	
	BAIXO ('B',"Baixo"),
	MEDIO ('M',"Médio"),
	ALTO('A', "Alto");
	
	private Character status;
	private String descricao;
	
	private Impacto(Character status, String descricao) {
		this.status = status;
		this.descricao = descricao;
	}
	
	public Character getStatus(){
		return this.status;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
