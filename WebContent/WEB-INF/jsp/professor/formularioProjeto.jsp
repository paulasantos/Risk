<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />
<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<div class="content">
	<form id="projetoForm" class="account-form form-horizontal" action="<c:url value="/professores/projeto/save"/>" method="POST">
		<div>
			<span>Cadastrar Projeto</span>
		</div>

		<div class="form-group">
		    <label for="projetoName" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control required" id="projetoName" name="projeto.nome" value="" >
		    </div>
	  	</div>
 					
		<div class="form-group">
		    <label for="projetoResumo" class="col-sm-2 control-label">Resumo</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control required" id="projetoResumo" name="projeto.resumo" >
		    </div>
	  	</div>
		<div class="form-group">
		    <label for="projetoOrcamento" class="col-sm-2 control-label">Orçamento do projeto (R$)</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control required" id="projetoOrcamento" name="projeto.orcamento" >
		    </div>
	  	</div>
		<div class="form-group">
		    <label for="projetoCronograma" class="col-sm-2 control-label">Duração do Projeto (Dias)</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control required" id="projetoCronograma" name="projeto.cronograma" >
		    </div>
	  	</div>
		<div class="form-group">
		    <label for="projetoQtdMembros" class="col-sm-2 control-label">Quantidades de membros da equipe</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control required" id="projetoQtdMembros" name="projeto.qtdMembros" >
		    </div>
	  	</div>

	  	
	</form>
</div>