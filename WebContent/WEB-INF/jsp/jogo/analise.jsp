<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />

<jsp:include page="../index/menu.jsp" />
<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>


<div class="content">
	<div class="vertical-menu nav-collapse navbar-left navbar" id="riscosAnalisados" style="width: 220px;height: auto !important;min-height: 100%;border-color: black; border: 1px solid #ddd">
		    <ul class="nav">
		        <li class="title">Riscos</li>
		    	<c:forEach items="${riscosSelecionados}" var="riscoSelecionado" varStatus="countRiscos">
			       <li><a href='<c:url value="/jogo/risco/${riscoSelecionado.id}"/>'>${countRiscos} - Risco</a></li>
		    	</c:forEach>
		    	<li><a href='<c:url value="/jogo/risco/finalizar"/>'>Concluir Plano de Riscos</a></li>
		    </ul>
	</div>
	
	<div class="controls" style= "background-color: whitesmoke;  border-color: black; border: 1px solid #ddd; height: auto !important;min-height: 100%;">
		<div class="form-horizontal" style="display: table; margin-left: 0 !important; padding-left: 0 !important">
		<div class="form-group" style="margin-left: -30px !important">
			<label for="tipo" class="col-sm-2 control-label"style="font-weight: normal;">Tipo do Risco</label>
			<div class="col-sm-10">
				<input type="radio" name="tipo" value="P"> Positivo 
				<input type="radio" name="tipo" value="N"> Negativo
			</div>
		</div>
		<div class="form-group" style="margin-left: -30px !important">
			<label for="probabilidade" class="col-sm-2 control-label" style="font-weight: normal;">Probabilidade</label>
			<div class="col-sm-10">
				<select id="probabilidade" name="probabilidade" class="required form-control" style="width: 138px;">
					<option value="A">Alta</option>
					<option value="M">Média</option>
					<option value="B">Baixa</option>
				</select>
			</div>
		</div>
		<div class="form-group" style="margin-left: -30px !important">
			<label for="impacto" class="col-sm-2 control-label" style="font-weight: normal;">Impacto</label>
			<div class="col-sm-10">
				<select id="impacto" name="impacto" class="required form-control" style="width: 138px;">
					<option value="A">Alto</option>
					<option value="M">Médio</option>
					<option value="B">Baixo</option>
				</select>
			</div>
		</div>
		<div class="form-group" style="margin-left: -30px !important">
			<label for="prioridade" class="col-sm-2 control-label" style="font-weight: normal;">Prioridade</label>
			<div class="col-sm-10">
				<select id="prioridade" name="prioridade" class="required form-control" style="width: 138px;">
					<option value="A">Alta</option>
					<option value="M">Média</option>
					<option value="B">Baixa</option>
				</select>
			</div>
		</div>
		<div class="form-group" style="margin-left: -30px !important">
			<label for="resposta" class="col-sm-2 control-label" style="font-weight: normal;">Tipo de Resposta</label>
			<div class="col-sm-10">
				<select id="resposta" name="resposta" class="required form-control" style="width: 138px;"
						<option value="E">Evitar</option>
						<option value="T">Transferir</option>
						<option value="M">Mistigar</option>
						<option value="C">Contingenciar</option>
				</select>
			</div>
		</div>
		<div class="form-group table-responsive" style="margin-left: -30px !important">
			<label for="acaoResposta" class="col-sm-2 control-label" style="font-weight: normal;">Ação de Resposta</label>
			<div class="col-sm-10" style="padding-right: 50px !important;">
				<table class="table table-bordered" style="font-size: 14px; text-align: center;">
					<thead>
						<tr>
							<th style="font-weight: normal; text-align: center;">Usar</th>
							<th style="font-weight: normal; text-align: center;">Ação de Resposta</th>
							<th style="font-weight: normal; text-align: center;">Responsáveis</th>
							<th style="font-weight: normal; text-align: center;" width=20%;>Fase de Realização</th>
							<th style="font-weight: normal; text-align: center;" width=20%;>Custo</th>
						</tr>
					</thead>
					<tbody class="content">
					<%--<c:forEach items="${acoesResposta}" var="acaoResposta">--%>
							<tr>
								<td><input type="checkbox" name="acoes" value="A"></td>
								<td>Promover treinamento da equipe sobre gerenciamento de projetos</td>
								<td>Gerente do projeto</td>
								<td>Elaboração</td>
								<td>R$ 4.100,00 (instrutor interno)</td>
							</tr>
					<%--</c:forEach> --%>
					</tbody>
				</table>
			</div>
			</div>
		</div>
		
	</div>	
</div>

<script type="text/javascript">
  
    $("#btnContinuarJogo").click(function(){
   		$("#riscosForm").submit();
    });
    
    (function($){
        $(window).load(function(){
            $(".riscosAnalisados").mCustomScrollbar({
				mouseWheel: false,
				theme: "dark",
				set_height:"85%",
			});
        });
    })(jQuery);
</script>
