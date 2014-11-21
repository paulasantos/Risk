<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />
<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>


<div class="content">
	<div id="form-action" style="margin-left: 50%; margin-top: 20px; margin-bottom: 20px;">
		<a class='btn btn-primary btn-lg' href="<c:url value='/professores/plano/new'/>" id="novoPlano">Novo Plano</a>
	</div>
	
	<div>
		<table class="table table-bordered" style="width: 70% ; margin-left: 15%;">
			<thead>
				<tr>
					<th width=5% class="acoes">Ações</th>
				    <th>Projeto</th>
				</tr>
			</thead>
			<tbody class="content">
				<c:forEach items="${projetos}" var="projeto">
					<tr projetoid="${projeto.id}">
						<td id="acoes" class="center">	
							<a  href="<c:url value='/professores/projeto/${projeto.id}/edit'/>">
								<i class="fa fa-pencil-square-o" title="Editar"></i>
							</a>
							<a onclick="intranet.formulario.formDelete(${projeto.id});">
								<i class="fa fa-trash-o" title="Remover"></i>
							</a>
						</td>
	
						<td class="center">${planoDeRisco.projeto.nome} </a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>