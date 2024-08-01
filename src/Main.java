import java.sql.Date;
import java.sql.SQLException;

import sigme.controllers.FornecedorController;
import sigme.entities.Fornecedor;
import sigme.entities.Produto;
import sigme.controllers.ProdutoController;

public class Main {
    public static void main(String[] args) throws SQLException {
        Date dataValidade = new Date(2025, 5, 16);
        Date dataLote = new Date(2024, 5, 16);
        Date dataCadastro = new Date(2024, 5, 21);
        Date dataAlteracao = new Date(2024, 5, 21);
        Produto produto1 = new Produto(1, "Escova de dentes", "Colgato", "Higiene Pessoal", 7.5, 100, dataValidade, dataLote, "1", "gabriel.teixeira", "gabriel.teixeira", dataCadastro, dataAlteracao, 1);
        Produto produto2 = new Produto(2, "Pasta de dentes", "Colgato", "Higiene Pessoal", 5, 100, dataValidade, dataLote, "1", "gabriel.teixeira", "gabriel.teixeira", dataCadastro, dataAlteracao, 1);
        Produto produto3 = new Produto(3, "Sabonete", "Dovi", "Higiene Pessoal", 3.8, 100, dataValidade, dataLote, "1", "gabriel.teixeira", "gabriel.teixeira", dataCadastro, dataAlteracao, 1);

        ProdutoController produtoController = new ProdutoController();
        FornecedorController fornecedorController = new FornecedorController();

        Fornecedor fornecedor1 = new Fornecedor(1, "Colgato", "Colgato", "123456789/0001-24", "colgato@colgato.com", "11987654321", "gabriel.teixeira", "gabriel.teixeira");
        fornecedorController.CadastrarFornecedor(fornecedor1);

        //produtoController.cadastrarProduto(produto1);
        //produtoController.cadastrarProduto(produto2);
        //produtoController.cadastrarProduto(produto3);
    }
}