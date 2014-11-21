package br.jogo.risk.util.enums;

public enum Perfil {
	
	JOGADOR ("jogador"),
	PROFESSOR ("professor");
	
	private String perfil;
	
	private Perfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getPerfil(){
		return perfil;
	}
}
