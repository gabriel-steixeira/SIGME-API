package sigme.controllers;

import sigme.dao.FornecedorDAO;
import sigme.entities.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorController {
    private Connection conexao;
    private FornecedorDAO store;

    public FornecedorController() throws SQLException {
        conexao = new ConexaoBanco().Conectar();
        store = new FornecedorDAO();
    }

    public boolean CadastrarFornecedor(Fornecedor fornecedor) throws SQLException {
        return store.CadastrarFornecedor(fornecedor);
    }
}
