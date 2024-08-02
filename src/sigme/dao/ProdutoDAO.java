package sigme.dao;

import sigme.controllers.ConexaoBanco;
import sigme.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    private Connection conexao;

    private final String sqlInsert = "INSERT INTO APP_SIGME.PRODUTO (ID_PRODUTO, NOME_PRODUTO, MARCA, CATEGORIA, PRECO_UNITARIO, QUANTIDADE_ESTOQUE, DATA_VALIDADE, DATA_LOTE, LINHA_PRODUTO, USUARIO_CADASTRO, USUARIO_ALTERACAO, DATA_CADASTRO, DATA_ALTERACAO, ID_FORNECEDOR) VALUES (APP_SIGME.SQ_TB_PRODUTO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdateQuantidade = "UPDATE APP_SIGME_SIS.PRODUTO SET QUANTIDADEESTOQUE = ?, USUARIOALTERACAO = ?, DATAALTERACAO = SYSDATE WHERE IDPRODUTO = ?";
    private final String sqlBuscarPorId = "SELECT * FROM APP_SIGME_SIS.PRODUTO WHERE IDPRODUTO = ?";

    public ProdutoDAO() throws SQLException {
        conexao = new ConexaoBanco().Conectar();
    }

    public boolean CadastrarProduto(Produto produto) throws SQLException {
        try {
            PreparedStatement statement = conexao.prepareStatement(sqlInsert);
            statement.setString(1, produto.getNomeProduto());
            statement.setString(2, produto.getMarca());
            statement.setString(3, produto.getCategoria());
            statement.setDouble(4, produto.getPrecoUnitario());
            statement.setInt(5, produto.getQuantidadeEstoque());
            statement.setDate(6, produto.getDataValidade());
            statement.setDate(7, produto.getDataLote());
            statement.setString(8, produto.getLinha());
            statement.setString(9, produto.getUsuarioCadastro());
            statement.setString(10, produto.getUsuarioAlteracao());
            statement.setDate(11, produto.getDataCadastro());
            statement.setDate(12, produto.getDataAlteracao());
            statement.setInt(13, produto.getIdFornecedor());

            return statement.execute();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean atualizarQuantidade(int idProduto, int novaQuantidade, String usuarioAlteracao) throws SQLException {
        try {
            PreparedStatement statement = conexao.prepareStatement(sqlUpdateQuantidade);
            statement.setInt(1, novaQuantidade);
            statement.setString(2, usuarioAlteracao);
            statement.setInt(3, idProduto);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public Produto buscarProdutoPorId(int idProduto) throws SQLException {
        try {
            PreparedStatement statement = conexao.prepareStatement(sqlBuscarPorId);
            statement.setInt(1, idProduto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Produto(
                        resultSet.getInt("IDPRODUTO"),
                        resultSet.getString("NOMEPRODUTO"),
                        resultSet.getString("MARCA"),
                        resultSet.getString("CATEGORIA"),
                        resultSet.getDouble("PRECOUNITARIO"),
                        resultSet.getInt("QUANTIDADEESTOQUE"),
                        resultSet.getDate("DATAVALIDADE"),
                        resultSet.getDate("DATALOTE"),
                        resultSet.getString("LINHAPRODUTO"),
                        resultSet.getString("USUARIOCADASTRO"),
                        resultSet.getString("USUARIOALTERACAO"),
                        resultSet.getDate("DATACADASTRO"),
                        resultSet.getDate("DATAALTERACAO"),
                        resultSet.getInt("IDFORNECEDOR")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar produto por ID", e);
        }
    }

    public boolean editarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produtos SET nomeProduto = ?, marca = ?, categoria = ?, precoUnitario = ?, quantidadeEstoque = ?, dataValidade = ?, dataLote = ?, linha = ?, idFornecedor = ? WHERE idProduto = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getCategoria());
            stmt.setDouble(4, produto.getPrecoUnitario());
            stmt.setInt(5, produto.getQuantidadeEstoque());
            stmt.setDate(6, new java.sql.Date(produto.getDataValidade().getTime()));
            stmt.setDate(7, new java.sql.Date(produto.getDataLote().getTime()));
            stmt.setString(8, produto.getLinha());
            stmt.setInt(9, produto.getIdFornecedor());
            stmt.setInt(10, produto.getIdProduto());
            return stmt.executeUpdate() > 0;
        }
    }
}
