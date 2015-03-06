<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<jsp:include page="../index/header.jsp" />

<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<div class="content">
	<div class="box-big">
		<div class="box-title">
			<span>Cadastro</span>
		</div>
		<div class="box-content">
			<form id="turmaForm" class="account-form form-horizontal" action="<c:url value="/professores/turma"/>" method="POST">
				<c:if test="${turma.id != null}">
					<input type="hidden" name="turma.id" value="${turma.id}">
                 	<input type='hidden' name='_method' value='PUT'/>
				</c:if>
				
				<div class="form-group">
				    <label for="turmaNome" class="col-sm-2 control-label">Nome</label>
				    <div class="col-sm-10">
			      		<input type="text" class="form-control required" id="turmaNome" name="turma.nome" value="${turma.nome}" >
				    </div>
			  	</div>
				<div class="form-group">
				    <label for="turmaProjeto" class="col-sm-2 control-label">Projeto</label>
				    <div class="col-sm-10">
						<select id="projetoId" name="turma.projeto.id" class="required form-control" >
							<option value="0">Escolha um Projeto...</option>
							<c:forEach items= "${projetos}" var="projeto">
								<option <c:if test="${turma.projeto.id == projeto.id}">selected="selected"</c:if> value="${projeto.id}">${projeto.nome}</option>
								
							</c:forEach>
						</select>	
				    </div>
			  	</div>
			  	<div id="divGravar">
				  	<button type="submit" class="btn btn-primary btn-lg center-block" > Gravar </button>
			  	</div>
			</form>
		</div>
	</div>
</div>