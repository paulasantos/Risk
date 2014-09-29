<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/JLib.tld" prefix="jLib"%>
<script src="/risk/js/jogo.js"></script>
<jsp:include page="../index/header.jsp" />

<div>
	Para iniciar, escolha o projeto que deseja gerenciar os riscos.
	
	<jLib:select texto="Projeto" items="${projetos}" name="projeto.id" optionDisplay="nome" optionValue="id" cssClass="required"
									textoDefault="Escolha um Ptojeto..." />
	<label>Projeto: </label>									
	<select id="projetoId" name="projeto.id" onchange="carregarProjetos(projeto.id)" class="required"
		<option value="0">Escolha um Projeto...</option>
		<c:forEach items="${projetos}" var="projeto">
			<option value="${projeto.id}">${projeto.nome}</option>
		</c:forEach>
	</select>									
</div>

<div id="projetoDescricao">
	

</div>
<a class='btn' href="<c:url value='/jogo/riscos'/>" id="riscos">Selecionar os Riscos</a>

<a class='btn' href="<c:url value='/jogo/ajuda'>" id="ajuda">Consultar Especialistas</a>

<jsp:include page="../index/footer.jsp" />