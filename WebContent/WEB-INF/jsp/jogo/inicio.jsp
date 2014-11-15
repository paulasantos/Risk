<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<jsp:include page="../index/header.jsp" />


<div id="menu-principal">
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9"></button>
		  		<a class="navbar-brand" href="/risk/jogo">RISK</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
			    	<li class="active"><a href="/risk/jogo"><i class="fa fa-home fa-fw" style="padding-right: 5px;"></i>Selecionar Projeto</a></li>
		       		<li><a href="#">Pontuação</a></li>			
		       		<li><a href="#">Sobre</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div id="content" class="content">
	<div class="fotoSobre">
		<img class="foto" src="<c:url value='/imagens/prof.png'/>" width="430" height="203" />
	</div>

<div class="selectProjet">
	<div id="projeto">
		<h3>Escolha um projeto para iniciar o jogo</h3>
		<div class="selectProjeto">
	    	<form id="formProjeto" action="<c:url value="/jogo/jogar"/>" method="post" >
		    	<select id="projetoId" name="projeto.id" class="required form-control">
					<option value="0">Escolha um Projeto...</option>
					<c:forEach items= "${projetos}" var="projeto">
						<option value="${projeto.id}"> ${projeto.nome} </option>
					</c:forEach>
				</select>	
				
				<div>
					<button type="button" class="btn" id="btnGravar" style="margin-top: 10px; background-color: beige" >Jogar</button>
				</div>
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