package br.jogo.risk.dao.impl;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.jogo.risk.dao.UsuarioSession;
import br.jogo.risk.model.Usuario;

@Component @SessionScoped
@SuppressWarnings("serial")
public class JogadorSessionImpl implements UsuarioSession, Serializable {

	private HttpSession session;
	
	public JogadorSessionImpl(HttpSession session) {
		this.session = session;
	}
	
	@Override
	public Usuario getJogador() {
		return (Usuario) session.getAttribute("jogadorSession");
	}

	@Override
	public void setUsuario(Usuario jogador) {
		this.session.setAttribute("jogadorSession", jogador);
	}

}
