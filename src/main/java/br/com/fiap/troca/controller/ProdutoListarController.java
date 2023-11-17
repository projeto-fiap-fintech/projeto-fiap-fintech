package br.com.fiap.troca.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.troca.dao.ProdutoDAO;
import br.com.fiap.troca.model.ProdutoModel;
import br.com.fiap.troca.model.UsuarioModel;
import br.com.fiap.troca.utils.ValidateLogin;

@WebServlet("/ProdutoListar")
public class ProdutoListarController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ValidateLogin.validarLogin(request);
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			List<ProdutoModel> produtos;
		
			produtos = produtoDAO.listarProdutos();
			request.setAttribute("produtos", produtos);
	        request.getRequestDispatcher("produto-lista.jsp").forward(request, response);
	        
		} catch (SQLException e) {
			response.sendRedirect("error.jsp?erro=Problemas técnicos");
		} catch (Exception e) {
			response.sendRedirect("error.jsp?erro=" + e.getMessage());
		}
			
        
    }

	
}