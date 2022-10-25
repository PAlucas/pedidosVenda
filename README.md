# pedidosVenda

## Tecnologias usadas
- Spring (jpa, hobernate, boot, spring generator)
- Oracle 11g database

## Diagrama de classe
![image](https://user-images.githubusercontent.com/44738000/197779575-67ed7d87-9fea-4d57-8aa7-4bbef7d7a247.png)

## Diagrama de entidade e relacionamento
![image](https://user-images.githubusercontent.com/44738000/197824582-2d88c61b-3ecf-412a-a419-762ec2040893.png)

## Comandos por entidade

### Cliente
- GET localhost:8081/Cliente - traz todos os clientes
- GET localhost:8081/Cliente/{id} - traz cliente com determinado id
- GET localhost:8081/Cliente/Idade/{id} - traz idade cliente com determinado id
- GET localhost:8081/Cliente/Cartao/{id} - traz a validacao do cartao do cliente com determinado id
- POST localhost:8081/Cliente - insere cliente
- DELETE localhost:8081/Cliente/{id} - deleta cliente com determinado id
- Patch localhost:8081/Cliente/{id} - muda algumas informações do cliente com determinado id
### Pedido
- GET localhost:8081/Pedido - traz todos os pedidos
- GET localhost:8081/Pedido/{id} - traz pedido com determinado id
- POST localhost:8081/Pedido - insere pedido
- DELETE localhost:8081/Pedido/{id} - deleta pedido com determinado id
- Patch localhost:8081/Pedido/{id} - muda algumas informações do pedido com determinado id
- Patch localhost:8081/Pedido/Status/{id} - muda algumas informações do pedido com determinado id
### ItemPedido
- GET localhost:8081/ItemPedido - traz todos os itens pedidos
- GET localhost:8081/ItemPedido/{id} - traz item pedido com determinado id
- POST localhost:8081/ItemPedido - insere item pedido
- DELETE localhost:8081/ItemPedido/{id} - deleta item pedido com determinado id
- Patch localhost:8081/ItemPedido/{id} - muda algumas informações do item pedido com determinado id
### Produto
- GET localhost:8081/Produto - traz todos os produto
- GET localhost:8081/Produto/{id} - traz produto com determinado id
- POST localhost:8081/Produto - insere produto
- DELETE localhost:8081/Produto/{id} - deleta produto com determinado id
- Patch localhost:8081/Produto/{id} - muda algumas informações do produto com determinado id

### Observações
- Criar o repositório e colocar o comando spring.jpa.hibernate.ddl-auto=create no application.properties

