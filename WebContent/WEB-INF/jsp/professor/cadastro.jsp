<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />
<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<div class="content">
	<form id="formDelete" method="post" action="<c:url value='/professores/projeto/delete/?'/>">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
	<div id="form-action" >
		<a class="list-group-item" id="novoprojeto" href="<c:url value='/professores/projeto/new'/>"
		style="color: rgb(12, 234, 32);font-size: 15px;background: seagreen;"> <i class="fa fa-plus-circle fa-fw"> </i>&nbsp; Novo Projeto</a>
	</div>
	<div style="padding-top: 10px; margin-bottom: 50;">
		<table class="table table-bordered" style="width: 98%; margin: 0 auto;">
			<thead>
				<tr>
					<th  width=9% class="acoes">Ações</th>
				    <th> Projeto</th>
					<th>Orçamento</th>
					<th>Cronograma</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projetos}" var="projeto">
					<tr projetoid="${projeto.id}">
						<td id="acoes" class="center">	
							<div>
								<a class="btn-editar" onclick="remover(${projeto.id})">
									<i class="fa fa-trash-o" title="Remover" style="font-size: 19px; margin-left: -2px;"></i>
								</a>
								<a  href="<c:url value='/professores/projeto/${projeto.id}/edit'/>" style="vertical-align: middle;">
									<i class="fa fa-pencil-square-o" title="Editar" style="font-size: 19px;margin-left: -2px"></i>
								</a>
			  					<a  href="<c:url value='/professores/projeto/new'/>">
									<i class="fa fa-file-text" title="Plano de Risco" style="font-size: 16px;margin-left: -2px""></i>
								</a> 
							</div>
						</td>
	
						<td class="center"> <a href="<c:url value='/professores/${projeto.id}/show'/>"> ${projeto.nome} </a> </td>
						<td class="center"> ${projeto.orcamento}</td>
						<td class="center"> ${projeto.cronograma}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script>
function remover(id){
	var $form = $("#formDelete"); 	
	var novaActionDelete = $form.attr("action").replace("/?", "/"+id);
	$form.attr("action", novaActionDelete);	  
	$form.submit();		
 };
</script>
</div>