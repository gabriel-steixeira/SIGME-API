import sigme.controllers.ProdutoController;
import sigme.entities.Produto;
import java.time.LocalDate;

public class App {
    /**
    * @param args
    * @throws Exception
    */

    public static void main(String[] args) throws Exception {
        LocalDate dataValidade = LocalDate.of(2024, 5, 16);
        LocalDate dataLote = LocalDate.of(2024, 5, 16);
        LocalDate dataCadastro = LocalDate.of(2024, 5, 16);
        LocalDate dataAlteracao = LocalDate.of(2024, 5, 16);
        Produto produto1 = new Produto(1, "Escova de dentes", "Colgato", "Higiene Pessoal", 7.5, 100, dataValidade, dataLote, "1", "gabriel.teixeira", "", dataCadastro, dataAlteracao);
        Produto produto2 = new Produto(2, "Pasta de dentes", "Colgato", "Higiene Pessoal", 5, 100, dataValidade, dataLote, "1", "gabriel.teixeira", "", dataCadastro, dataAlteracao);
        Produto produto3 = new Produto(3, "Sabonete", "Dovi", "Higiene Pessoal", 3.8, 100, dataValidade, dataLote, "1", "gabriel.teixeira", "", dataCadastro, dataAlteracao);

        ProdutoController controller = new ProdutoController();

        // Listando os produtos
        System.out.println("Lista de Produtos:");
        for (Produto produto : controller.visualizarProdutos()) { // Erro pois a lista é privada -> Ester vai criar o método de visualizar a lista, então esse for será desnecessário
            System.out.println(produto.getIdProduto() + ": " + produto.getNomeProduto() + " - Estoque: " + produto.getQuantidadeEstoque());
        }
        System.out.println("\n\n");

        //Cadastrando produtos
        controller.cadastrarProduto(produto1);
        controller.cadastrarProduto(produto2);
        controller.cadastrarProduto(produto3);
        controller.cadastrarProduto(produto1);

        System.out.println("Lista de Produtos:");
        for (Produto produto : controller.visualizarProdutos()) { // Erro pois a lista é privada -> Ester vai criar o método de visualizar a lista, então esse for será desnecessário
            System.out.println(produto.getIdProduto() + ": " + produto.getNomeProduto() + " - Estoque: " + produto.getQuantidadeEstoque());
        }
        System.out.println("\n\n");

        // Excluindo um produto pelo ID
        controller.excluirProduto(2);

        // Listando os produtos após a exclusão
        System.out.println("Lista de Produtos após a exclusão:");
        for (Produto produto : controller.visualizarProdutos()) { // Erro pois a lista é privada -> Ester vai criar o método de visualizar a lista, então esse for será desnecessário
            System.out.println(produto.getIdProduto() + ": " + produto.getNomeProduto() + " - Estoque: " + produto.getQuantidadeEstoque());
        }
    }
}