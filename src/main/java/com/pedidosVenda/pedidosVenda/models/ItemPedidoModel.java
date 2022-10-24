package com.pedidosVenda.pedidosVenda.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ITEMPEDIDO")
public class ItemPedidoModel implements Serializable{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 255)
    private Integer idProduto;
    @Column(nullable = false, length = 280)
    private double preco;
    @Column(nullable = false, unique = true, length = 255)
    private Integer quantidade;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID idPedido) {
        this.id = idPedido;
    }

    public Integer getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}
