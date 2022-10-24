package com.pedidosVenda.pedidosVenda.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PRODUTO")
public class ProdutoModel implements Serializable{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 255)
    private Integer qtdeDisponivel;
    @Column(nullable = false, length = 280)
    private double preco;
    @Column(nullable = false, unique = true, length = 255)
    private String nomeProduto;
    @Column(nullable = false, length = 280)


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQtdeDisponivel() {
        return this.qtdeDisponivel;
    }

    public void setQtdeDisponivel(Integer qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    
}
