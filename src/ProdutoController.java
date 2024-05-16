import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos;
    
    public ProdutoController() {
        produtos = new ArrayList<>();
    }
    
    // Classe que representa um produto
    public class Produto {
        private int id;
        private String nome;
        private int quantidadeEmEstoque;
        
        public Produto(int id, String nome, int quantidadeEmEstoque) {
            this.id = id;
            this.nome = nome;
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }
        
        // Getters e Setters
        public int getId() {
            return id;
        }
        
        public String getNome() {
            return nome;
        }
        
        public int getQuantidadeEmEstoque() {
            return quantidadeEmEstoque;
        }
    }
    
    // Método para excluir um produto pelo ID
    public void excluirProduto(int id) {
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getId() == id) {
                iterator.remove();
                System.out.println("Produto excluído: " + produto.getNome());
                return;
            }
        }
        System.out.println("Produto não encontrado com o ID: " + id);
    }
    
    // Método principal para testar a funcionalidade
    public static void main(String[] args) {
        ProdutoController controller = new ProdutoController();
        
        // Adicionando alguns produtos para teste
        controller.produtos.add(controller.new Produto(1, "Camiseta", 20));
        controller.produtos.add(controller.new Produto(2, "Calça", 15));
        controller.produtos.add(controller.new Produto(3, "Tênis", 30));
        
        // Listando os produtos antes da exclusão
        System.out.println("Lista de Produtos:");
        for (Produto produto : controller.produtos) {
            System.out.println(produto.getId() + ": " + produto.getNome() + " - Estoque: " + produto.getQuantidadeEmEstoque());
        }
        
        // Excluindo um produto pelo ID
        controller.excluirProduto(2);
        
        // Listando os produtos após a exclusão
        System.out.println("Lista de Produtos após a exclusão:");
        for (Produto produto : controller.produtos) {
            System.out.println(produto.getId() + ": " + produto.getNome() + " - Estoque: " + produto.getQuantidadeEmEstoque());
        }
    }
}
