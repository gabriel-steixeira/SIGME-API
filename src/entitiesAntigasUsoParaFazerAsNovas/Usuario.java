/**
 * Usuario
 * Classe para guardar informações dos usuários do sistema, é herdada pelas classes Funcionários e Administradores
 * @author Gabriel Souza Teixeira
 * @version 1.0
 * @since 01/04/2024
 */
public class Usuario {
    public int idUsuario;
    public String nomeUsuario;
    public String cpfUsuario;
    public String usuario;
    public String senha;
    public int nivelAcesso;

    /**
     * Construtor da classe
     * @param idUsuario
     * @param nomeUsuario
     * @param cpfUsuario
     * @param usuario
     * @param senha
     * @param nivelAcesso, pode ser funcionário (0) ou administrador (1)
     */
    public Usuario(int idUsuario, String nomeUsuario, String cpfUsuario, String usuario, String senha, int nivelAcesso) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.usuario = usuario;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    /**
     * Método utilizado para realizar o login do Usuário
     * @param usuario é o usuario fornecido para login. Ex: gabriel.teixeira
     * @param senha é a senha fornecida para login 
     * @return Verdadeiro ou falso, login permitido ou negado
     */
    public boolean loginUsuario(String usuario, String senha) {
        if (usuario == getUsuario() && senha == getSenha()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Obter valor do id do usuario
     * @return idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Atribuir valor ao id do usuario
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obter valor do nome do usuario
     * @return nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Atribuir valor ao nome do usuario
     * @param nomeUsuario
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * Obter valor do cpf do usuario
     * @return cpfUsuario
     */
    public String getCpfUsuario() {
        return cpfUsuario;
    }

    /**
     * Atribuir valor ao cpf do usuario
     * @param cpfUsuario
     */
    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    /**
     * Obter valor do username do usuario
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Atribuir valor ao username do usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obter valor da senha do usuario
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Atribuir valor a senha do usuario
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obter valor do nivel de acesso do usuario
     * @return nivelAcesso
     */
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    /**
     * Atribuir valor ao nivel de acesso do usuario
     * @param nivelAcesso
     */
    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
