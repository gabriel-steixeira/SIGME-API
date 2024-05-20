package sigme.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sigme.dao.ProdutoDAO;
import sigme.entities.Produto;

public class ProdutoController {
    private Connection conexao;
    private ProdutoDAO store;
    
    public ProdutoController() throws SQLException {
        conexao = new ConexaoBanco().Conectar();
        store = new ProdutoDAO();
    }

    public boolean cadastrarProduto(Produto produto) throws SQLException {
        return store.CadastrarProduto(produto);
    }

    public boolean editarProduto(Produto produto) throws SQLException {
        return store.editarProduto(produto);
    }

//    public List<Produto> visualizarProdutos() {
//        return produtos;
//    }

    // Método para excluir um produto pelo ID
    public void excluirProduto(int id) {
//        Iterator<Produto> iterator = produtos.iterator();
//        while (iterator.hasNext()) {
//            Produto produto = iterator.next();
//            if (produto.getIdProduto() == id) {
//                iterator.remove();
//                System.out.println("Produto excluído: " + produto.getNomeProduto());
//                return;
//            }
//        }
        System.out.println("Produto não encontrado com o ID: " + id);
    }
}
