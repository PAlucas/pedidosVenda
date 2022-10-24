package com.pedidosVenda.pedidosVenda.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProdutoDto{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 280)
    private Integer qtdeDisponivel;
    @NotBlank
    @Size(max = 280)
    private double preco;
    @NotBlank
    @Size(max = 280)
    private String nomeProduto;

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
