import java.util.ArrayList;

/**
 * Classe para representar os clientes do sistema
 */
public class Cliente {
    int idCliente; 
    String nomeCliente; 
    String cpfCliente; 
    String email; 
    String telefone; 
    String endereco; 

    /**
     * Construtor da classe venda
     * 
     * @param idCliente
     * @param nomeCliente
     * @param cpfCliente
     * @param email
     * @param telefone
     * @param endereco
     */
    public Cliente(int idCliente, String nomeCliente, String cpfCliente, String email, String telefone, String endereco){
        setIdCliente(idCliente);
        setNomeCliente(nomeCliente);
        setCpfCliente(cpfCliente);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
    }

    public Cliente(){

    }
 
    /**
     * Realiza o cadastro com todas as informações registradas sobre o Cliente.
     * @param nomeCliente
     * @param cpfCliente
     * @param email
     * @param telefone
     * @param endereco
     * @return true ou false, para sucesso ou insucesso
     */
    public boolean cadastrarCliente(String nomeCliente, String cpfCliente, String email, String telefone, String endereco){
        boolean sucesso = false;
        Cliente novoCliente = new Cliente(0, nomeCliente, cpfCliente, email, telefone, endereco);
        //Grava no banco de dados
        sucesso = true;
        return sucesso;
    }

    /**
     * Edita o cadastro do Cliente.
     * @param idCliente
     * @param nomeCliente
     * @param cpfCliente
     * @param email
     * @param telefone
     * @param endereco
     * @return true ou false, para sucesso ou insucesso
     */
    public boolean editarCliente(int idCliente, String nomeCliente, String cpfCliente, String email, String telefone, String endereco){
        boolean sucesso = false;
        if (getIdCliente() == idCliente) {
            setIdCliente(idCliente);
            setNomeCliente(nomeCliente);
            setCpfCliente(cpfCliente);
            setEmail(email);
            setTelefone(telefone);
            setEndereco(endereco);
            sucesso = true;
        }
        else {
            sucesso = false;
        }
        return sucesso;
    }

    /**
     * Exclui o Cliente no sistema.
     * @param idCliente
     * @return true ou false, para sucesso ou insucesso
     */
    public boolean excluirCliente(int idCliente){
        boolean sucesso = false;
        if (getIdCliente() == idCliente) {
            //deletar idCliente do banco de dados
            sucesso = true;
        }
        else {
            sucesso = false;
        }
        return sucesso;
    }

    /**
     * Localiza os dados do Cliente no sistema com o fornecimento dos dados necessários para a consulta, neste caso, pelo nome.
     * @param nomeCliente
     * @return lista de clientes
     */
    public ArrayList<Cliente> buscarClienteNome(String nomeCliente){
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente novoCliente = new Cliente(this.idCliente, this.nomeCliente, this.cpfCliente, this.email, this.telefone, this.endereco);
        
        if (getNomeCliente() == nomeCliente) {
            lista.add(novoCliente);
            return lista;
        } 
        else {
            return lista;
        }   
    }

    /**
     * Localiza os dados do Cliente no sistema com o fornecimento dos dados necessários para a consulta, neste caso, pelo e-mail.
     * @param email
     * @return lista de clientes
     */
    public ArrayList<Cliente> buscarClienteEmail(String email){
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente novoCliente = new Cliente(this.idCliente, this.nomeCliente, this.cpfCliente, this.email, this.telefone, this.endereco);
        
        if (getEmail() == email) {
            lista.add(novoCliente);
            return lista;
        } 
        else {
            return lista;
        }   
    }

    /**
     * Recupera histórico de venda.
     * @param cpfCliente
     * @return lista de vendas
     */
    public ArrayList<Venda> historicoVenda(String cpfCliente){
        ArrayList<Venda> lista = new ArrayList<Venda>();
        Venda novaVenda = new Venda(idCliente, idCliente, idCliente, idCliente, cpfCliente, idCliente, idCliente, cpfCliente, null, cpfCliente, cpfCliente, null);
        
        if (getCpfCliente() == cpfCliente) {
            if (novaVenda.idCliente == this.idCliente) {
                lista.add(novaVenda);
            }
            return lista;
        } 
        else {
            return lista;
        }   
    }

    /**
     * Obter id do cliente
     * @return Id do cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Atribuir valor ao id do cliente
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obter nome do cliente
     * @return nome do cliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Atribuir valor ao nome do cliente
     * @param nomeCliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Obter cpf do cliente
     * @return cpf do cliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * Atribuir valor ao cpf do cliente
     * @param cpfCliente
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * Obter email do cliente
     * @return email do cliente
     */    
    public String getEmail() {
        return email;
    }

    /**
     * Atribuir valor ao email do cliente
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obter telefone do cliente
     * @return telefone do cliente
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Atribuir valor ao telefone do cliente
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obter endereço do cliente
     * @return endereço do cliente
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Atribuir valor ao endereço do cliente
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}