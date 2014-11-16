package br.jogo.risk.util.enums;

public enum JogoStatus {
	
	INICIADO ('I'),
	FINALIZADO ('F');
	
	private Character status;
	
	private JogoStatus(Character status) {
		this.status = status;
	}
	
	public Character getStatus(){
		return status;
	}
}
