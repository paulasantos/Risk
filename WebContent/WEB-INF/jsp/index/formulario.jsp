<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../index/header.jsp" />
<link rel="stylesheet" type="text/css" href="/risk/stylesheets/login.css">
<script type="text/javascript" src="/risk/js/risk.js"></script>
<div class="account-wrapper">
	<div class="account-body">
		
		<form id="usuarioForm" class="account-form form-horizontal" action="<c:url value="/cadastrarJogador"/>" method="POST">
			<p>Efetuar Cadastro</p>

			<div class="form-group">
			    <label for="usuarioName" class="col-sm-2 control-label">Nome</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control required" id="usuarioName" placeholder="Nome" name="usuario.nome" value="" >
			    </div>
		  	</div>
  					
			<div class="form-group">
			    <label for="usuarioLogin" class="col-sm-2 control-label">Login</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control required" id="usuarioLogin" placeholder="Login" name="usuario.login" onblur="validaLogin()" >
			    </div>
		  	</div>
  					
			<div class="form-group">
			    <label for="usuarioSenha" class="col-sm-2 control-label">Senha</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control required" id="usuarioSenha" placeholder="Senha" name="usuario.senha" value="" >
			    </div>
		  	</div>
		  	
		  	<div class="form-group">
			    <label for="usuarioPerfil" class="col-sm-2 control-label">Perfil</label>
			    <div class="col-sm-10">
				  	<select id="usuarioPerfil" name="usuario.perfil.id" class="required form-control">
							<option value="0">Escolha um Perfil...</option>
							<c:forEach items= "${perfis}" var="perfil">
								<option value="${perfil.id}"> ${perfil.nome} </option>
							</c:forEach>
					</select>
				</div>
			</div>
		  	<div class="form-group clearfix ">
				<div class="pull-left">
					<a class="link" href="<c:url value='/redefinirSenha'/>" style="padding: 80px;">Esqueci minha senha</a>
				</div>
				<div class="pull-right">
					<a class="link" href="<c:url value='/'/>" style="padding: 17px;">Login</a>
				</div>
			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-primary btn-block btn-lg " id="btnCadastroJogador" onclick="gravar()">Gravar</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$("#usuarioLogin").after("<span class='alert-message alert success'><i class='fa fa-check-circle'></i>Login disponível.</span>")
			.after("<span class='alert-message error'><i class='fa fa-times-circle'></i>Login indisponível.</span>")
			.after("<span class='alert-message info'><i class='fa fa-info-circle'></i>Digite um Login para ser pesquisado.</span>");
					
		$(".alert-message").hide();
	});
</script>
<jsp:include page="../index/footer.jsp" />