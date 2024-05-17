package sigme.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sigme.entities.Produto;

public class ProdutoController {
    private List<Produto> produtos;
    
    public ProdutoController() {
        produtos = new ArrayList<Produto>();
    }

    public boolean cadastrarProduto(Produto produto) {
        produtos.add(produto);
        return true;
    }

    public List<Produto> visualizarProdutos() {
        return produtos;
    }

    // Método para excluir um produto pelo ID
    public void excluirProduto(int id) {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getIdProduto() == id) {
                iterator.remove();
                System.out.println("Produto excluído: " + produto.getNomeProduto());
                return;
            }
        }
        System.out.println("Produto não encontrado com o ID: " + id);
    }
}
