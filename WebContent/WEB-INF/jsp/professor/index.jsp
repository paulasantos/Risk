<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>DataTables Bootstrap 3 example</title>

<link rel="stylesheet" type="text/css" href="/risk/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/risk/css/dataTables.bootstrap.css">


<script type="text/javascript" language="javascript" src="/risk/js/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" language="javascript" src="/risk/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="/risk/js/dataTables.bootstrap.js"></script>

</head>
<body>
	<div class="container">
		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example" style="width: 98%; margin: 0 auto;">
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
					<tr projetoid="${projeto.id}" class="gradeA">
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
	<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('#example').dataTable({
		});
	});
</script>
	
</body>
</html>