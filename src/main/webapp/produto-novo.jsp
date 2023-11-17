<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Produto</title>
</head>
<body>
    <h1>Adicionar Produto</h1>
    <form action="ProdutoNovo" method="post">
        Nome: <input type="text" name="nome"><br>
        URL da Imagem: <input type="text" name="urlImagem"><br>
        Descrição: <input type="text" name="descricao"><br>
        Valor (R$ 102,64): <input type="text" name="valor"><br>
        Expiracao (dd/MM/aaaa): <input type="text" name="dataExpiracao"> <br>
        Disponível: <input type="checkbox" name="disponivel"><br>
        Categoria: <input type="text" name="categoria.idCategoria"><br>
        <input type="submit" value="Adicionar">
    </form>
</body>
</html>