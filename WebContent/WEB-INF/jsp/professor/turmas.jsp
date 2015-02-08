<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<jsp:include page="../index/header.jsp" />
<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>
<script type="text/javascript" language="javascript" src="/risk/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="/risk/js/dataTables.bootstrap.js"></script>

<div class="content">
	<form id="formDelete" method="post" action="<c:url value='/professores/turma/delete/?'/>">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
	<div class="box-big">
		<div id="form-action" >
			<a class="list-group-item" id="novaTurma" href="<c:url value='/professores/turma/new'/>"
			style="color: rgb(12, 234, 32);font-size: 15px;background: seagreen;"> <i class="fa fa-plus-circle fa-fw"> </i>&nbsp; Nova Turma</a>
		</div>
		<div class="box-content">
			<div style="padding-top: 10px; margin-bottom: 50;">
				<table id="tableTurma" class="table-striped table table-bordered" style="margin: 0 auto;">
					<thead>
						<tr>
							<th  width=9% class="acoes" style="color: #676a6c;">Ações</th>
						    <th style="color: #676a6c;"> Turma</th>
							<th style="color: #676a6c;">Projeto</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${turmas}" var="turma">
							<tr turmaid="${turma.id}">
								<td id="acoes" class="center">	
									<div>
										<a class="btn-editar" onclick="remover(${turma.id})" style="color: #676a6c;">
											<i class="fa fa-trash-o" title="Remover" style="font-size: 19px; margin-left: -2px;"></i>
										</a>
										<a  href="<c:url value='/professores/turma/${turma.id}/edit'/>" style="vertical-align: middle; color: #676a6c;">
											<i class="fa fa-pencil-square-o" title="Editar" style="font-size: 19px;margin-left: -2px"></i>
										</a>
										<a  href="<c:url value='/professores/turma/${turma.id}/edit'/>" style="vertical-align: middle; color: #676a6c;">
											<i class="fa fa-graduation-cap" title="Adcionar Alunos" style="font-size: 19px;margin-left: -2px"></i>
										</a>
									</div>
								</td>
			
								<td style="color: #676a6c;"> ${turma.nome} </a> </td>
								<td style="color: #676a6c;"> ${turma.projeto.nome}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

<script>
function remover(id){
	var $form = $("#formDelete"); 	
	var novaActionDelete = $form.attr("action").replace("/?", "/"+id);
	$form.attr("action", novaActionDelete);	  
	$form.submit(); 		
};

$(document).ready(function() {
    $('#tableTurma').dataTable({
        "pagingType": "full_numbers",
        "lengthChange": false,
        "stripeClasses": [ 'odd', 'even'],
        "language": {
			"info":           "Mostrando _START_ de _END_ do total de _TOTAL_ turmas",
			"search":         "Pesquisar:",
			"zeroRecords":    "Turma não encotrada",
			"paginate": {	
							"first":      "|&lt;",
				        	"last":       ">&gt;|",
				        	"next":       ">>",
				        	"previous":   "<<"
			}	
		},
		"sort":false
    });
}); 
</script>
<style>
.dataTables_filter{
	margin-right: 0px;
	margin-left: 195px;
}
.dataTables_paginate{
	margin-right: 0px;
	margin-left: 188px;
}
</style>
</div>