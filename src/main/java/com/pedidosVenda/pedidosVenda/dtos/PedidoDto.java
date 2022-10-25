package com.pedidosVenda.pedidosVenda.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PedidoDto{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 280)
    private String vendedor;
    @NotBlank
    @Size(max = 280)
    private String observacoes;
    @NotBlank
    @Size(max = 280)
    private String status;
    @NotBlank
    @Size(max = 280)
    private String idCliente;

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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }



    
}
