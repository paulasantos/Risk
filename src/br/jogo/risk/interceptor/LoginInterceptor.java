package br.jogo.risk.interceptor;

import java.util.Arrays;

import static br.com.caelum.vraptor.view.Results.http;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.jogo.risk.controller.IndexController;
import br.jogo.risk.controller.LoginController;
import br.jogo.risk.dao.JogadorDao;
import br.jogo.risk.dao.JogadorSession;

@Intercepts
public class LoginInterceptor implements Interceptor{

	private Result result;
	private JogadorSession jogadorSession;
	private JogadorDao jogadorDao;

	public LoginInterceptor(Result result, HttpServletRequest request, JogadorSession jogadorSession, JogadorDao jogadorDao) {
		this.result = result;
		this.jogadorSession = jogadorSession;
		this.jogadorDao = jogadorDao;
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {
		return !Arrays.asList(LoginController.class).contains(method.getMethod().getDeclaredAnnotations());
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object object) throws InterceptionException {
		boolean isJogadorLogado = ( jogadorSession.getJogador() != null );
		boolean isQuerAcessarLogin = method.getResource().getType().equals(LoginController.class);
		boolean isQuerAcessarIndex = method.getResource().getType().equals(IndexController.class);;
		
		if (isJogadorLogado){
			if(! jogadorDao.jogadorExist(jogadorSession.getJogador().getId())){
				jogadorSession.setJogador(null);
				result.use(http()).sendError(401, "Erro sessão!");
			}
		}else if(!isQuerAcessarLogin && !isQuerAcessarIndex && !isJogadorLogado){
			result.redirectTo(LoginController.class).login();
			stack.next(method, object);
		}
		stack.next(method, object);
	}
}