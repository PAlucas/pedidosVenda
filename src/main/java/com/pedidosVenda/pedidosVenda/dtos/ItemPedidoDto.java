package com.pedidosVenda.pedidosVenda.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ItemPedidoDto {
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    @Size(max = 280)
    private Integer idProduto;
    @NotBlank
    @Size(max = 280)
    private double preco;
    @NotBlank
    @Size(max = 280)
    private Integer quantidade;

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
