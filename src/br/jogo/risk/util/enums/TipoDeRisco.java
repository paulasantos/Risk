package br.jogo.risk.util.enums;

public enum TipoDeRisco {
	
	POSITIVO ('P',"Positivo"),
	NEGATIVO ('N',"Negativo");

	private Character status;
	private String descricao;
	
	private TipoDeRisco(Character status, String descricao) {
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
