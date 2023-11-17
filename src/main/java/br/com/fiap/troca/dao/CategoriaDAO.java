package br.com.fiap.troca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.troca.model.CategoriaModel;

public class CategoriaDAO {
	
    private static final String URL_CONEXAO = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "pf0954";
    private static final String SENHA = "fiap";
    
    public CategoriaDAO() {
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

    public List<CategoriaModel> listarCategorias() {
        List<CategoriaModel> categorias = new ArrayList<>();
        String sql = "SELECT idCategoria, nomeCategoria, descricaoCategoria FROM Categoria";

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idCategoria = resultSet.getInt("idCategoria");
                String nomeCategoria = resultSet.getString("nomeCategoria");
                String descricaoCategoria = resultSet.getString("descricaoCategoria");

                CategoriaModel categoria = new CategoriaModel(idCategoria, nomeCategoria, descricaoCategoria);
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    public CategoriaModel buscarCategoriaPorId(int idCategoria) {
        String sql = "SELECT nomeCategoria, descricaoCategoria FROM Categoria WHERE idCategoria = ?";
        CategoriaModel categoria = null;

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCategoria);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nomeCategoria = resultSet.getString("nomeCategoria");
                    String descricaoCategoria = resultSet.getString("descricaoCategoria");
                    categoria = new CategoriaModel(idCategoria, nomeCategoria, descricaoCategoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoria;
    }

    public void inserirCategoria(CategoriaModel categoria) {
        String sql = "INSERT INTO Categoria (idCategoria, nomeCategoria, descricaoCategoria) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoria.getIdCategoria());
            statement.setString(2, categoria.getNomeCategoria());
            statement.setString(3, categoria.getDescricaoCategoria());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCategoria(CategoriaModel categoria) {
        String sql = "UPDATE Categoria SET nomeCategoria = ?, descricaoCategoria = ? WHERE idCategoria = ?";

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoria.getNomeCategoria());
            statement.setString(2, categoria.getDescricaoCategoria());
            statement.setInt(3, categoria.getIdCategoria());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCategoria(int idCategoria) {
        String sql = "DELETE FROM Categoria WHERE idCategoria = ?";

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCategoria);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

