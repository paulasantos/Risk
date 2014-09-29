(function(app) {
	app.views.projeto = {
		verficarDisponibilidadeContexto : function() {
			var projetoId = $("#projetoId").val();
			var url = contextPath + "/projetos/"+ $("#projetoId").val() + "/find";
			$("#projetoDescricao").load(url, function (responseText, textStatus, req) {
		        $("#projetoDescricao").show();
		     });
		}
	 };
})(risk);