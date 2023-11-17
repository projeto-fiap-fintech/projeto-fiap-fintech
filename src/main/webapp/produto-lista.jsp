<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Lista de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    
    <link href="assets/css/site.css" rel="stylesheet">
    
</head>



<body>

    <h1>Lista de Produtos</h1>
    
    <c:if test="${! empty mensagem}">
    	<h3>${mensagem}</h3>
    </c:if>
    
    
    <a href="ProdutoNovo" class="create btn btn-dark">Adicionar novo produto</a>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>URL da Imagem</th>
            <th>Descrição</th>
            <th>Expirado</th>
            <th>Valor</th>
            <th></th>
        </tr>
        
        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td>${produto.produtoId}</td>
                <td>${produto.nome}</td>
                <td><img src="${produto.urlImagem}"></td>
                <td>${produto.descricao}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${produto.dataExpiracao}"/></td>
                <td><fmt:formatNumber value = "${produto.valor}" type = "currency"/>  </td>
                <td><a href="ProdutoEditar?id=${produto.produtoId}">Editar</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>