/**
 * Classe que representa o Administrador de uma microempresa.
 */
public class Administrador {
 
    private boolean podeCancelarVenda;  // confirmação de cancelamento de venda.
    private boolean podeFazerPedido;    // confirmacão para  fazer o pedido.
    private boolean podeCancelarPedido; // canfirmação de cancelamento de pedido.
    private boolean podePagarSalario;   // confirmação de pagamento de salario .
    private boolean podeCadastrarFornecedor; // cadastramento de fornecedor .
    private boolean podeAcessarCaixa;       // define quem pode acessar caixa .

    /**
     * Construtor da classe Administrator
     *
     * @param podeCancelarVenda      Define se o administrador pode cancelar uma venda.
     * @param podeFazerPedido        Define se o administrador pode fazer um pedido.
     * @param podeCancelarPedido     Define se o administrador pode cancelar um pedido.
     * @param podePagarSalario       Define se o administrador pode pagar o salário dos funcionários.
     * @param podeCadastrarFornecedor Define se o administrador pode cadastrar um fornecedor.
     * @param podeAcessarCaixa       Define se o administrador pode acessar o caixa.
     */
    public Administrador(boolean podeCancelarVenda, boolean podeFazerPedido, boolean podeCancelarPedido,
                         boolean podePagarSalario, boolean podeCadastrarFornecedor, boolean podeAcessarCaixa) {
        this.podeCancelarVenda = podeCancelarVenda;   // administrador pode cancelar venda
        this.podeFazerPedido = podeFazerPedido;  // administrador pode fazer pedido
        this.podeCancelarPedido = podeCancelarPedido;  // administrador pode cancelar pedido
        this.podePagarSalario = podePagarSalario;  // administrador   pode pagar salario 
        this.podeCadastrarFornecedor = podeCadastrarFornecedor;  // administrador  cadastra fornecedor 
        this.podeAcessarCaixa = podeAcessarCaixa;   // administrador acessa o caixa 
    }
    
       /**
     * Verifica se o administrador pode cancelar uma venda.
     * @return true se o administrador pode cancelar a venda, false caso contrário.
     */
    public boolean getPodeCancelarVenda() {    // cancelamento de venda
        return podeCancelarVenda;
    }

    /**
     * Define se o administrador pode cancelar uma venda.
     * @param podeCancelarVenda o novo valor para a permissão de cancelar venda.
     */
    public void setPodeCancelarVenda(boolean podeCancelarVenda) { //confirmaçao de cancelamento de venda
        this.podeCancelarVenda = podeCancelarVenda;
    }

    /**
     * Verifica se o administrador pode fazer um pedido.
     * @return true se o administrador pode fazer o pedido, false caso contrário.
     */
    public boolean getPodeFazerPedido() {    //   Pedido feito
        return podeFazerPedido;
    }

    /**
     * Define se o administrador pode fazer um pedido.
     * @param podeFazerPedido o novo valor para a permissão de fazer pedido.
     */
    public void setPodeFazerPedido(boolean podeFazerPedido) {    // confirmação de pedido
        this.podeFazerPedido = podeFazerPedido;
    } 

    /**
     * Verifica se o administrador pode cancelar um pedido.
     * @return true se o administrador pode cancelar o pedido, false caso contrário.
     */
    public boolean getPodeCancelarPedido() {    //cancelamento de pedido 
        return podeCancelarPedido;
    }

    /**
     * Define se o administrador pode cancelar um pedido.
     * @param podeCancelarPedido o novo valor para a permissão de cancelar pedido.
     */
    public void setPodeCancelarPedido(boolean podeCancelarPedido) {  //confirmação de cancelamento de pedido 
        this.podeCancelarPedido = podeCancelarPedido;
    }

    /**
     * Verifica se o administrador pode pagar o salário dos funcionários.
     * @return true se o administrador pode pagar o salário, false caso contrário.
     */
    public boolean getPodePagarSalario() {   //Pagamento de salario 
        return podePagarSalario;
    }

    /**
     * Define se o administrador pode pagar o salário dos funcionários.
     * @param podePagarSalario o novo valor para a permissão de pagar salário.
     */
    public void setPodePagarSalario(boolean podePagarSalario) {   // confirmaçao de pagamento de salario 
        this.podePagarSalario = podePagarSalario;
    }

    /**
     * Verifica se o administrador pode cadastrar um fornecedor.
     * @return true se o administrador pode cadastrar o fornecedor, false caso contrário.
     */
    public boolean getPodeCadastrarFornecedor() {    // cadastro de fornecedor 
        return podeCadastrarFornecedor;
    }

    /**
     * Define se o administrador pode cadastrar um fornecedor.
     * @param podeCadastrarFornecedor o novo valor para a permissão de cadastrar fornecedor.
     */
    public void setPodeCadastrarFornecedor(boolean podeCadastrarFornecedor) {   // confirmaçao de cadastro de fornecedor 
        this.podeCadastrarFornecedor = podeCadastrarFornecedor;
    }

    /**
     * Verifica se o administrador pode acessar o caixa.
     * @return true se o administrador pode acessar o caixa, false caso contrário.
     */
    public boolean getPodeAcessarCaixa() {     // confirmação para acessar caixa 
        return podeAcessarCaixa;
    }

    /**
     * Define se o administrador pode acessar o caixa.
     * @param podeAcessarCaixa o novo valor para a permissão de acessar caixa.
     */
    public void setPodeAcessarCaixa(boolean podeAcessarCaixa) {    // administrador acessa caixa 
        this.podeAcessarCaixa = podeAcessarCaixa;
    }

    /**
     * Cria um novo usuário.
     * @return true se o usuário foi criado com sucesso, false caso contrário.
     */
    public boolean criarUsuario() {
        // Implementação para criar um novo usuário
        // Retorna true se o usuário foi criado com sucesso, false caso contrário
        return true;
    }

    /**
     * Inativa um usuário.
     * @return true se o usuário foi inativado com sucesso, false caso contrário.
     */
    public boolean inativarUsuario() {
        // Implementação para inativar um usuário
        // Retorna true se o usuário foi inativado com sucesso, false caso contrário
        return true;
    }
}