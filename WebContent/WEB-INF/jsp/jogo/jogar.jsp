<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<jsp:include page="../index/header.jsp" />
<jsp:include page="../index/menu.jsp" />

<div id="content" class="content" style="text-align: justify;">
	<div class="content">
		<h3>Projeto: ${projeto.nome}</h3>
		${projeto.descricao}
	</div>


		<div class="controll-group">
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#riscos" style="margin-left: 10px;">Iniciar Plano de Riscos</button>
			<button id="btnAjudaTecnica" class="btn btn-primary" style="margin-left: 10px;">Ajuda Técnica</button>
		</div>
	</div>
	
	<div class="modal fade" id="riscos" tabindex="-1" role="dialog" aria-labelledby="titulo" aria-hidden="true">
		<div class="modal-dialog">
			<form id="riscosForm" action="<c:url value="/jogo/riscos"/>" method="post">
				<input type="hidden" name="projeto.id" value="${projeto.id}">
				<div class="modal-content">
				<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Sair</span></button>
				<h4 class="modal-title" id="titulo">Selecione os riscos do projeto</h4>
				</div>
					<div class="modal-body">
						<c:forEach items="${riscos}" var="risco">
							<input type="checkbox"  name="selecionados[].risco.id" value="${risco.id}"> ${risco.descricao} 
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-primary">Continuar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
<script type="text/javascript">
    $("#btnRiscos").click(function(){
    	var projetoId = $("#projetoId").val();
    	if(projetoId > 0 ){
    		$("#formProjeto").submit();
    	}
    });
    
</script>  
