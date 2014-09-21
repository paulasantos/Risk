<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<form id="livroForm" action="<c:url value="/jogadores"/>" method="POST">
		<label>Nome:</label>
		<input id="nome" name="jogador.nome" value=""/>
		
		<label>Login:</label>
		<input id="login" name="jogador.login" value=""/>
		
		<label>Senha:</label>
		<input id="login" name="jogador.senha" value="" type="password"/>
		
		<button type="submit">Enviar</button>
		
	</form>
</html>