// import Produto;
import java.time.LocalDate;

// import SIGME.src.entities.Produto;
// import java.sql.Date;

// import entities.;

public class App {
    /**
    * @param args
    * @throws Exception
    */

    public static void main(String[] args) throws Exception {
        // System.out.println("Welcome to our system :)");
        
        LocalDate dataValidade = LocalDate.of(2024, 5, 16);
        LocalDate dataLote = LocalDate.of(2024, 5, 16);
        LocalDate dataCadastro = LocalDate.of(2024, 5, 16);
        LocalDate dataAlteracao = LocalDate.of(2024, 5, 16);
        Produto produto = new Produto(1, "Escova de dentes", "Colgato", "Higiene Pessoal", 7.5, 100, dataValidade, dataLote, "1", "gabriel.teixeira", "", dataCadastro, dataAlteracao);

        System.out.println(produto.nomeProduto);
    }
}