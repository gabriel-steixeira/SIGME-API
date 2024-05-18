package sigme.dao;

import sigme.controllers.ConexaoBanco;
import sigme.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private Connection conexao;
    private final String sqlInsert = "INSERT INTO APP_SIGME_SIS.PRODUTO (IDPRODUTO, NOMEPRODUTO, MARCA, CATEGORIA, PRECOUNITARIO, QUANTIDADEESTOQUE, DATAVALIDADE, DATALOTE, LINHAPRODUTO, USUARIOCADASTRO, USUARIOALTERACAO, DATACADASTRO, DATAALTERACAO, IDFORNECEDOR) VALUES (APP_SIGME_SIS.SQ_PRODUTO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
        }
        catch (SQLException e) {
            return false;
        }
    }
}
