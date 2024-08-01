package sigme.dao;

import sigme.controllers.ConexaoBanco;
import sigme.entities.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDAO {
    private Connection conexao;
    private final String sqlInsert = "INSERT INTO APP_SIGME.TB_FORNECEDOR (ID_FORNECEDOR,NOME_FORNECEDOR,RAZAO_SOCIAL,CNPJ,EMAIL,TELEFONE,USUARIO_CADASTRO,USUARIO_ALTERACAO,DATA_CADASTRO,DATA_ALTERACAO) VALUES (APP_SIGME.SQ_TB_FORNECEDOR.NEXTVAL,?,?,?,?,?,?,?,SYSDATE, SYSDATE)";

    public FornecedorDAO() throws SQLException {
        conexao = new ConexaoBanco().Conectar();
    }

    public boolean CadastrarFornecedor(Fornecedor fornecedor) throws SQLException {
        try {
            PreparedStatement statement = conexao.prepareStatement(sqlInsert);
            statement.setString(1, fornecedor.getNomeFornecedor());
            statement.setString(2, fornecedor.getRazaoSocial());
            statement.setString(3, fornecedor.getCnpj());
            statement.setString(4, fornecedor.getEmail());
            statement.setString(5, fornecedor.getTelefone());
            statement.setString(6, fornecedor.getUsuarioCadastro());
            statement.setString(7, fornecedor.getUsuarioAlteracao());

            return statement.execute();
        }catch(SQLException e) {
            return false;
        }
    }
}
