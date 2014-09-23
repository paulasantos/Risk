package br.jogo.risk.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.jogo.risk.dao.JogadorSession;

@Intercepts
public class JogadorSessionInterceptor implements Interceptor{

	private Result result;
	private JogadorSession jogadorSession;

	public JogadorSessionInterceptor(Result result, JogadorSession jogadorSession) {
		this.result = result;
		this.jogadorSession = jogadorSession;
	}
	
	@Override
	public boolean accepts(ResourceMethod arg0) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object object) throws InterceptionException {
		if(jogadorSession.getJogador() != null){
			result.include("jogadorNome", jogadorSession.getJogador().getNome())
			.include("jogadorId", jogadorSession.getJogador().getId())
			.include("logado", true);			
			stack.next(method, object);
		}else{
			result.include("logado", false);
			stack.next(method, object);
		}
	}
}
