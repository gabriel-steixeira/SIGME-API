import java.util.Date;

/**
 * Venda
 * Classe para registrar as Vendas
 * 
 * @version 1.0
 * @since 01/04/2024
 */
public class Venda {
    int idVenda;
    int idFuncionario;
    int idCliente;
    int idProduto;
    String tipoPagamento;
    double desconto;
    double valorVenda;
    String notaFiscal;
    Date dataVenda;
    String usuarioVenda;
    String usuarioCancelamento;
    Date dateCancelamento;

    /**
     * Construtor com parâmetros da classe Venda.
     * 
     * @param idVenda
     * @param idFuncionario
     * @param idCliente
     * @param idProduto
     * @param tipoPagamento
     * @param desconto
     * @param valorVenda
     * @param notaFiscal
     * @param dataVenda
     * @param usuarioVenda
     * @param usuarioCancelamento
     * @param dateCancelamento
     */
    public Venda(int idVenda, int idFuncionario, int idCliente, int idProduto, String tipoPagamento, double desconto,
            double valorVenda,
            String notaFiscal, Date dataVenda, String usuarioVenda, String usuarioCancelamento, Date dateCancelamento) {
        this.idVenda = idVenda;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.tipoPagamento = tipoPagamento;
        this.desconto = desconto;
        this.valorVenda = valorVenda;
        this.notaFiscal = notaFiscal;
        this.dataVenda = dataVenda;
        this.usuarioVenda = usuarioVenda;
        this.usuarioCancelamento = usuarioCancelamento;
        this.dateCancelamento = dateCancelamento;
    }

    /**
     * Construtor sem parâmetros da classe Venda.
     */
    public Venda() {

    }

    /**
     * Registra a venda no banco de dados do sistema.
     * 
     * @return true or false
     */
    public boolean registrarVenda(int idFuncionario, int idCliente, int idProduto, String tipoPagamento,
            double desconto, double valorVenda,
            String notaFiscal, Date dataVenda, String usuarioVenda, String usuarioCancelamento, Date dateCancelamento) {
        boolean sucesso = false;
        Venda novaVenda = new Venda(0, idFuncionario, idCliente, idProduto, tipoPagamento, desconto, valorVenda,
                notaFiscal, dataVenda, usuarioVenda, usuarioCancelamento, dateCancelamento);
        // Adicionar objeto ao banco de dados, se sucesso true, se não, false
        return sucesso;
    }

    /**
     * Método para edição da venda
     * 
     * @param idVenda
     * @param idFuncionario
     * @param idCliente
     * @param idProduto
     * @param tipoPagamento
     * @param desconto
     * @param valorVenda
     * @param notaFiscal
     * @param dataVenda
     * @param usuarioVenda
     * @param usuarioCancelamento
     * @param dateCancelamento
     * @return true ou false, para sucesso ou insucesso
     */
    public boolean editarVenda(int idVenda, int idFuncionario, int idCliente, int idProduto, String tipoPagamento,
    double desconto, double valorVenda,
    String notaFiscal, Date dataVenda, String usuarioVenda, String usuarioCancelamento, Date dateCancelamento) {
        boolean sucesso = false;
        if (getIdVenda() == idVenda) {
            setIdVenda(idVenda);
            setIdFuncionario(idFuncionario);
            setIdCliente(idCliente);
            setIdProduto(idProduto);
            setTipoPagamento(tipoPagamento);
            setDesconto(desconto);
            setValorVenda(valorVenda);
            setNotaFiscal(notaFiscal);
            setDataVenda(dataVenda);
            setUsuarioVenda(usuarioVenda);
            setUsuarioCancelamento(usuarioCancelamento);
            setDateCancelamento(dateCancelamento);
            sucesso = true;
        }
        else {
            sucesso = false;
        }

        return sucesso;
    }

    /**
     * Método para cancelar venda
     * 
     * @param idVenda
     * @return true ou false, para sucesso ou insucesso
     */
    public boolean cancelarVenda(int idVenda) {
        boolean sucesso = false;
        if (getIdVenda() == idVenda) {
            //excluir o objeto...
            sucesso = true;
        }
        else {
            sucesso = false;
        }
        return sucesso;
    }
    
    /**
     * Imprime todas as informações sobre a venda na nota fiscal.
     * 
     * @param idVenda
     * @param notaFiscal
     * @return true ou false, para sucesso ou insucesso
     */
    public boolean registrarNotaFiscal(int idVenda, String notaFiscal) {
        boolean sucesso = false;
        if (getIdVenda() == idVenda) {
            setNotaFiscal(notaFiscal);
            sucesso = true;
        }
        else {
            sucesso = false;
        }
        return sucesso; 
    }

    /**
     * Obter id da venda
     * @return id da venda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * Atribuir valor ao id da venda
     * @param idVenda
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * Obter id de funcionário
     * @return id de funcionário
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Atribuir valor ao id do funcionário
     * @param idFuncionario
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * Obter id de cliente
     * @return id de cliente
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
     * Obter id do produto
     * @return id do produto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Atribuir valor ao id do produto
     * @param idProduto
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Obter tipo do pagamento
     * @return tipoPagamento
     */
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * Atribuir valor ao tipo do pagamento
     * @param tipoPagamento
     */
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    /**
     * Obter desconto
     * @return desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * Atribuir valor ao desconto
     * @param desconto
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * Obter valor da venda
     * @return valor da venda
     */
    public double getValorVenda() {
        return valorVenda;
    }

    /**
     * Atribuir valor ao valor da renda
     * @param valorVenda
     */
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * Obter nota fiscal
     * @return notaFiscal
     */
    public String getNotaFiscal() {
        return notaFiscal;
    }

    /**
     * Atribuir valor a nota fiscal
     * @param notaFiscal
     */
    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    /**
     * Obter data da venda
     * @return dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     * Atribuir valor a data da venda
     * @param dataVenda
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * Obter usuario da venda
     * @return usuarioVenda
     */
    public String getUsuarioVenda() {
        return usuarioVenda;
    }

    /**
     * Atribuir valor ao usuario da venda
     * @param usuarioVenda
     */
    public void setUsuarioVenda(String usuarioVenda) {
        this.usuarioVenda = usuarioVenda;
    }

    /**
     * Obter usuario do cancelamento
     * @return usuarioCancelamento
     */
    public String getUsuarioCancelamento() {
        return usuarioCancelamento;
    }

    /**
     * Atribuir valor ao usuario de cancelamento
     * @param usuarioCancelamento
     */
    public void setUsuarioCancelamento(String usuarioCancelamento) {
        this.usuarioCancelamento = usuarioCancelamento;
    }

    /**
     * Obter data de cancelamento
     * @return dataCancelamento
     */
    public Date getDateCancelamento() {
        return dateCancelamento;
    }

    /**
     * Atribuir valor a data de cancelamento
     * @param dateCancelamento
     */
    public void setDateCancelamento(Date dateCancelamento) {
        this.dateCancelamento = dateCancelamento;
    }

}