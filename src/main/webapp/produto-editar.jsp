<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Produto</title>
</head>
<body>
    <h1>Editar Produto</h1>
    <form action="ProdutoEditar" method="post">
    	<input type="hidden" name="produtoId" value="${produto.produtoId}">
        Nome: <input type="text" name="nome" value="${produto.nome}"><br>
        URL da Imagem: <input type="text" name="urlImagem" value="${produto.urlImagem}"><br>
        Descrição: <input type="text" name="descricao" value="${produto.descricao}"><br>
        Valor (R$ 102,64): <input type="text" name="valor" value="<fmt:formatNumber value ="${produto.valor}" type="currency"/>"><br>
        Expiracao (dd/MM/aaaa): <input type="text" name="dataExpiracao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${produto.dataExpiracao}"/>"> <br>
        Disponível: <input type="checkbox" name="disponivel" checked="${produto.disponivel}"><br>
        Categoria: 
        <select name="categoria.idCategoria">
        	<option value="">Selecione</option>
        	<c:forEach items="${categorias}" var="categoria">
        		<c:choose>
	        		<c:when test="${categoria.idCategoria == produto.categoria.idCategoria}">
	        			<option selected value="${categoria.idCategoria}">${categoria.nomeCategoria}</option>	
	        		</c:when>
	        		<c:otherwise>
	        			<option value="${categoria.idCategoria}">${categoria.nomeCategoria}</option>	
	        		</c:otherwise>
        		</c:choose>
        	</c:forEach>
        </select>
        <br>
        
        <input type="submit" value="Alterar">
    </form>
</body>
</html>