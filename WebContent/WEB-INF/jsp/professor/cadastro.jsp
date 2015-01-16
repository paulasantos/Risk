<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />
<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<form id="formDelete" action="<c:url value="/professores/projeto/delete/?"/>" method="DELETE"
	<input type="hidden" name="_method" value="DELETE" />
</form>
<div class="content">
	<div id="form-action" >
		<a class="list-group-item" id="novoprojeto" href="<c:url value='/professores/projeto/new'/>"
		style="color: rgb(12, 234, 32);font-size: 15px;background: seagreen;"> <i class="fa fa-plus-circle fa-fw"> </i>&nbsp; Novo Projeto</a>
	</div>
	<div style="padding-top: 10px; margin-bottom: 50;">
		<table class="table table-bordered" style="width: 98%; margin: 0 auto;">
			<thead>
				<tr>
					<th  width=10% class="acoes">Ações</th>
				    <th> Projeto</th>
					<th>Orçamento</th>
					<th>Cronograma</th>
				</tr>
			</thead>
			<tbody class="content">
				<c:forEach items="${projetos}" var="projeto">
					<tr projetoid="${projeto.id}">
						<td id="acoes" class="center">	
		  					<a  href="<c:url value='/professores/projeto/new'/>">
								<i class="fa fa-file-text" title="Plano de Risco"></i>
							</a> 
							<a  href="<c:url value='/professores/projeto/${projeto.id}/edit'/>" style="margin: 0 4px 0px 4px;font-size: 19px;">
								<i class="fa fa-pencil-square-o" title="Editar"></i>
							</a>
							<a class="btnEditar" onclick="removerProjeto()">
								<i class="fa fa-trash-o" title="Remover"></i>
							</a>
							<form id="formDelete" action="<c:url value="/professores/projeto/delete/${projeto.id}"/>" method="POST"
								style="width: auto; float: right; height: auto; margin-top: -3px; margin-bottom: 0px;">
								<button type="submit" name="_method" value="DELETE" class="btn-link"><i class="fa fa-trash-o" title="Remover"></i></button>
		  					</form>
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
$(function() {
	function removerProjeto() {
	console.log("oi");
		var $form = $("formDelete"); 	
		$form = $("#formDeleteUsuario");
			var novaActionDelete = $form.attr("action").replace("/?", "/"+ id);
			$form.attr("action", novaActionDelete);	  
			$form.submit();		
  	};
});	
</script>
</div>