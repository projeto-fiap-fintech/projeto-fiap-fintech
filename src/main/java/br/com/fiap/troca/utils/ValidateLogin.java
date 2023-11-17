package br.com.fiap.troca.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.troca.model.UsuarioModel;

public class ValidateLogin {

	public static void validarLogin(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
		if (usuarioLogado == null) {
			throw new Exception("Login expirado");
		}
	}
	
}
