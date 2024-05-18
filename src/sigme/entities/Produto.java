package sigme.entities;

import java.sql.Date;

/**
 * Produto
 * Classe utilizada para persistir informações sobre os produtos da loja virtual
 *
 * @author Gabriel Souza Teixeira
 * @version 1.0
 * @since 01/04/2024
 */
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String marca;
    private String categoria;
    private double precoUnitario;
    private int quantidadeEstoque;
    private Date dataValidade;
    private Date dataLote;
    private String linha;
    private String usuarioCadastro;
    private String usuarioAlteracao;
    private Date dataCadastro;
    private Date dataAlteracao;
    private int idFornecedor;

    /**
     * Construtor da classe Produto
     *
     * @param idProduto
     * @param nomeProduto
     * @param marca
     * @param categoria
     * @param precoUnitario
     * @param quantidadeEstoque
     * @param dataValidade
     * @param dataLote
     * @param linha,            relacionado a linha de lançamento
     * @param usuarioCadastro
     * @param usuarioAlteracao
     * @param dataCadastro
     * @param dataAlteracao
     */
    public Produto(int idProduto, String nomeProduto, String marca, String categoria, double precoUnitario,
                   int quantidadeEstoque, Date dataValidade, Date dataLote, String linha, String usuarioCadastro,
                   String usuarioAlteracao, Date dataCadastro, Date dataAlteracao, int idFornecedor) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.categoria = categoria;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataValidade = dataValidade;
        this.dataLote = dataLote;
        this.linha = linha;
        this.usuarioCadastro = usuarioCadastro;
        this.usuarioAlteracao = usuarioAlteracao;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.idFornecedor = idFornecedor;
    }

    /**
     * Método para realizar cadastro do produto
     * @param nomeProduto
     * @param marca
     * @param categoria
     * @param precoUnitario
     * @param quantidadeEstoque
     * @param dataValidade
     * @param dataLote
     * @param linha, linha de lançamento
     * @return Valor inteiro, 0 ou 1, para representarem FRACASSO ou SUCESSO
     */
    public int cadastrarProduto(String nomeProduto, String marca, String categoria, double precoUnitario,
                                int quantidadeEstoque, Date dataValidade, Date dataLote, String linha) {
        Produto novoProduto = new Produto(0, nomeProduto, marca, categoria, precoUnitario, quantidadeEstoque,
                dataValidade, dataLote, linha, usuarioCadastro, usuarioAlteracao, dataCadastro, dataAlteracao, idFornecedor);
        boolean sucesso = true;
        // Salvar no banco de dados -> atribui valor ao sucesso
        return (sucesso) ? 1 : 0;
    }

    /**
     * Método para realizar edição do produto
     * @param nomeProduto
     * @param marca
     * @param categoria
     * @param precoUnitario
     * @param quantidadeEstoque
     * @param dataValidade
     * @param dataLote
     * @param linha, linha de lançamento
     * @return Valor inteiro, 0 ou 1, para representarem FRACASSO ou SUCESSO
     */
    public int editarProduto(int idProduto, String nomeProduto, String marca, String categoria, double precoUnitario,
                             int quantidadeEstoque, Date dataValidade, Date dataLote, String linha, int idFornecedor) {
        boolean sucesso = false;
        // Pesquisar produto no banco de dados -> retorna objeto
        if (getIdProduto() == idProduto) {
            // Alterar produtos pelos métodos set
            setIdProduto(idProduto);
            setNomeProduto(nomeProduto);
            setMarca(marca);
            setCategoria(categoria);
            setPrecoUnitario(precoUnitario);
            setQuantidadeEstoque(quantidadeEstoque);
            setDataValidade(dataValidade);
            setDataLote(dataLote);
            setLinha(linha);
            setIdFornecedor(idFornecedor);
            sucesso = true;
        }
        return (sucesso) ? 1 : 0;
    }

    /**
     * Método para realizar busca de um produto pelo id do produto
     * @param idProduto
     * @return Objeto do tipo Produto
     */
    public Produto visualizarProduto(int idProduto) {
        // Pesquisar produto no banco de dados
        return new Produto(idProduto, nomeProduto, marca, categoria, precoUnitario, quantidadeEstoque, dataValidade,
                dataLote, linha, usuarioCadastro, usuarioAlteracao, dataCadastro, dataAlteracao, idFornecedor);
    }

    /**
     * Método para realizar busca de um produto pelo nome do produto
     * @param nomeProduto
     * @return Objeto do tipo Produto
     */
    public Produto buscaProdutoNome(String nomeProduto) {
        // Pesquisar produto no banco de dados
        return new Produto(idProduto, nomeProduto, marca, categoria, precoUnitario, quantidadeEstoque, dataValidade,
                dataLote, linha, usuarioCadastro, usuarioAlteracao, dataCadastro, dataAlteracao, idFornecedor);
    }

    /**
     * Método para realizar busca de um produto pela marca do produto
     * @param marca
     * @return Objeto do tipo Produto
     */
    public Produto buscaProdutoMarca(String marca) {
        // Pesquisar produto no banco de dados
        return new Produto(idProduto, nomeProduto, marca, categoria, precoUnitario, quantidadeEstoque, dataValidade,
                dataLote, linha, usuarioCadastro, usuarioAlteracao, dataCadastro, dataAlteracao, idFornecedor);
    }

    /**
     * Método para realizar busca de um produto pela categoria do produto
     * @param categoria
     * @return Objeto do tipo Produto
     */
    public Produto buscaProdutoCategoria(String categoria) {
        // Pesquisar produto no banco de dados
        return new Produto(idProduto, nomeProduto, marca, categoria, precoUnitario, quantidadeEstoque, dataValidade,
                dataLote, linha, usuarioCadastro, usuarioAlteracao, dataCadastro, dataAlteracao, idFornecedor);
    }

    /**
     * Método para adicionar quantidade do produto ao estoque
     * @param quantidade
     * @return Quantidade após a alteração
     */
    public int adicionarQuantidade(int quantidade) {
        // Pesquisar produto no banco de dados
        setQuantidadeEstoque(quantidade);
        return quantidadeEstoque;
    }

    /**
     * Método para remover quantidade do produto ao estoque
     * @param quantidade
     * @return Quantidade após a alteração
     */
    public int removerQuantidade(int quantidade) {
        // Pesquisar produto no banco de dados
        setQuantidadeEstoque(quantidade);
        return quantidadeEstoque;
    }

    /**
     * Obter id do produto
     * @return Id do produto
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
     * Obter nome do produto
     * @return Nome do produto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * Atribuir valor ao nome do produto
     * @param nomeProduto
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * Obter Marca do produto
     * @return Marca do produto
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Atribuir valor a marca do produto
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obter Categoria do produto
     * @return Categoria do produto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Atribuir valor a categoria do produto
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obter Preço Unitário do produto
     * @return Preço Unitário do produto
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * Atribuir valor ao Preço Unitário do produto
     * @param precoUnitario
     */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /**
     * Obter Quantidade do produto
     * @return Quantidade do produto
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * Atribuir valor a quantidade do produto
     * @param quantidadeEstoque
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * Obter Data da Validade do produto
     * @return Data da Validade do produto
     */
    public Date getDataValidade() {
        return dataValidade;
    }

    /**
     * Atribuir valor a Data da Validade do produto
     * @param dataValidade
     */
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Obter Data do Lote do produto
     * @return Data do Lote do produto
     */
    public Date getDataLote() {
        return dataLote;
    }

    /**
     * Atribuir valor a DataLote do produto
     * @param dataLote
     */
    public void setDataLote(Date dataLote) {
        this.dataLote = dataLote;
    }

    /**
     * Obter Linha de lançamento do produto
     * @return Linha de lançamento do produto
     */
    public String getLinha() {
        return linha;
    }

    /**
     * Atribuir valor a linha de lançamento do produto
     * @param linha
     */
    public void setLinha(String linha) {
        this.linha = linha;
    }

    /**
     * Obter Usuário de Cadastro do produto
     * @return Usuário de Cadastro do produto
     */
    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    /**
     * Atribuir valor ao usuario de cadastro do produto
     * @param usuarioCadastro
     */
    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    /**
     * Obter Usuário de Alteração do produto
     * @return Usuário de Alteração do produto
     */
    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    /**
     * Atribuir valor ao usuário de alteração do produto
     * @param usuarioAlteracao
     */
    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    /**
     * Obter Data de Cadastro do produto
     * @return Data de Cadastro do produto
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * Atribuir valor a data de cadastro do produto
     * @param dataCadastro
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * Obter Data de Alteração do produto
     * @return Data de Alteração do produto
     */
    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    /**
     * Atribuir valor a data de alteração do produto
     * @param dataAlteracao
     */
    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    /**
     * Obter idFornecedor
     * @return idFornecedor
     */
    public int getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * Atribuir valor ao idFornecedor
     * @param idFornecedor
     */
    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
}
