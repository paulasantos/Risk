package br.jogo.risk.util.enums;

public enum TipoDeProjeto {
	
	COMPARTILHADO ('C',"Compatilhado"),
	INDIVIDUAL ('I',"Individual");
	
	private Character tipo;
	private String descricao;
	
	private TipoDeProjeto(Character tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public Character getTipo(){
		return this.tipo;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
