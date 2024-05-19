import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoController {
    private Connection connection;
    
    public ProdutoController() {
        try {
            // Configuração da conexão com o banco de dados
            String url = "jdbc:mysql://localhost:3306/seuBancoDeDados";
            String user = "seuUsuario";
            String password = "suaSenha";
            connection = DriverManager.getConnection(url, user, password);
            criarTabelaSeNecessario();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para criar a tabela de produtos se não existir
    private void criarTabelaSeNecessario() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                     "id INT PRIMARY KEY AUTO_INCREMENT," +
                     "nome VARCHAR(100) NOT NULL," +
                     "quantidadeEmEstoque INT NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para adicionar um produto ao banco de dados
    public void adicionarProduto(String nome, int quantidadeEmEstoque) {
        String sql = "INSERT INTO produtos (nome, quantidadeEmEstoque) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, quantidadeEmEstoque);
            pstmt.executeUpdate();
            System.out.println("Produto adicionado: " + nome);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para excluir um produto pelo ID
    public void excluirProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Produto excluído com ID: " + id);
            } else {
                System.out.println("Produto não encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para listar todos os produtos
    public void listarProdutos() {
        String sql = "SELECT * FROM produtos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Lista de Produtos:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int quantidadeEmEstoque = rs.getInt("quantidadeEmEstoque");
                System.out.println(id + ": " + nome + " - Estoque: " + quantidadeEmEstoque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método principal para testar a funcionalidade
    public static void main(String[] args) {
        ProdutoController controller = new ProdutoController();
        
        // Adicionando alguns produtos para teste
        controller.adicionarProduto("Batom", 20);
        controller.adicionarProduto("Base", 15);
        controller.adicionarProduto("Perfume", 30);
        controller.adicionarProduto("Colonia", 40);
        controller.adicionarProduto("Esmalte", 10);
        controller.adicionarProduto("Creme", 30);
        // Listando os produtos antes da exclusão
        controller.listarProdutos(); 
        // Excluindo um produto pelo ID
        controller.excluirProduto(2);
        // Listando os produtos após a exclusão
        controller.listarProdutos();
    }
}
