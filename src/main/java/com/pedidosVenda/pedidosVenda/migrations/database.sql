CREATE TABLE cliente(
    id VARCHAR2(280) NOT NULL,
    nome VARCHAR2(280) NOT NULL,
    data DATE NOT NULL,
    cartaoCredito VARCHAR2(280) NOT NULL,
    status number NOT NULL,
    limiteCartao number NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE produto(
    id VARCHAR2(280) NOT NULL,
    qtdeDisponivel number NOT NULL,
    preco number NOT NULL,
    nome VARCHAR2(280) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE pedido(
    id VARCHAR2(280) NOT NULL,
    idCliente VARCHAR2(280) NOT NULL,
    dataPedido DATE NOT NULL,
    vendedor VARCHAR2(280) NOT NULL,
    observacoes VARCHAR2(280) NOT NULL,
    status INTEGER NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_cliente
    FOREIGN KEY (idCliente)
    REFERENCES cliente(id)
    
);

CREATE TABLE itempedido(
    id VARCHAR2(280) NOT NULL,
    idproduto VARCHAR2(280) NOT NULL,
    preco number NOT NULL,
    quantidade number NOT NULL,
    PRIMARY KEY(id),
      CONSTRAINT fk_produto
    FOREIGN KEY (idproduto)
    REFERENCES produto(id)
);