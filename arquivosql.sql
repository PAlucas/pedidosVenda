create table CLIENTE
(
  id             RAW(255) not null,
  cartao_credito VARCHAR2(255 CHAR) not null,
  data           VARCHAR2(280 CHAR) not null,
  limite_cartao  FLOAT not null,
  nome           VARCHAR2(255 CHAR) not null,
  status         NUMBER(10) not null
)

alter table CLIENTE
  add primary key (ID)

alter table CLIENTE
  add constraint UK_NDM1APKUI2HG5Y7DS5M48D8UT unique (NOME)

create table ITEMPEDIDO
(
  id         RAW(255) not null,
  id_pedido  VARCHAR2(280) not null,
  id_produto VARCHAR2(280) not null,
  preco      FLOAT not null,
  quantidade NUMBER(10) not null
)

alter table ITEMPEDIDO
  add primary key (ID)

create table PEDIDO
(
  id          RAW(255) not null,
  data_pedido VARCHAR2(280 CHAR) not null,
  id_cliente  VARCHAR2(255 CHAR) not null,
  observacoes VARCHAR2(255 CHAR) not null,
  status      NUMBER(10) not null,
  vendedor    VARCHAR2(255 CHAR) not null
)

alter table PEDIDO
  add primary key (ID)

  create table PRODUTO
(
  id              RAW(255) not null,
  nome_produto    VARCHAR2(255 CHAR) not null,
  preco           FLOAT not null,
  qtde_disponivel NUMBER(10) not null
)

alter table PRODUTO
  add primary key (ID)
