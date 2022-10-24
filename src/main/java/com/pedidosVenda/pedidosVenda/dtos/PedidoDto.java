package com.pedidosVenda.pedidosVenda.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PedidoDto{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 280)
    private Integer idCliente;
    @NotBlank
    @Size(max = 280)
    private Date dataPedido;
    @NotBlank
    @Size(max = 280)
    private String vendedor;
    @NotBlank
    @Size(max = 280)
    private String observacoes;
    @NotBlank
    @Size(max = 280)
    private boolean status;

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    
}
