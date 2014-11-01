<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<jsp:include page="../index/header.jsp" />
<jsp:include page="../index/menu.jsp" />


<div id="content" class="content">

	<h3>JOGO RISK</h3>
<div class="bs-docs-section">  
    <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
        <li><a href="#sobre" data-toggle="tab">Sobre</a></li>
        <li><a href="#pontuacao" data-toggle="tab">Pontuação</a></li>
        <li class="active"><a href="#jogar" data-toggle="tab">Jogar</a></li>
        
    </ul>
    <div id="my-tab-content" class="tab-content">
        <div class="tab-pane" id="sobre">
            <p>O jogo tem como objetivo ensinar o aluno a identificar, 
            	analisar e mistigar riscos em um projeto de software. 
            	Consequentemente melhorando suas habilidades para tomar decisões em projetos reais. </p>
        </div>
        <div class="tab-pane" id="pontuacao">
            <h3>Sua Pontuação</h3>
            <p>pontos</p>
        </div>
        <div class="tab-pane active" id="jogar">
            <h3>Escolha um projeto para iniciar o jogo</h3>
            <div class="selectProjeto">
            <form id="formProjeto" action="<c:url value="/jogo/jogar"/>" method="post">
	            <select id="projetoId" name="projeto.id" class="required">
					<option value="0">Escolha um Projeto...</option>
					<c:forEach items= "${projetos}" var="projeto">
						<option value="${projeto.id}"> ${projeto.nome} </option>
					</c:forEach>
				</select>	
				<button type="button" class="btn" id="btnGravar">Jogar</button>
            </form>
            </div>
        </div>
    </div>
</div>
 
 
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $('#tabs').tab();
    });
    
    $("#btnGravar").click(function(){
    	var projetoId = $("#projetoId").val();
    	if(projetoId > 0 ){
    		$("#formProjeto").submit();
    	}
    });
    
</script>    
</div> <!-- container -->