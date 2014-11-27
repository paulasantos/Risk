<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />
<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>


<div class="content">
	<div id="form-action" style="margin-left: 50%; margin-top: 20px; margin-bottom: 20px;">
		<a class='btn btn-primary' href="<c:url value='/professores/projeto/new'/>" id="novoprojeto">Novo Projeto</a>
	</div>
	<div>
		<table class="table table-bordered" style="width: 70% ; margin-left: 15%;">
			<thead>
				<tr>
					<th  width=5% class="acoes">Ações</th>
				    <th width=25%>Projeto</th>
					<th width=20%>Resumo</th>
					<th width=15%>Orçamento</th>
					<th width=10%>Cronograma</th>
					<th width=25%>Quantidade de Membros</th>
				</tr>
			</thead>
			<tbody class="content">
				<c:forEach items="${projetos}" var="projeto">
					<tr projetoid="${projeto.id}">
						<td id="acoes" class="center">	
							<a  href="<c:url value='/professores/projeto/${projeto.id}/edit'/>" style="float: left;">
								<i class="fa fa-pencil-square-o" title="Editar"></i>
							</a>
							<form id="formDelete" action="<c:url value="/professores/projeto/delete/${projeto.id}"/>" method="POST"
								style="width: auto; float: right; height: auto; margin-top: -3px;">
								<button type="submit" name="_method" value="DELETE" class="btn-link"><i class="fa fa-trash-o" title="Remover"></i></button>
		  					</form>
						</td>
	
						<td class="center"> <a href="<c:url value='/professores/${projeto.id}/show'/>"> ${projeto.nome} </a> </td>
						<td class="center">
							${projeto.resumo}
						</td>
						<td class="center"> ${projeto.orcamento}</td>
						<td class="center"> ${projeto.cronograma}</td>
						<td class="center"> ${projeto.qtdMembros}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
