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

				<div class="selectProjeto">
			    	<select id="projetoId" name="planoDeRiscos.projeto.id" class="required form-control">
						<option value="0">Escolha um Projeto...</option>
						<c:forEach items= "${projetos}" var="projeto">
							<option value="${projeto.id}"> ${projeto.nome} </option>
						</c:forEach>
					</select>	
				</div>
				<div style="border: 1px solid #ddd;margin-top: 30px;margin-bottom: 30px">
				
					<div style="padding: 8px;background:darkcyan;color: white;text-align: center;font-size: 15px;">
									<span>Riscos</span>
					</div>
				
				<div   data-collapse="accordion persist">
					  <h4>Risco 1</h4>
					<div id="riscos" style="border-top: 1px solid #ddd; border-bottom: 1px solid #ddd; margin-top: 10px">
					<div class="more-questions-actions" style= "float: right;">
		  			 	<button type="button" class="btn remove-more-question" title="Remover"><i class="fa fa-trash"></i></button>
		  			</div>
						<div class="form-group" style="margin-top: 10px; width: 97%;">
							<label class="col-sm-2 control-label">Descrição</label>
						    <div class="col-sm-10">
								<input type="text" class="form-control required" name="planoDeRiscos.analisesDeRiscos[].risco.descricao" >
						    </div>
				  		</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Tipo do Risco</label>
						    <div class="col-sm-10">
								<input type="radio" name="planoDeRisco.analisesDeRiscos[].tipo" value="P"> Positivo 
								<input type="radio" name="planoDeRisco.analisesDeRiscos[].tipo" value="N"> Negativo
							</div>
						</div>
						
						<div class="form-group" style="margin-left: -30px !important">
							<label for="probabilidade" class="col-sm-2 control-label" style="font-weight: normal;">Probabilidade</label>
							<div class="col-sm-10">
								<select id="probabilidade" name="planoDeRisco.analisesDeRiscos[].probabilidade" class="required form-control" style="width: 138px;">
									<option value="A">Alta</option>
									<option value="M">Média</option>
									<option value="B">Baixa</option>
								</select>
							</div>
						</div>
						<div class="form-group" style="margin-left: -30px !important">
							<label for="impacto" class="col-sm-2 control-label" style="font-weight: normal;">Impacto</label>
							<div class="col-sm-10">
								<select id="impacto" name="planoDeRisco.analisesDeRiscos[].impacto" class="required form-control" style="width: 138px;">
									<option value="A">Alto</option>
									<option value="M">Médio</option>
									<option value="B">Baixo</option>
								</select>
							</div>
						</div>
						<div class="form-group" style="margin-left: -30px !important">
							<label for="prioridade" class="col-sm-2 control-label" style="font-weight: normal;">Prioridade</label>
							<div class="col-sm-10">
								<select id="prioridade" name=".prioridade" class="required form-control" style="width: 138px;">
									<option value="A">Alta</option>
									<option value="M">Média</option>
									<option value="B">Baixa</option>
								</select>
							</div>
						</div>
						<div class="form-group" style="margin-left: -30px !important">
							<label for="resposta" class="col-sm-2 control-label" style="font-weight: normal;">Tipo de Resposta</label>
							<div class="col-sm-10">
								<select id="resposta" name="planoDeRisco.analisesDeRiscos[].resposta" class="required form-control" style="width: 138px;"
										<option value="E">Evitar</option>
										<option value="T">Transferir</option>
										<option value="M">Mistigar</option>
										<option value="C">Contingenciar</option>
								</select>
							</div>
						</div>
						<div style="margin-left: 187px !important;height: auto; border: 1px solid darkcyan; margin-bottom: 10px; width: 78%;">
							<div style="padding: 8px;background:darkcyan;color: white;text-align: center;font-size: 15px;">
								<span>Ações de resposta ao risco</span>
							</div>
							<div data-collapse="accordion persist">
						  		<h4>Ação 1</h4>
					  			<div >
					  				<div class="more-questions-actions" style= "float: right;">
		  			 					<button type="button" class="btn" title="Remover"><i class="fa fa-trash"></i></button>
		  							</div>
		  							
									<div class="form-group" style="margin-top: 10px">
										<label class="col-sm-2 control-label">Ação de Resposta</label>
							    		<div class="col-sm-10" style="width: 70%;">
											<input type="text" class="form-control" name="planoDeRisco.analisesDeRiscos[].analiseAcoesEstrategicas[].id" value="Promover treinamento da equipe sobre gerenciamento de projetos">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 control-label">Fase de Realização</label>
							    		<div class="col-sm-10"  style="width: 70%;">
									    	<select id="faseId" name="planoDeRisco.analisesDeRiscos[].analiseAcoesEstrategicas[].id"" class="required form-control">
												<option value="0">Escolha a fase de aplicação da ação...</option>
												<c:forEach items= "${fases}" var="fase">
													<option value="${fase.id}"> ${fase.nome} </option>
												</c:forEach>
											</select>	
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Custo</label>
							    		<div class="col-sm-10"  style="width: 70%;">
											<input type="text" id="valorAcaoEstrategica" class="form-control" name="planoDeRisco.analisesDeRiscos[].analiseAcoesEstrategicas[].id" value="">
										</div>
									</div>							
					  			</div>
							</div>
							<button type="button" class="btn" id="btnGravar" style="margin-top: 5px; margin-bottom: 10px; margin-left: 10px" > Cadastrar novas ações </button>
						</div>
					</div>
				</div>
					<button type="button" class="btn" data-toggle="modal" data-target="#riscosModal" style="margin-top: 20px; margin-bottom: 10px">Adicionar Riscos já cadastrados</button>
					<button type="button" class="btn" id="btnGravar" style="margin-top: 20px; margin-bottom: 10px" > Cadastrar novos riscos </button>
				</div>
			  	<div style="margin-left: 30px">
				  	<button type="submit" class="btn btn-primary btn-lg center-block" id="btnGravar" > Gravar </button>
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

<style>
.dropdown-toggle{
	padding-bottom: 0px;
}
}
</style>
<script>
$(function() {
	$("#valorAcaoEstrategica").maskMoney({showSymbol:true, symbol:"R$", decimal:",", thousands:"."});
	
	$(".number").numberMask({beforePoint:5});
	
	$("#btnGravar").click(function(){
    	var projetoId = $("#projetoId").val();
    	if(projetoId > 0 ){
    		$("#formProjeto").submit();
    	}
    });
	
});
</script>