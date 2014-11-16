<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/jogo.css">
<script type="text/javascript" src="/risk/js/risk/jogo.js"></script>

<jsp:include page="../index/header.jsp" />
<jsp:include page="../index/menu.jsp" />

<div id="content" class="content">
	<div class="projeto  mCustomScrollbar">
		<div style="text-align: center;">
			<h3>${projeto.nome}</h3>
		</div>
		<div style="text-align: justify; margin-left: 20px; margin-right: 5px">
			${projeto.descricao}
		</div>
	</div>
	
	<div class="riscosProjeto ">
		<div class="riscos">
			<form id="riscosForm" action="<c:url value="/jogo/riscos"/>" method="post">
					<input type="hidden" name="projeto.id" value="${projeto.id}">
					<div style="text-align: center;">
						<h4>Selecione os riscos do projeto</h4>
					</div>
						<c:forEach items="${riscos}" var="risco">
							<div>
								<input type="checkbox"  name="riscosSelecionados[].risco.id" value="${risco.id}"> ${risco.descricao}
							</div> 
						</c:forEach>
			</form>
		</div>
		<div style="margin-top: 7px; margin-left: -14px;text-align: center;">
			<button type="button" id="btnContinuarJogo" class="btn btn-primary">Continuar</button>
		</div>
	</div>
</div>
	
<script type="text/javascript">
  
    $("#btnContinuarJogo").click(function(){
   		$("#riscosForm").submit();
    });
    
    (function($){
        $(window).load(function(){
            $(".projeto").mCustomScrollbar({
				mouseWheel: false,
				theme: "dark",
				set_height:"85%",
			});
			
			$(".riscos").mCustomScrollbar({
				axis:"x",
				theme: "dark",
				set_height:"91%"
			});
        });
    })(jQuery);
</script>
