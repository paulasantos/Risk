<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<jsp:include page="../index/header.jsp" />
<jsp:include page="../index/menu.jsp" />

	<div style="float: right; border: 1px solid #ddd; margin-top: 9%; margin-right: 4%; background-color: #E08181; border-radius: 4px; width: 15%; height: 240px;">
		<h3> Selecionar Riscos </h3>
		<div class="controll-group">
			
<!-- 			<i class="fa fa-exclamation-triangle" style="color: yellow;font-size: 65px;"></i> -->
			<button id="btnRiscos" class="btn btn-primary" style="margin-left: 10px;">Riscos</button>
		</div>
		
		<div class="controll-group">
<!-- 			<i class="fa fa-question-circle" style="color: blue;font-size: 65px;" ></i> -->
			<button id="btnAjudaTecnica" class="btn btn-primary" style="margin-top:10px; margin-left: 10px;">Ajuda Técnica</button>
		</div>
				
	</div>
<div id="content" class="content" style="width: 60%; text-align: justify;">
	<h3>Projeto: ${projeto.nome}</h3>
	${projeto.descricao}
	</div>
	
<script type="text/javascript">
    $("#btnRiscos").click(function(){
    	var projetoId = $("#projetoId").val();
    	if(projetoId > 0 ){
    		$("#formProjeto").submit();
    	}
    });
    
</script>  
