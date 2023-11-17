package br.com.fiap.troca.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RepresentanteListar")
public class RepresentanteListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RepresentanteListarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ... doing doing
		
		
		
		request.getRequestDispatcher("representante-lista.jsp").forward(request, response);
	}

}
