package br.jogo.risk.dao.impl;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.jogo.risk.dao.JogadorSession;
import br.jogo.risk.model.Jogador;

@Component @SessionScoped
@SuppressWarnings("serial")
public class JogadorSessionImpl implements JogadorSession, Serializable {

	private HttpSession session;
	
	public JogadorSessionImpl(HttpSession session) {
		this.session = session;
	}
	
	@Override
	public Jogador getJogador() {
		return (Jogador) session.getAttribute("jogadorSession");
	}

	@Override
	public void setJogador(Jogador jogador) {
		this.session.setAttribute("jogadorSession", jogador);
	}

}
