package com.pedidosVenda.pedidosVenda.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ItemPedidoDto {
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    @Size(max = 280)
    private String idProduto;
    @NotBlank
    @Size(max = 280)
    private String idPedido;
    @NotBlank
    @Size(max = 280)
    private String preco;
    @NotBlank
    @Size(max = 280)
    private String quantidade;

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

    public String getPreco() {
        return this.preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    
     
    
}
