package br.com.fiap.troca.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.troca.dao.UsuarioDAO;
import br.com.fiap.troca.model.UsuarioModel;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
    }

    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioModel usuario = usuarioDAO.fazerLogin(email, senha);
		
		if ( usuario != null && ( ! usuario.getEmail().isEmpty())) {
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			
			response.sendRedirect("ProdutoListar");
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
