function selecionarRiscos() {
	$("#riscos").load("/risk/jogo/riscos");
	
	$("#riscos").show();
	
	$("#riscos").dialog({
		title : "Selecione os Riscos do projeto",
		resizable : false,
		modal : true,
		width : 480,
		buttons : {
			"Continuar" : function (){
				$form = $("#riscosForm");
					var url = "risk/jogo/riscos";
					
					var novaAction = url;
					$form.attr("action", novaAction);
														
					$.post(novaAction, $form.serialize())
						.success(function(){
							window.location = "risk/jogo/jogar";
						});
			},
			"Cancelar" : function (){
				$("#riscos").hide();
			}
		},
		close : function() {
			$("#riscos").hide();
		}
	});
	
};