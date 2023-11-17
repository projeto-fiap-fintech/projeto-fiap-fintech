package br.com.fiap.troca.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.troca.dao.ProdutoDAO;
import br.com.fiap.troca.model.CategoriaModel;
import br.com.fiap.troca.model.ProdutoModel;
import br.com.fiap.troca.utils.TrocaParser;

@WebServlet("/ProdutoNovo")
public class ProdutoNovoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProdutoDAO produtoDAO;
	private final int usuarioIdLogado = 1;
       
    public ProdutoNovoController() {
        super();
        produtoDAO = new ProdutoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("produto-novo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String urlImagem = request.getParameter("urlImagem");
        String descricao = request.getParameter("descricao");
        double valor = TrocaParser.parseBrazilianCurrency(request.getParameter("valor"));
        Date dataExpiracao = TrocaParser.parseStringToDate(request.getParameter("dataExpiracao"));
        boolean disponivel = TrocaParser.parseCheckBox(request.getParameter("disponivel"));
        int categoriaId =  TrocaParser.stringToInt(request.getParameter("categoria.idCategoria"));
        
        CategoriaModel categoriaModel = new CategoriaModel(categoriaId, null, null);
        
        ProdutoModel produto = new ProdutoModel(0, nome, urlImagem, disponivel, descricao, "", valor, new Date(), dataExpiracao, usuarioIdLogado, categoriaModel);
        produtoDAO.inserirProduto(produto);

		response.sendRedirect("ProdutoListar");
	}

}
