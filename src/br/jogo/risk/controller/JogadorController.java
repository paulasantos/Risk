package br.jogo.risk.controller;

import br.com.bronx.accesscontrol.annotation.AccessDenied;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
@Path("/{contexto}/jogadores")
@AccessDenied(loginPage = "/index/negado", accessDeniedPage = "/index/negado")
public class JogadorController {

}
