<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../index/header.jsp" />
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/login.css">
<script type="text/javascript" src="/risk/js/risk.js"></script>
<div class="account-wrapper">
	<div class="account-body">

		<h3>Bem-Vindo ao RISK</h3>

		<form id="redefinirSenhaForm" class="form account-form" action="<c:url value="/atualizarSenha"/>"  method="post">
		
        	<div class="form-group">
        		<input type="text" class="form-control required" id="jogadorLogin" placeholder="Login" name="jogador.login" onblur="buscarLoginRedefinirSenha()"/>
        	
        	</div>
        
        	<div class="form-group">
        		 <input type="password" class="form-control required" id="jogadorSenha" placeholder="Senha" name="jogador.senha" value="" >
        	</div>
			
			<div class="form-group clearfix">
				<div class="pull-right">
					<a class="link" href="<c:url value='/'/>">Login</a>
				</div>
				<div class="pull-left">
					<a class="link" href="<c:url value='/efetuarCadastro'/>">Efetuar Cadastro</a>
				</div>
			</div>
			
			<button type="button" class="btn btn-primary btn-block btn-lg " onclick="gravarRedefinirSenha()">Gravar</button>
		</form>
	</div>
</div>


<script type="text/javascript">
	$(function() {
		$("#jogadorLogin").after("<span class='alert-message error'><i class='fa fa-times-circle'></i>Login não encontrato, verifique seu login ou efetue seu cadastro.</span>")
			.after("<span class='alert-message info'><i class='fa fa-info-circle'></i>Digite um Login para ser pesquisado.</span>")
			.after("<span class='alert-message success'><i class='fa fa-check-circle'></i>Login encontrado.</span>");
					
		$(".alert-message").hide();
	});
</script>