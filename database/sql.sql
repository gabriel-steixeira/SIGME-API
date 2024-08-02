CREATE USER APP_SIGME_SIS IDENTIFIED BY sigme_2024;

CREATE TABLE APP_SIGME_SIS.caixa (
    saldo             NUMBER,
    saldoultimasemana NUMBER,
    saldoultimomes    NUMBER,
    usuarioalteracao  VARCHAR2(30)
);

CREATE TABLE APP_SIGME_SIS.cliente (
    idcliente   INTEGER NOT NULL,
    nomecliente VARCHAR2(30) NOT NULL,
    cpfcliente  VARCHAR2(19) NOT NULL,
    "e-mail"    VARCHAR2(45),
    telefone    VARCHAR2(14) NOT NULL
);

ALTER TABLE APP_SIGME_SIS.cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( idcliente );

ALTER TABLE APP_SIGME_SIS.cliente ADD CONSTRAINT cliente__un UNIQUE ( cpfcliente );

CREATE TABLE APP_SIGME_SIS.endereco (
    idendereco  INTEGER NOT NULL,
    logradouro  VARCHAR2(30) NOT NULL,
    numero      INTEGER,
    complemento VARCHAR2(30),
    bairro      VARCHAR2(30) NOT NULL,
    cidade      VARCHAR2(20) NOT NULL
);

ALTER TABLE APP_SIGME_SIS.endereco ADD CONSTRAINT endereco_pk PRIMARY KEY ( idendereco );

CREATE TABLE APP_SIGME_SIS.fornecedor (
    idfornecedor     INTEGER NOT NULL,
    nomefornecedor   VARCHAR2(30) NOT NULL,
    razaosocial      VARCHAR2(30),
    cnpj             VARCHAR2(18) NOT NULL,
    "E-mail"         VARCHAR2(45),
    telefone         VARCHAR2(14),
    usuariocadastro  VARCHAR2(30) NOT NULL,
    usuarioalteracao VARCHAR2(30) NOT NULL,
    datacadastro     DATE,
    dataalteracao    DATE
);

ALTER TABLE APP_SIGME_SIS.fornecedor ADD CONSTRAINT fornecedor_pk PRIMARY KEY ( idfornecedor );

ALTER TABLE APP_SIGME_SIS.fornecedor ADD CONSTRAINT fornecedor__un UNIQUE ( cnpj );

CREATE TABLE APP_SIGME_SIS.pedidoproduto (
    idpedido            INTEGER NOT NULL,
    quantidadeproduto   INTEGER NOT NULL,
    valorpedido         NUMBER,
    tipopagamento       VARCHAR2(10),
    datapedido          DATE,
    dataentrega         DATE,
    statuspedido        VARCHAR2(20) NOT NULL,
    notafiscal          VARCHAR2(50),
    usuariocadastro     VARCHAR2(30) NOT NULL,
    usuarioalteracao    VARCHAR2(30) NOT NULL,
    usuariocancelamento VARCHAR2(30) NOT NULL,
    datacancelamento    DATE
);

ALTER TABLE APP_SIGME_SIS.pedidoproduto ADD CONSTRAINT pedidoproduto_pk PRIMARY KEY ( idpedido );

CREATE TABLE APP_SIGME_SIS.produto (
    idproduto         INTEGER NOT NULL,
    nomeproduto       VARCHAR2(30) NOT NULL,
    marca             VARCHAR2(20) NOT NULL,
    categoria         VARCHAR2(20),
    precounitario     NUMBER NOT NULL,
    quantidadeestoque NUMBER NOT NULL,
    datavalidade      DATE NOT NULL,
    datalote          DATE,
    linhaproduto      VARCHAR2(30),
    usuariocadastro   VARCHAR2(30) NOT NULL,
    usuarioalteracao  VARCHAR2(30) NOT NULL,
    datacadastro      DATE,
    dataalteracao     DATE
);

ALTER TABLE APP_SIGME_SIS.produto ADD CONSTRAINT produto_pk PRIMARY KEY ( idproduto );

CREATE TABLE APP_SIGME_SIS.usuario (
    idusuario   INTEGER NOT NULL,
    nomeusuario VARCHAR2(30) NOT NULL,
    cpf         VARCHAR2(19) NOT NULL,
    usuario     VARCHAR2(30) NOT NULL,
    senha       VARCHAR2(20) NOT NULL,
    nivelacesso INTEGER,
    codigoctps  VARCHAR2(20),
    cargo       VARCHAR2(20)
);

ALTER TABLE APP_SIGME_SIS.usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( idusuario );

ALTER TABLE APP_SIGME_SIS.usuario ADD CONSTRAINT usuario__un UNIQUE ( cpf,
                                                        usuario );

CREATE TABLE APP_SIGME_SIS.venda (
    idvenda             INTEGER NOT NULL,
    produtos            VARCHAR2(50) NOT NULL,
    tipopagamento       VARCHAR2(10) NOT NULL,
    desconto            VARCHAR2(10),
    valorvenda          NUMBER NOT NULL,
    notafiscal          VARCHAR2(50),
    datavenda           DATE,
    usuariovenda        VARCHAR2(30) NOT NULL,
    usuariocancelamento VARCHAR2(30),
    datacancelamento    DATE
);

ALTER TABLE APP_SIGME_SIS.venda ADD CONSTRAINT venda_pk PRIMARY KEY ( idvenda );

ALTER TABLE APP_SIGME_SIS.endereco
    ADD CONSTRAINT endereco_cliente_fk FOREIGN KEY ( idendereco )
        REFERENCES cliente ( idcliente );

ALTER TABLE APP_SIGME_SIS.endereco
    ADD CONSTRAINT endereco_fornecedor_fk FOREIGN KEY ( idendereco )
        REFERENCES fornecedor ( idfornecedor );

ALTER TABLE APP_SIGME_SIS.pedidoproduto
    ADD CONSTRAINT pedidoproduto_fornecedor_fk FOREIGN KEY ( idpedido )
        REFERENCES fornecedor ( idfornecedor );

ALTER TABLE APP_SIGME_SIS.pedidoproduto
    ADD CONSTRAINT pedidoproduto_produto_fk FOREIGN KEY ( idpedido )
        REFERENCES produto ( idproduto );

ALTER TABLE APP_SIGME_SIS.produto
    ADD CONSTRAINT produto_fornecedor_fk FOREIGN KEY ( idproduto )
        REFERENCES fornecedor ( idfornecedor );

ALTER TABLE APP_SIGME_SIS.venda
    ADD CONSTRAINT venda_cliente_fk FOREIGN KEY ( idvenda )
        REFERENCES cliente ( idcliente );

ALTER TABLE APP_SIGME_SIS.venda
    ADD CONSTRAINT venda_usuario_fk FOREIGN KEY ( idvenda )
        REFERENCES usuario ( idusuario );