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
    @Column(nullable = false,length = 255)
    private String idProduto;
    @Column(nullable = false,length = 255)
    private String idPedido;
    @Column(nullable = false,length = 280)
    private double preco;
    @Column(nullable = false,length = 255)
    private int quantidade;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
