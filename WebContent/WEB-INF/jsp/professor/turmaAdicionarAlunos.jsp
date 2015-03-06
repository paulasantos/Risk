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
			<div class="form-group">
			    <label for="alunoNome" class="col-sm-2 control-label">Nome do Aluno</label>
			    <div class="col-sm-10">
		      		<input type="text" class="form-control required" id="alunoNome" name="alunoNome" value="" >
			   	</div>
			</div>
			<div class="form-group">
			    <label for="curso" class="col-sm-2 control-label">Curso</label>
			    <div class="col-sm-10">
					<select id="curso" name="curso" class="required form-control" >
						<option value="0">Escolha um curso...</option>
							<c:forEach items= "${cursos}" var="curso">
							<option value="${curso.id}">${curso.nome}</option>
						</c:forEach>
					</select>	
			    </div>
			  </div>
		</div>
	</div>
</div>
