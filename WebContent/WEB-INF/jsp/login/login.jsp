<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../index/header.jsp" />
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/login.css">
<div class="account-wrapper">
	<div class="account-body">

		<h3>Bem-Vindo ao RISK</h3>

		<form id="loginForm" class="form account-form" action="<c:url value="/efetuarLogin"/>"  method="post">
		
        	<div class="form-group">
        		<input type="text" class="form-control" id="login-username" placeholder="Usuário" name="jogador.login"/>
        	
        	</div>
        
        	<div class="form-group">
        		<input type="password" class="form-control" id="login-password" placeholder="Senha" name="jogador.senha"/>
        	</div>
			
			<div class="form-group clearfix">
				<div class="pull-left">
					<a class="link" href="<c:url value='/redefinirSenha'/>">Esqueci minha senha</a>
				</div>
				<div class="pull-right">
					<a class="link" href="<c:url value='/efetuarCadastro'/>">Efetuar Cadastro</a>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary btn-block btn-lg"> Enviar</button>
		</form>
	</div>
</div>