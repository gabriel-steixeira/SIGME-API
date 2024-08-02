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

    // Método para editar a quantidade de um produto
    public int editarQuantidade(int idProduto, int quantidade, boolean adicionar, String usuarioAlteracao)
            throws SQLException {
        Produto produto = store.buscarProdutoPorId(idProduto);

        if (produto != null) {
            int novaQuantidade = produto.getQuantidadeEstoque();

            if (adicionar) {
                novaQuantidade += quantidade;
            } else {
                novaQuantidade -= quantidade;
                if (novaQuantidade < 0) {
                    return -1; // Falha, quantidade não pode ser negativa
                }
            }

            boolean atualizado = store.atualizarQuantidade(idProduto, novaQuantidade, usuarioAlteracao);
            return atualizado ? novaQuantidade : -1;
        } else {
            return -1; // Produto não encontrado
        }
    }

    // public List<Produto> visualizarProdutos() {
    // return produtos;
    // }

    // Método para excluir um produto pelo ID
    // public void excluirProduto(int id) {
        // Iterator<Produto> iterator = produtos.iterator();
        // while (iterator.hasNext()) {
        // Produto produto = iterator.next();
        // if (produto.getIdProduto() == id) {
        // iterator.remove();
        // System.out.println("Produto excluído: " + produto.getNomeProduto());
        // return;
        // }
        // }
    public boolean editarProduto(Produto produto) throws SQLException {
        return store.editarProduto(produto);
    }

//    public List<Produto> visualizarProdutos() {
//        return produtos;
//    }

    // Método para excluir um produto pelo ID
    // public void excluirProduto(int id) {
//        Iterator<Produto> iterator = produtos.iterator();
//        while (iterator.hasNext()) {
//            Produto produto = iterator.next();
//            if (produto.getIdProduto() == id) {
//                iterator.remove();
//                System.out.println("Produto excluído: " + produto.getNomeProduto());
//                return;
//            }
//        }
    //     System.out.println("Produto não encontrado com o ID: " + id);
    // }
}