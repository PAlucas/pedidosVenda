package com.pedidosVenda.pedidosVenda.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProdutoDto{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 280)
    private String qtdeDisponivel;
    @NotBlank
    @Size(max = 280)
    private String preco;
    @NotBlank
    @Size(max = 280)
    private String nomeProduto;

    public String getQtdeDisponivel() {
        return this.qtdeDisponivel;
    }

    public void setQtdeDisponivel(String qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public String getPreco() {
        return this.preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    
}
