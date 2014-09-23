<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../index/header.jsp" />
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/login.css">

<div class="account-wrapper">
	<div class="account-body">
		
		<form id="jogadorForm" class="account-form form-horizontal" action="<c:url value="/cadastrarJogador"/>" method="POST">
			<p class="text-center" style="font-size: 17pt; margin-top: -25px;">Efetuar Cadastro</p>

			<div class="form-group">
			    <label for="jogadorName" class="col-sm-2 control-label">Nome</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="jogadorName" placeholder="Nome" name="jogador.nome" value="" >
			    </div>
		  	</div>
  					
			<div class="form-group">
			    <label for="jogadorLogin" class="col-sm-2 control-label">Login</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="jogadorLogin" placeholder="Login" name="jogador.login" value="" >
			    </div>
		  	</div>
  					
			<div class="form-group">
			    <label for="jogadorSenha" class="col-sm-2 control-label">Senha</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="jogadorSenha" placeholder="Senha" name="jogador.senha" value="" >
			    </div>
		  	</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-block btn-lg ">Enviar</button>
				</div>
			</div>
			
		</form>
	</div>
</div>

<jsp:include page="../index/footer.jsp" />