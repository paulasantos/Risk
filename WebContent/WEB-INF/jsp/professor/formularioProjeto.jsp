<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />
<!-- <link rel="stylesheet" type="text/css" href="/risk/jwysiwyg/jquery.wysiwyg.css">
<script type="text/javascript" src="/risk/jwysiwyg/js/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="/risk/jwysiwyg/js/jquery.wysiwyg.min.js"></script>
 -->
 
<link href="/risk/editor/summernote.css" rel="stylesheet">
<script src="/risk/editor/summernote.min.js"></script>

<jsp:include page="../professor/menuProfessor.jsp" />
<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<div class="content">
	<div class="box-big">
		<div class="box-title">
			<span>Cadastro</span>
		</div>
		<div class="box-content">
			<form id="projetoForm" class="account-form form-horizontal" action="<c:url value="/professores/projeto"/>" method="POST">
				<c:if test="${projeto.id != null}">
					<input type="hidden" name="projeto.id" value="${projeto.id}">
					<input type="hidden" name="projeto.professor.id" value="${projeto.professor.id}">
                  <input type='hidden' name='_method' value='PUT'/>
				</c:if>
				
				<div class="form-group">
				    <label for="projetoName" class="col-sm-2 control-label">Nome</label>
				    <div class="col-sm-10">
			      		<input type="text" class="form-control required" id="projetoName" name="projeto.nome" value="${projeto.nome}" >
				    </div>
			  	</div>
				<div class="form-group">
				    <label for="projetoResumo" class="col-sm-2 control-label">Resumo</label>
				    <div class="col-sm-10">
						<textarea class="required editorProjeto" name="projeto.resumo">${projeto.resumo}</textarea>
				    </div>
			  	</div>
				<div class="form-group">
				    <label for="projetoOrcamento" class="col-sm-2 control-label">Orçamento do projeto (R$)</label>
				    <div class="col-sm-10">
			    		<input type="text" class="form-control required" id="projetoOrcamento" name="projeto.orcamento" value="${projeto.orcamento}">
				    </div>
			  	</div>
				<div class="form-group">
					<label for="projetoCronograma" class="col-sm-2 control-label">Duração do Projeto (Dias)</label>
			    	<div class="col-sm-10">
				    	<input type="text" class="form-control required number" id="projetoCronograma" name="projeto.cronograma" value="${projeto.cronograma}">
			    	</div>
			  	</div>
				<div class="form-group">
					<label for="projetoQtdMembros" class="col-sm-2 control-label">Quantidades de membros da equipe</label>
					<div class="col-sm-10">
						<input type="text" class="form-control required number" id="projetoQtdMembros" name="projeto.qtdMembros" value="${projeto.qtdMembros}">
					</div>
				</div>
			
				<div class="form-group">
				    <label for="projetoQtdMembros" class="col-sm-2 control-label">Descrição</label>
				    <div class="col-sm-10">
						<textarea class="required editorProjeto" name="projeto.descricao">${projeto.descricao}</textarea>
				    </div>
			  	</div>
			  	<div style="margin-left: 30px">
				  	<button type="submit" class="btn btn-primary btn-lg center-block" > Gravar </button>
			  	</div>
			</form>
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
	$(".editorProjeto").summernote({
		height: 200,                 // set editor height
		
		minHeight: null,             // set minimum height of editor
		maxHeight: null,             // set maximum height of editor
		
		focus: true,                 // set focus to editable area after initializing summernote
		toolbar: [
		    //[groupname, [button list]]
		     
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['fontsize', ['fontsize']],
		    ['para', ['ul', 'ol', 'paragraph']],
		]
	});
	
	$("#projetoOrcamento").maskMoney({showSymbol:true, symbol:"R$", decimal:",", thousands:"."});
	
	$(".number").numberMask({beforePoint:5});
	
});
</script>