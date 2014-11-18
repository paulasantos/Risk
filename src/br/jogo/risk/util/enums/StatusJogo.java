package br.jogo.risk.util.enums;

public enum StatusJogo {
	
	INICIADO ('I'),
	FINALIZADO ('F');
	
	private Character status;
	
	private StatusJogo(Character status) {
		this.status = status;
	}
	
	public Character getStatus(){
		return status;
	}
}
