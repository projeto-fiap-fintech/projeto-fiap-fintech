package br.com.fiap.troca.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.troca.dao.CategoriaDAO;
import br.com.fiap.troca.dao.ProdutoDAO;
import br.com.fiap.troca.model.CategoriaModel;
import br.com.fiap.troca.model.ProdutoModel;
import br.com.fiap.troca.utils.TrocaParser;

@WebServlet("/ProdutoEditar")
public class ProdutoEditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int produtoId = TrocaParser.stringToInt(request.getParameter("id"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ProdutoModel produtoModel = produtoDAO.buscarProdutoPorId(produtoId);
		request.setAttribute("produto", produtoModel); // disponibilizando as informação para o JSP
		
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		List<CategoriaModel> categorias = categoriaDAO.listarCategorias();
		request.setAttribute("categorias", categorias);
		
		
		request.getRequestDispatcher("produto-editar.jsp").forward(request, response); // exibindo o JSP
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int produtoId = TrocaParser.stringToInt(request.getParameter("produtoId"));
        String nome = request.getParameter("nome");
        String urlImagem = request.getParameter("urlImagem");
        String descricao = request.getParameter("descricao");
        double valor = TrocaParser.parseBrazilianCurrency(request.getParameter("valor"));
        Date dataExpiracao = TrocaParser.parseStringToDate(request.getParameter("dataExpiracao"));
        boolean disponivel = TrocaParser.parseCheckBox(request.getParameter("disponivel"));
        int categoriaId =  TrocaParser.stringToInt(request.getParameter("categoria.idCategoria"));
        
        CategoriaModel categoriaModel = new CategoriaModel(categoriaId, null, null);

		
        ProdutoModel produtoModel = new ProdutoModel(produtoId, nome, urlImagem, disponivel, descricao, "", valor, new Date(), dataExpiracao, 1, categoriaModel);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.atualizarProduto(produtoModel);
        
        
        response.sendRedirect("ProdutoListar");
        
	}

}
