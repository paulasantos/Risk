<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>


<div id="menu-principal">
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9"></button>
		  		<a class="navbar-brand" href="/risk/jogo">RISK</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
		       		<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
			          		<i class="fa fa-home fa-fw" style="padding-right: 5px;"></i>Projetos <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><a href="/risk/professor/meusProjetos">Meus Projetos</a></li>
			            <li><a href="/risk/professor/projetosCompartilhados">Projetos compartilhados</a></li>
			          </ul>
			        </li>
		       		<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Plano de Riscos <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><a href="/risk/professor/meusProjetos">Meus Planos de Riscos</a></li>
			            <li><a href="/risk/professor/projetosCompartilhados">Projetos compartilhados</a></li>
			          </ul>
			        </li>
		       		<li><a href="/risk/professor/resultados">Resultados</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div class="content">
	<div id="form-action" style="top: 160px;">
		<a class='btn btn-primary' href="<c:url value='/risk/professor/projeto/new'/>" id="projetoNew">Novo Projeto</a>
	</div>

	<table class="table table-bordered">
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
			<c:forEach items="${Projetos}" var="projeto">
				<tr projetoid="${projeto.id}">
					<td id="acoes" class="center">	
						<a  href="<c:url value='/${contexto}/cartoes/${projeto.id}/edit'/>">
							<i class="icon-edit"></i>
						</a>
						<a class="link" onclick="intranet.formulario.formDelete(${projeto.id});">
							<i class="icon-trash"></i>
						</a>
					</td>

					<td class="center"> <a href="<c:url value='/${contexto}/cartoes/${projeto.id}/show'/>"> ${projeto.nome} </a> </td>
					<td class="center">
						<c:if test="${projeto.empresa.id != null}">${projeto.resumo}</c:if>
					</td>
					<td class="center"> ${projeto.orcamento}</td>
					<td class="center"> ${projeto.cronograma}</td>
					<td class="center"> ${projeto.qtdMembros}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>