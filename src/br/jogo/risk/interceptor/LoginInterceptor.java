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
import br.jogo.risk.dao.UsuarioDao;
import br.jogo.risk.dao.UsuarioSession;

@Intercepts
public class LoginInterceptor implements Interceptor{

	private Result result;
	private UsuarioSession jogadorSession;
	private UsuarioDao jogadorDao;

	public LoginInterceptor(Result result, HttpServletRequest request, UsuarioSession jogadorSession, UsuarioDao jogadorDao) {
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
				jogadorSession.setUsuario(null);
				result.use(http()).sendError(401, "Erro sessão!");
			}
		}else if(!isQuerAcessarLogin && !isQuerAcessarIndex && !isJogadorLogado){
			result.redirectTo(LoginController.class).login();
		}
		
		if(!isJogadorLogado && (isQuerAcessarLogin || isQuerAcessarIndex)){
			stack.next(method, object);
		}else if(isJogadorLogado){
			stack.next(method, object);
		}
		
		
	}
}