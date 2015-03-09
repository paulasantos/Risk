<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">

<jsp:include page="../index/header.jsp" />

<jsp:include page="../index/menu.jsp" />
<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

	<form id="riscosForm" action="<c:url value="/jogo/riscos"/>" method="post">
		<div>
			<c:forEach items="${planoDeRiscos.riscosAnalisados}" var="riscosAnalisados" varStatus="countRiscos">
				<label name="riscosAnalisados[${countRiscos.count -1}].risco.id"> ${riscosAnalisados[countRiscos.count -1].risco.descricao}</label>
			</c:forEach>
		</div>
	</form>
	<jsp:include page="../jogo/analise.jsp" />
	

<div id="riscos"></div>
<script type="text/javascript">
    $("#btnRiscos").click(function(){
    	var projetoId = $("#projetoId").val();
    	if(projetoId > 0 ){
    		$("#formProjeto").submit();
    	}
    });
    
</script>  
