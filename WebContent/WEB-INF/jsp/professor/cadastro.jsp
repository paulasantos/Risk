<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<link rel="stylesheet" type="text/css" href="/risk/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="/risk/css/dialog.css" />

<jsp:include page="../index/header.jsp" />
<jsp:include page="../professor/menuProfessor.jsp" />

<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>
<script type="text/javascript" language="javascript" src="/risk/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="/risk/js/dataTables.bootstrap.js"></script>

<div class="content">
	<form id="formDelete" method="post" action="<c:url value='/professores/projeto/delete/?'/>">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
	<div class="box-big">
		<div id="form-action" >
			<a class="list-group-item" id="novoprojeto" href="<c:url value='/professores/projeto/new'/>"
			style="color: rgb(12, 234, 32);font-size: 15px;background: seagreen;"> <i class="fa fa-plus-circle fa-fw"> </i>&nbsp; Novo Projeto</a>
		</div>
		<div class="box-content">
			<div style="padding-top: 10px; margin-bottom: 50;">
				<table id="tableProjeto" class="table-striped table table-bordered" style="margin: 0 auto;">
					<thead>
						<tr>
							<th  width=9% class="acoes" style="color: #676a6c;">Ações</th>
						    <th style="color: #676a6c;"> Projeto</th>
							<th style="color: #676a6c;">Orçamento</th>
							<th style="color: #676a6c;">Cronograma</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${projetos}" var="projeto">
							<tr projetoid="${projeto.id}">
								<td id="acoes" class="center">	
									<div>
										<a class="btn-editar" onclick="remover(${projeto.id})" style="color: #676a6c;">
											<i class="fa fa-trash-o" title="Remover" style="font-size: 19px; margin-left: -2px;"></i>
										</a>
										<a  href="<c:url value='/professores/projeto/${projeto.id}/edit'/>" style="vertical-align: middle; color: #676a6c;">
											<i class="fa fa-pencil-square-o" title="Editar" style="font-size: 19px;margin-left: -2px"></i>
										</a>
					  					<a  href="<c:url value='/professores/projeto/new'/>" style="color: #676a6c;">
											<i class="fa fa-file-text" title="Plano de Risco" style="font-size: 16px;margin-left: -2px""></i>
										</a> 
									</div>
								</td>
			
								<td style="color: #676a6c;"> ${projeto.nome} </a> </td>
								<td style="color: #676a6c;"> ${projeto.orcamento}</td>
								<td style="color: #676a6c;"> ${projeto.cronograma}</td>
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
    $('#tableProjeto').dataTable({
        "pagingType": "full_numbers",
        "lengthChange": false,
        "stripeClasses": [ 'odd', 'even'],
        "language": {
			"info":           "Mostrando _START_ de _END_ do total de _TOTAL_ projetos",
			"search":         "Pesquisar:",
			"zeroRecords":    "Projeto não encotrado",
			"paginate": {	
							"first":      "|&lt;",
				        	"last":       ">&gt;|",
				        	"next":       ">>",
				        	"previous":   "<<"
			}
		}
    });
}); 
</script>
</div>