<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Login</title>
</head>
<body>

	<h2>${param.mensagem}</h2>

    <form action="Login" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required><br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br>
        <input type="submit" value="Entrar">
    </form>
</body>
</html>