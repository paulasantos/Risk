package br.jogo.risk.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.envers.RevisionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.jogo.risk.model.Jogador;

public class RevisionListenerImpl  implements RevisionListener {
	
	public void newRevision(Object revisionEntity) {
			
		Jogador jogador = (Jogador) getSession().getAttribute("jogadorSession");
		
        CustomRevisionEntity exampleRevEntity = (CustomRevisionEntity) revisionEntity;
        exampleRevEntity.setJogador(jogador);
        
	}
	
	private HttpServletRequest getRequest() {  
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        return requestAttributes.getRequest();  
    }  
  
    private HttpSession getSession() {  
        return getRequest().getSession();  
    }
}
