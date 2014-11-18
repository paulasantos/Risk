function verificarDisponibilidade(login, functionSuccess){
		$.get("/risk/verificarDisponibilidade/"+ login)
		.success(functionSuccess)
		.error(function() {
			$('#usuarioLogin').parent().find('.alert-message').hide();
			$('#usuarioLogin').parent().find('.error').show();
			$('#usuarioLogin').parent().addClass("has-error");
		})
	}

function validaFormulario($form){
	var $elements;
	var validate = true;
	
	$elements = $form.find("input[type != hidden], select, textarea");
	$elements.each(function() {
		var thisClass = $(this).attr("class");
		if( thisClass && thisClass.match("required") ) {
			if($(this).val() == ""){
				$(this).parent().addClass("has-error");
				validate = false;
			}else{
				$(this).parent().removeClass("has-error");
			}
		}
	});
	return validate; 
}

function validaLogin(){
	var login = $("#usuarioLogin").val();
	if(login == ""){
		$('#usuarioLogin').parent().find('.alert-message').hide();
		$('#usuarioLogin').parent().find('.info').show();
		$('#usuarioLogin').parent().addClass("has-error");
	}
	else{
		verificarDisponibilidade(login, function( isLoginValido ) {		
			if(isLoginValido.boolean == true){
				$('#usuarioLogin').parent().find('.alert-message').hide();
				$('#usuarioLogin').parent().find('.success').show();
				$('#usuarioLogin').parent().removeClass("has-error");
			}
			else{
				$('#usuarioLogin').parent().find('.alert-message').hide();
				$('#usuarioLogin').parent().find('.error').show();
				$('#usuarioLogin').parent().addClass("has-error");
			}	
		});
	}
}


function gravar(){
	var $form = $("#usuarioForm")

	var login = $("#usuarioLogin").val();
	if(login == ""){
		$('#usuarioLogin').parent().find('.alert-message').hide();
		$('#usuarioLogin').parent().find('.info').show();
		$('#usuarioLogin').parent().addClass("has-error");
	}
	else{
		verificarDisponibilidade(login, function( isLoginValido ) {		
			if(isLoginValido.boolean == true){
				$('#usuarioLogin').parent().find('.alert-message').hide();
				$('#usuarioLogin').parent().find('.success').show();
				$('#usuarioLogin').parent().removeClass("has-error");
				
				if( validaFormulario($form))
					$form.submit();
			}
			else{
				$('#usuarioLogin').parent().find('.alert-message').hide();
				$('#usuarioLogin').parent().find('.error').show();
				$('#usuarioLogin').parent().addClass("has-error");
			}	
		});
	}
}


function buscarLoginRedefinirSenha(){
	var login = $("#usuarioLogin").val();
	if(login == ""){
		$('#usuarioLogin').parent().find('.alert-message').hide();
		$('#usuarioLogin').parent().find('.info').show();
		$('#usuarioLogin').parent().addClass("has-error");
	}
	else{
		verificarDisponibilidade(login, function( isLogin ) {		
			if(isLogin.boolean == true){
				$('#usuarioLogin').parent().find('.alert-message').hide();
				$('#usuarioLogin').parent().find('.error').show();
				$('#usuarioLogin').parent().removeClass("has-error");
			}
			else{
				$('#usuarioLogin').parent().find('.alert-message').hide();
				$('#usuarioLogin').parent().find('.success').show();
				$('#usuarioLogin').parent().removeClass("has-error");
			}	
		});
	}
}

function gravarRedefinirSenha(){
	var $form = $("#redefinirSenhaForm")

	var login = $("#jogadorLogin").val();
	if(login == ""){
		$('#jogadorLogin').parent().find('.alert-message').hide();
		$('#jogadorLogin').parent().find('.info').show();
		$('#jogadorLogin').parent().addClass("has-error");
	}else{
		verificarDisponibilidade(login, function( isLogin ) {		
			if(isLogin.boolean == true){
				$('#jogadorLogin').parent().find('.alert-message').hide();
				$('#jogadorLogin').parent().find('.error').show();
				$('#jogadorLogin').parent().removeClass("has-error");
			}
			else{
				$('#jogadorLogin').parent().find('.alert-message').hide();
				$('#jogadorLogin').parent().find('.success').show();
				$('#jogadorLogin').parent().addClass("has-error");
				if( validaFormulario($form))
					$form.submit();
			}	
		});
	}
};

