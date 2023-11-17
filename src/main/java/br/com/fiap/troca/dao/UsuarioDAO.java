package br.com.fiap.troca.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.troca.model.UsuarioModel;

public class UsuarioDAO {
    private List<UsuarioModel> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
        usuarios.add(new UsuarioModel(1, "Usuário1", "usuario1@example.com", "senha123", "admin"));
        usuarios.add(new UsuarioModel(2, "Usuário2", "usuario2@example.com", "senha456", "user"));
    }

    // Listar todos os usuários
    public List<UsuarioModel> listarUsuarios() {
        return usuarios;
    }

    // Buscar um usuário por ID
    public UsuarioModel buscarUsuarioPorId(int usuarioId) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getUsuarioId() == usuarioId) {
                return usuario;
            }
        }
        return null;
    }

    // Inserir um novo usuário
    public void inserirUsuario(UsuarioModel usuario) {
        int novoId = usuarios.size() + 1;
        usuario.setUsuarioId(novoId);
        usuarios.add(usuario);
    }

    // Atualizar um usuário existente
    public void atualizarUsuario(UsuarioModel usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuarioId() == usuario.getUsuarioId()) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    // Excluir um usuário por ID
    public void excluirUsuario(int usuarioId) {
        usuarios.removeIf(usuario -> usuario.getUsuarioId() == usuarioId);
    }

    // Método de login
    public UsuarioModel fazerLogin(String email, String senha) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null; // Retorna null se as credenciais não forem encontradas
    }
}
