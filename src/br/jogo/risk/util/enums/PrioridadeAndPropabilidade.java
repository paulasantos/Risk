package br.jogo.risk.util.enums;

public enum PrioridadeAndPropabilidade {
	
	BAIXA ('B',"Baixa"),
	MEDIA ('M',"Média"),
	ALTA('A', "Alta");
	
	private Character status;
	private String descricao;
	
	private PrioridadeAndPropabilidade(Character status, String descricao) {
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