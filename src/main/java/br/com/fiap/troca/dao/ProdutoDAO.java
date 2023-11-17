package br.com.fiap.troca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import br.com.fiap.troca.model.CategoriaModel;
import br.com.fiap.troca.model.ProdutoModel;

public class ProdutoDAO {
   
    private static final String URL_CONEXAO = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "pf0954";
    private static final String SENHA = "fiap";

    public ProdutoDAO() {
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

    
    // Listar todos os produtos
    public List<ProdutoModel> listarProdutos() throws SQLException {
    	List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
    	
    	String sql = "SELECT produtoId, nome, urlImagem, disponivel, descricao, sugestaoTroca, valor, dataCadastro, dataExpiracao, usuarioId, categoriaId FROM Produto";
    	
    	try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
    		
    		while (resultSet.next()) {
    			int produtoId = resultSet.getInt("produtoId");
                String nome = resultSet.getString("nome");
                String urlImagem = resultSet.getString("urlImagem");
                boolean disponivel = resultSet.getBoolean("disponivel");
                String descricao = resultSet.getString("descricao");
                String sugestaoTroca = resultSet.getString("sugestaoTroca");
                double valor = resultSet.getDouble("valor");
                Date dataCadastro = resultSet.getDate("dataCadastro");
                Date dataExpiracao = resultSet.getDate("dataExpiracao");
                int usuarioId = resultSet.getInt("usuarioId");
                int categoriaId = resultSet.getInt("categoriaId");
                
                ProdutoModel produto = new ProdutoModel(produtoId, nome, urlImagem, disponivel, descricao, sugestaoTroca, valor, dataCadastro, dataExpiracao, usuarioId);
                produtos.add(produto);
    		}
    			
    	} catch (SQLException e) {
    		throw e;
    	}
    	
    	
        return produtos;
    }
    
    
    public ProdutoModel buscarProdutoPorId(int produtoId) {
        String sql = "SELECT nome, urlImagem, disponivel, descricao, sugestaoTroca, valor, dataCadastro, dataExpiracao, usuarioId, categoriaId FROM Produto WHERE produtoId = ?";
        ProdutoModel produto = null;

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, produtoId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String urlImagem = resultSet.getString("urlImagem");
                    boolean disponivel = resultSet.getBoolean("disponivel");
                    String descricao = resultSet.getString("descricao");
                    String sugestaoTroca = resultSet.getString("sugestaoTroca");
                    double valor = resultSet.getDouble("valor");
                    Date dataCadastro = resultSet.getDate("dataCadastro");
                    Date dataExpiracao = resultSet.getDate("dataExpiracao");
                    int usuarioId = resultSet.getInt("usuarioId");
                    int categoriaId = resultSet.getInt("categoriaId");

                    CategoriaModel categoria = new CategoriaDAO().buscarCategoriaPorId(categoriaId);

                    produto = new ProdutoModel(produtoId, nome, urlImagem, disponivel, descricao, sugestaoTroca, valor, dataCadastro, dataExpiracao, usuarioId, categoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

    public void inserirProduto(ProdutoModel produto) {
        String sql = "INSERT INTO Produto (produtoId, nome, urlImagem, disponivel, descricao, sugestaoTroca, valor, dataCadastro, dataExpiracao, usuarioId, categoriaId) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, produto.getProdutoId());
            statement.setString(2, produto.getNome());
            statement.setString(3, produto.getUrlImagem());
            statement.setBoolean(4, produto.isDisponivel());
            statement.setString(5, produto.getDescricao());
            statement.setString(6, produto.getSugestaoTroca());
            statement.setDouble(7, produto.getValor());
            statement.setDate(8, new java.sql.Date(produto.getDataCadastro().getTime()));
            statement.setDate(9, new java.sql.Date(produto.getDataExpiracao().getTime()));
            statement.setInt(10, produto.getUsuarioId());
            statement.setInt(11, produto.getCategoria().getIdCategoria());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarProduto(ProdutoModel produto) {
        String sql = "UPDATE Produto SET nome = ?, urlImagem = ?, disponivel = ?, descricao = ?, sugestaoTroca = ?, valor = ?, dataCadastro = ?, dataExpiracao = ?, usuarioId = ?, categoriaId = ? WHERE produtoId = ?";

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getUrlImagem());
            statement.setBoolean(3, produto.isDisponivel());
            statement.setString(4, produto.getDescricao());
            statement.setString(5, produto.getSugestaoTroca());
            statement.setDouble(6, produto.getValor());
            statement.setDate(7, new java.sql.Date(produto.getDataCadastro().getTime()));
            statement.setDate(8, new java.sql.Date(produto.getDataExpiracao().getTime()));
            statement.setInt(9, produto.getUsuarioId());
            statement.setInt(10, produto.getCategoria().getIdCategoria());
            statement.setInt(11, produto.getProdutoId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirProduto(int produtoId) {
        String sql = "DELETE FROM Produto WHERE produtoId = ?";

        try (Connection connection = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, produtoId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
