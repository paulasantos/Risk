<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/js/jquery/demo.css">
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />
<script type="text/javascript" src="/risk/js/jquery/jquery.collapse_cookie_storage.js"></script>
<script type="text/javascript" src="/risk/js/jquery/jquery.collapse_storage.js"></script>
<script type="text/javascript" src="/risk/js/jquery/jquery.collapse.js"></script>

<jsp:include page="../professor/menuProfessor.jsp" />
<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<div class="content">
	<div class="box-big">
		<div class="box-title">
			<span>Cadastro</span>
		</div>
		<div class="box-content" style="margin-left: 65px;">
			<form id="projetoForm" class="account-form form-horizontal" action="<c:url value="/professores/plano"/>" method="POST">
				<c:if test="${planoDeRiscos.id != null}">
					<input type="hidden" name=planoDeRiscos.id" value="${planoDeRiscos.id}">
					<input type="hidden" name=planoDeRiscos.projeto.id" value="${planoDeRiscos.projeto.id}">
					<input type="hidden" name=planoDeRiscos.usuario.id" value="${planoDeRiscos.usuario.id}">
                  	<input type='hidden' name='_method' value='PUT'/>
				</c:if>

		    	<select id="projetoId" name="planoDeRiscos.projeto.id" class="required form-control">
					<option value="0">Escolha um Projeto...</option>
					<c:forEach items= "${projetos}" var="projeto">
						<option value="${projeto.id}"> ${projeto.nome} </option>
					</c:forEach>
				</select>	
				<div class="riscos">
					<div class="riscos-box-title">
						<span>Riscos</span>
					</div>
					<c:if test="${planoDeRiscos.id != null}">
						<div data-collapse="accordion persist" class="more-risco">
	 						<c:forEach items="${planoDeRiscos.analisesDeRiscos}" var="analiseDoRisco" varStatus="countRiscos"> 
	 							<input type="hidden" name=name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].id" value="${analisesDoRisco[${countRiscos.count-1}].id}">
	 							<input type="hidden" name=name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].risco.id" value="${analisesDoRisco[${countRiscos.count-1}].id"}">
						  		<h4>Risco ${countRiscos.count}</h4>
								<div class="riscos-content" riscoIndice="${countRiscos.count}">
									<div class="remove-risco">
					  			 		<button type="button" class="btn delete-risco" title="Remover">
					  			 			<i class="fa fa-trash"></i>
					  			 		</button>
					  				</div>
									<div class="form-group risco-title" >
										<label class="col-sm-2 control-label">Descrição</label>
									    <div class="col-sm-10">
											<input type="text" class="form-control required" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].risco.descricao" value="${analiseDoRisco.risco.descricao}" >
									    </div>
							  		</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Tipo do Risco</label>
									    <div class="col-sm-10">
											<input type="radio" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].tipo" value="P"> Positivo 
											<input type="radio" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].tipo" value="N"> Negativo
										</div>
									</div>
									
									<div class="form-group risco-options">
										<label for="probabilidade" class="col-sm-2 control-label" >Probabilidade</label>
										<div class="col-sm-10">
											<select id="probabilidade" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].probabilidade" class="required form-control risco-options-select">
												<option value="A">Alta</option>
												<option value="M">Média</option>
												<option value="B">Baixa</option>
											</select>
										</div>
									</div>
									<div class="form-group risco-options">
										<label for="impacto" class="col-sm-2 control-label">Impacto</label>
										<div class="col-sm-10">
											<select id="impacto" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].impacto" class="required form-control risco-options-select">
												<option value="A">Alto</option>
												<option value="M">Médio</option>
												<option value="B">Baixo</option>
											</select>
										</div>
									</div>
									<div class="form-group risco-options">
										<label for="prioridade" class="col-sm-2 control-label">Prioridade</label>
										<div class="col-sm-10">
											<select id="prioridade" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].prioridade" class="required form-control risco-options-select">
												<option value="A">Alta</option>
												<option value="M">Média</option>
												<option value="B">Baixa</option>
											</select>
										</div>
									</div>
									<div class="form-group risco-options">
										<label for="resposta" class="col-sm-2 control-label">Tipo de Resposta</label>
										<div class="col-sm-10">
											<select id="resposta" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].resposta" class="required form-control risco-options-select">
												<option value="E">Evitar</option>
												<option value="T">Transferir</option>
												<option value="M">Mistigar</option>
												<option value="C">Contingenciar</option>
											</select>
										</div>
									</div>
									<div class="risco-acoes" >
										<div class="riscos-box-title">
											<span>Ações de resposta ao risco</span>
										</div>
										<div data-collapse="accordion persist" class="acoes">
											<c:forEach items="${analiseDoRisco.analiseAcoesEstrategicas}" var="acoo" varStatus="countAcoes">
												<input type="hidden" name=name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].
														analiseAcoesEstrategicas[$countAcoes.count -1}].id" value="${acao}.id}">
	 											<input type="hidden" name=name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].analiseAcoesEstrategicas[${countAcoes.count -1}].
	 															estrategia.id" value="${acao.estrategia.id}">
										  		<h4>Ação ${countAcoes.count}</h4>
									  			<div risco="${countRiscos.count}" class="acao" acaoSize="1">
									  				<div class="remove-acao">
						  			 					<button type="button" class="btn delete-acao" title="Remover">
						  			 						<i class="fa fa-trash"></i>
						  			 					</button>
						  							</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">Ação de Resposta</label>
											    		<div class="col-sm-10 risco-acao-options">
															<input type="text" class="form-control" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].analiseAcoesEstrategicas[${countAcoes.count -1}].estrategia.descricao" value="${acao.estrategia.descricao}">
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-sm-2 control-label">Fase de Realização</label>
											    		<div class="col-sm-10 risco-acao-options">
													    	<select id="faseId" name="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].
																	analiseAcoesEstrategicas[${countAcoes.count -1}].faseDeRealizacao.id" class="required form-control">
																<option value="0">Escolha a fase de aplicação da ação...</option>
																<c:forEach items= "${fases}" var="fase">
																	<option value="${fase.id}"> ${fase.nome} </option>
																</c:forEach>
															</select>	
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">Custo</label>
											    		<div class="col-sm-10 risco-acao-options">
															<input type="text" id="valorAcaoEstrategica" class="form-control" name="planoDeRiscos.
															analisesDeRiscos[${countRiscos.count-1}].analiseAcoesEstrategicas[${countAcoes.count -1}].custo"
															value="planoDeRiscos.analisesDeRiscos[${countRiscos.count-1}].analiseAcoesEstrategicas[${countAcoes.count -1}].custo">
														</div>
													</div>							
								  				</div>
							  				</c:forEach>
										</div>
										<button type="button" class="btn add-acao" id="btnGravar"> Adcionar Ação </button>
									</div>
								</div>
						  </c:forEach>
						</div>
					</c:if>
					<c:if test="${planoDeRiscos.id == null}">
						<div data-collapse="accordion persist" class="more-risco">
					  		<h4>Risco 1</h4>
							<div class="riscos-content" riscoSize="1">
								<div class="remove-risco">
				  			 		<button type="button" class="btn delete-risco" title="Remover">
				  			 			<i class="fa fa-trash"></i>
				  			 		</button>
				  				</div>
								<div class="form-group risco-title" >
									<label class="col-sm-2 control-label">Descrição</label>
								    <div class="col-sm-10">
										<input type="text" class="form-control required" name="planoDeRiscos.analisesDeRiscos[0].risco.descricao" >
								    </div>
						  		</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Tipo do Risco</label>
								    <div class="col-sm-10">
										<input type="radio" name="planoDeRiscos.analisesDeRiscos[1].tipo" value="P"> Positivo 
										<input type="radio" name="planoDeRiscos.analisesDeRiscos[1].tipo" value="N"> Negativo
									</div>
								</div>
								
								<div class="form-group risco-options">
									<label for="probabilidade" class="col-sm-2 control-label" >Probabilidade</label>
									<div class="col-sm-10">
										<select id="probabilidade" name="planoDeRiscos.analisesDeRiscos[1].probabilidade" class="required form-control risco-options-select">
											<option value="A">Alta</option>
											<option value="M">Média</option>
											<option value="B">Baixa</option>
										</select>
									</div>
								</div>
								<div class="form-group risco-options">
									<label for="impacto" class="col-sm-2 control-label">Impacto</label>
									<div class="col-sm-10">
										<select id="impacto" name="planoDeRiscos.analisesDeRiscos[1].impacto" class="required form-control risco-options-select">
											<option value="A">Alto</option>
											<option value="M">Médio</option>
											<option value="B">Baixo</option>
										</select>
									</div>
								</div>
								<div class="form-group risco-options">
									<label for="prioridade" class="col-sm-2 control-label">Prioridade</label>
									<div class="col-sm-10">
										<select id="prioridade" name="planoDeRiscos.analisesDeRiscos[1].prioridade" class="required form-control risco-options-select">
											<option value="A">Alta</option>
											<option value="M">Média</option>
											<option value="B">Baixa</option>
										</select>
									</div>
								</div>
								<div class="form-group risco-options">
									<label for="resposta" class="col-sm-2 control-label">Tipo de Resposta</label>
									<div class="col-sm-10">
										<select id="resposta" name="planoDeRiscos.analisesDeRiscos[1].resposta" class="required form-control risco-options-select">
											<option value="E">Evitar</option>
											<option value="T">Transferir</option>
											<option value="M">Mistigar</option>
											<option value="C">Contingenciar</option>
										</select>
									</div>
								</div>
								<div class="risco-acoes" >
									<div class="riscos-box-title">
										<span>Ações de resposta ao risco</span>
									</div>
									<div data-collapse="accordion persist" class="acoes">
								  		<h4>Ação 1</h4>
							  			<div risco=0 class="acao" acaoSize="0">
							  				<div class="remove-acao">
				  			 					<button type="button" class="btn delete-acao" title="Remover">
				  			 						<i class="fa fa-trash"></i>
				  			 					</button>
				  							</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">Ação de Resposta</label>
									    		<div class="col-sm-10 risco-acao-options">
													<input type="text" class="form-control" name="planoDeRiscos.analisesDeRiscos[1].analiseAcoesEstrategicas[0].estrategia.descricao"
														value="Promover treinamento da equipe sobre gerenciamento de projetos">
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-2 control-label">Fase de Realização</label>
									    		<div class="col-sm-10 risco-acao-options">
											    	<select id="faseId" name="planoDeRiscos.analisesDeRiscos[1].analiseAcoesEstrategicas[1].faseDeRealizacao.id" class="required form-control">
														<option value="0">Escolha a fase de aplicação da ação...</option>
														<c:forEach items= "${fases}" var="fase">
															<option value="${fase.id}"> ${fase.nome} </option>
														</c:forEach>
													</select>	
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">Custo</label>
									    		<div class="col-sm-10 risco-acao-options">
													<input type="text" id="valorAcaoEstrategica" class="form-control" name="planoDeRiscos.analisesDeRiscos[1].analiseAcoesEstrategicas[0].custo" value="">
												</div>
											</div>							
						  				</div>
									</div>
									<button type="button" class="btn add-acao" id="btnGravar"> Adcionar Ação </button>
								</div>
							</div>
						</div>
					</c:if>
					<button type="button" class="btn add-risco" id="btnGravar"> Adicionar risco </button>
				</div>
				<div class="gravar-plano">
				  	<button type="submit" class="btn btn-primary btn-lg center-block add-risco" id="btnGravar" > Gravar </button>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="modal fade" id="riscosModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Riscos</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-primary">Adicionar</button>
      </div>
    </div>
  </div>
</div>

<script>
$(function() {
	
	$(".number").numberMask({beforePoint:5});
	
	$("#btnGravar").click(function(){
    	var projetoId = $("#projetoId").val();
    	if(projetoId > 0 ){
    		$("#formProjeto").submit();
    	}
    });
    
    function addAcao(element) {
		var acaoSize = $(element).parent().find(".acao").size() + 1;
		
		var riscoSize = $(element).parent().find(".acao").attr("risco")+1;
		
		$(element).parent().find(".acoes").append('<h4>Ação '+acaoSize+'</h4>'+
												 '<div risco="'+riscoSize+'" class="acao" acaoSize="'+acaoSize+'">'+ 
												 '<div class="remove-acao"> <button type="button" class="btn delete-acao" title="Remover"><i class="fa fa-trash"></i></button></div>'+
												 '<div class="form-group"> <label class="col-sm-2 control-label">Ação de Resposta</label>'+
													'<div class="col-sm-10 risco-acao-options">'+ 
														'<input type="text" class="form-control" name="planoDeRisco.analisesDeRiscos[].analiseAcoesEstrategicas[].estrategia.descricao" value="Promover treinamento da equipe sobre gerenciamento de projetos">'+
													'</div>'+
												'</div>'+
											
												'<div class="form-group"> <label class="col-sm-2 control-label">Fase de Realização</label> <div class="col-sm-10 risco-acao-options">'+
											    	'<select id="faseId" name="planoDeRisco.analisesDeRiscos[].analiseAcoesEstrategicas[].faseDeRealizacao.id"" class="required form-control">'+
														'<option value="0">Escolha a fase de aplicação da ação...</option> <c:forEach items= "${fases}" var="fase"><option value="${fase.id}"> ${fase.nome} </option></c:forEach>'+
													'</select>'+	
												'</div></div>'+
												
												'<div class="form-group"> <label class="col-sm-2 control-label">Custo</label> <div class="col-sm-10 risco-acao-options">'+
													'<input type="text" id="valorAcaoEstrategica" class="form-control" name="planoDeRisco.analisesDeRiscos[].analiseAcoesEstrategicas[].custo" value="">'+
												'</div> </div>'+
												'</div>');
												
	
	
		link = $(".acoes").find("a");
		var links = $(".acoes").find("a");
		
		$(links).each(function (i, link) {
						var texto = $(link).parent().text();
						var parent = $(link).parent();
						$(link).remove();
						$(parent).text(texto);
		});
		$(".acoes").collapse({});
		
		$(".add-acao").parent().find(".acao").eq(acaoSize-1).find(".delete-acao").click(function(){
			deleteAcao(this);
		});
		
	}
	
	function addRisco(element) {
		var riscoSize = $(element).parent().find(".more-risco").find(".riscos-content").size()+1;
		
		
		$(element).parent().find(".more-risco").find(".riscos-content").parent().append('<h4>Risco '+riscoSize+'</h4>'+
												 	'<div class="riscos-content" riscoSize="'+riscoSize+'">'+
												  	'	<div class="remove-risco"> <button type="button" class="btn delete-risco " title="Remover"> <i class="fa fa-trash"></i> </button></div>'+
													'	<div class="form-group risco-title" > <label class="col-sm-2 control-label">Descrição</label>'+
								    				'		<div class="col-sm-10"> <input type="text" class="form-control required" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].risco.descricao" ></div>'+
						  							'	</div>'+
						  							'	<div class="form-group"> <label class="col-sm-2 control-label">Tipo do Risco</label>'+
						  							'		<div class="col-sm-10">'+
						  							'			<input type="radio" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].tipo" value="P"> Positivo <input type="radio" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].tipo" value="N"> Negativo'+
													'		</div>'+
													'	</div>'+
								
													'	<div class="form-group risco-options"> <label for="probabilidade" class="col-sm-2 control-label" >Probabilidade</label>'+
													'		<div class="col-sm-10">'+
													'			<select id="probabilidade" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].probabilidade" class="required form-control risco-options-select">'+
													'				<option value="A">Alta</option><option value="M">Média</option><option value="B">Baixa</option>'+
													'			</select>'+
													'		</div>'+
													'	</div>'+
													'	<div class="form-group risco-options"><label for="impacto" class="col-sm-2 control-label">Impacto</label>'+
													'		<div class="col-sm-10">'+
													'			<select id="impacto" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].impacto" class="required form-control risco-options-select">'+
													'				<option value="A">Alto</option> <option value="M">Médio</option> <option value="B">Baixo</option>'+
													'			</select>'+
													'		</div>'+
													'	</div>'+
													'	<div class="form-group risco-options"> <label for="prioridade" class="col-sm-2 control-label">Prioridade</label>'+
													'		<div class="col-sm-10">'+
													'			<select id="prioridade" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].prioridade" class="required form-control risco-options-select">'+
													'				<option value="A">Alta</option><option value="M">Média</option><option value="B">Baixa</option>'+
													'			</select>'+
													'		</div>'+
													'	</div>'+
													'	<div class="form-group risco-options"> <label for="resposta" class="col-sm-2 control-label">Tipo de Resposta</label>'+
													'		<div class="col-sm-10">'+
													'			<select id="resposta" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].resposta" class="required form-control risco-options-select">'+
													'				<option value="E">Evitar</option> <option value="T">Transferir</option> <option value="M">Mistigar</option> <option value="C">Contingenciar</option>'+
													'			</select>'+
													'		</div>'+
													'	</div>'+
													'	<div class="risco-acoes" >'+
													'		<div class="riscos-box-title"> <span>Ações de resposta ao risco</span></div>'+
													'		<div data-collapse="accordion persist" class="acoes"><h4>Ação 1</h4>'+
							  						'			<div risco="'+riscoSize+'" class="acao" acaoSize="1">'+
							  						'				<div class="remove-acao"> <button type="button" class="btn delete-acao" title="Remover"><i class="fa fa-trash"></i></button></div>'+
													'				<div class="form-group"><label class="col-sm-2 control-label">Ação de Resposta</label>'+
									    			'					<div class="col-sm-10 risco-acao-options">'+
													'						<input type="text" class="form-control" name="planoDeRiscos.analisesDeRiscos['+riscoSize+'].analiseAcoesEstrategicas[].estrategia.id" value="Promover treinamento da equipe sobre gerenciamento de projetos">'+
													'					</div>'+
													'				</div>'+
													'				<div class="form-group"> <label class="col-sm-2 control-label">Fase de Realização</label>'+
									    			'					<div class="col-sm-10 risco-acao-options">'+
											    	'						<select id="faseId" name="planoDeRisco.analisesDeRiscos['+riscoSize+'].analiseAcoesEstrategicas[].faseDeRealizacao.id"" class="required form-control">'+
													'							<option value="0">Escolha a fase de aplicação da ação...</option>'+
													'								<c:forEach items= "${fases}" var="fase"><option value="${fase.id}"> ${fase.nome} </option></c:forEach>'+
													'						</select>'+	
													'					</div>'+
													'				</div>'+
													'				<div class="form-group"> <label class="col-sm-2 control-label">Custo</label>'+
													'					<div class="col-sm-10 risco-acao-options">'+
													'						<input type="text" id="valorAcaoEstrategica" class="form-control" name="planoDeRisco.analisesDeRiscos['+riscoSize+'].analiseAcoesEstrategicas[].custo" value="">'+
													'					</div>'+
													'				</div>'+							
						  							'			</div>'+
													'		</div>'+
													'		<button type="button" class="btn add-acao" id="btnGravar"> Adcionar Ação </button>'+
													'	</div>'+
													'</div>');
												
		var linksRiscos = $(".add-risco").parent().find(".more-risco").find("a:contains(Risco)");
		
		$(linksRiscos).each(function (i, linkRisco) {
						var texto = $(linkRisco).parent().text();
						var parent = $(linkRisco).parent();
						$(linkRisco).remove();
						$(parent).text(texto);
		});
		
		$(".more-risco").collapse({});
		
		$(".add-risco").parent().find(".more-risco").find(".riscos-content").eq(riscoSize-1).find(".risco-acoes").find(".acoes").collapse({});
		$(".add-acao").off("click");
        $(".add-acao").click(function(){
			addAcao(this);
		});
		
		$(element).parent().find(".more-risco").find(".riscos-content").eq(riscoSize-1).find(".delete-risco").click(function(){
			deleteRisco(this);
		});
		
		$(".add-risco").parent().find(".more-risco").find(".riscos-content").eq(riscoSize-1).find(".risco-acoes").find(".delete-acao").click(function(){
			deleteAcao(this);
		});
	}
	
	function deleteRisco(element) {
		if($(".delete-risco").parent().parent().size() > 1){
			var riscoIndice = "Risco " + $(element).parent().parent().attr("riscoSize");
			$(element).parent().parent().parent().find("h4:contains("+riscoIndice+")").remove();
			$(element).parent().parent().remove();
			
			var riscos = $(".delete-risco").parent().parent().parent().find("a:contains(Risco)");
			$(riscos).each(function (i, r) {
				var indice = i + 1;
				$(r).text("Risco " + indice);
			});
			
			var divsRiscos = $(".add-risco").parent().find(".more-risco").find(".riscos-content");
				$(divsRiscos).each(function (d, div) {
				var riscoSize = d + 1;
				$(div).attr({"riscoSize" : riscoSize});
				var divAcoes = $(div).find(".acoes").find(".acao");
				
				$(divAcoes).each(function (a, divAcao) {
					$(divAcao).attr({"risco" : riscoSize});
				});
			});
			
		}
	}
	
	function deleteAcao(element) {
		if($(".delete-acao").parent().parent().size() > 1){
			var acao = "Ação " + $(element).parent().parent().attr("acaoSize");
			$(element).parent().parent().parent().find("h4:contains("+acao+")").remove();
			$(element).parent().parent().remove();
			
			var riscos = $(".delete-acao").parent().parent().parent().find("a:contains(Ação)");
			$(riscos).each(function (i, a) {
				var indice = i + 1;
				$(a).text("Ação " + indice);
			});
			
			var divsAcoes = $(".add-acao").parent().find(".acao"); 
				$(divsAcoes).each(function (d, div) {
				var acaoSize = d + 1;
				$(div).attr({"acaoSize" : acaoSize});
			});
		}
	}
	
	$(".add-acao").click(function(){
			addAcao(this);
	});

	$(".add-risco").click(function(){
			addRisco(this);
	});
	
	$(".delete-acao").click(function(){
			deleteAcao(this);
	});

	$(".delete-risco").click(function(){
			deleteRisco(this);
	});
});
</script>