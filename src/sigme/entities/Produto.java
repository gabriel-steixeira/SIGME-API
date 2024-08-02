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
     * @param linha
     * @param usuarioCadastro
     * @param usuarioAlteracao
     * @param dataCadastro
     * @param dataAlteracao
     * @param idFornecedor
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
     * @param linha
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
     * @param idProduto
     * @param nomeProduto
     * @param marca
     * @param categoria
     * @param precoUnitario
     * @param quantidadeEstoque
     * @param dataValidade
     * @param dataLote
     * @param linha
     * @param idFornecedor
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
     * Método para adicionar quantidade ao estoque do produto
     * @param quantidade
     * @return Quantidade após a alteração
     */
    public int adicionarQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade a adicionar não pode ser negativa");
        }
        this.quantidadeEstoque += quantidade;
        return this.quantidadeEstoque;
    }

    /**
     * Método para remover quantidade do estoque do produto
     * @param quantidade
     * @return Quantidade após a alteração
     */
    public int removerQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade a remover não pode ser negativa");
        }
        if (this.quantidadeEstoque - quantidade < 0) {
            throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
        }
        this.quantidadeEstoque -= quantidade;
        return this.quantidadeEstoque;
    }

    // Getters e setters

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

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

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

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
