package br.jogo.risk.util.enums;

public enum Perfil {
	
	JOGADOR ("Jogador"),
	PROFESSOR ("Professor");
	
	private String perfil;
	
	private Perfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getPerfil(){
		return perfil;
	}
}
