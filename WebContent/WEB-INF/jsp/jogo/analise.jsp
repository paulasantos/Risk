<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />

<jsp:include page="../index/menu.jsp" />
<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<div>
	<div class="form-group">
		<label for="tipo" class="col-sm-2 control-label">Tipo do Risco</label>
		<div class="col-sm-10">
			<input type="radio" name="tipo" value="P"> Positivo 
			<input type="radio" name="tipo" value="N"> Negativo
		</div>
	</div>
	<div class="form-group">
		<label for="prioridade" class="col-sm-2 control-label">Prioridade</label>
		<div class="col-sm-10">
			<select id="prioridade" name="prioridade" class="required">
				<option value="A">Alto</option>
				<option value="M">Médio</option>
				<option value="B">Baixo</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="impacto" class="col-sm-2 control-label">Impacto</label>
		<div class="col-sm-10">
			<select id="impacto" name="impacto" class="required">
				<option value="A">Alto</option>
				<option value="M">Médio</option>
				<option value="B">Baixo</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="probabilidade" class="col-sm-2 control-label">Probabilidade</label>
		<div class="col-sm-10">
			<select id="probabilidade" name="probabilidade" class="required">
				<option value="A">Alto</option>
				<option value="M">Médio</option>
				<option value="B">Baixo</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="resposta" class="col-sm-2 control-label">Tipo de Resposta</label>
		<div>
			<select id="resposta" name="resposta" class="required">
					<option value="E">Evitar</option>
					<option value="T">Transferir</option>
					<option value="M">Mistigar</option>
					<option value="C">Contingenciar</option>
			</select>
		</div>
	</div>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Ação</th>
					<th>Ação de Resposta</th>
					<th>Responsáveis</th>
					<th>Fase de Realização</th>
					<th>Custo</th>
				</tr>
			</thead>
			<tbody class="content">
				<c:forEach items="${acoesResposta}" var="acaoResposta">
					<tr>
						<td><input type="checkbox" name="acoes" value="A"></td>
						<td>Promover treinamento da equipe sobre gerenciamento de projetos</td>
						<td>Gerente do projeto</td>
						<td>Elaboração</td>
						<td>R$ 4.100,00 (instrutor interno)</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>