package br.jogo.risk.util;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import br.jogo.risk.model.Jogador;


//@Entity
//@RevisionEntity(RevisionListenerImpl.class)
//@Table(name="revinfo")
public class CustomRevisionEntity extends DefaultRevisionEntity {
 
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch=FetchType.LAZY)
	private Jogador jogador;

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
 
}