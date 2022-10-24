package com.pedidosVenda.pedidosVenda.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PEDIDO")
public class PedidoModel implements Serializable{
    //Serialization to grant safety of an object state
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 255)
    private Integer idCliente;
    @Column(nullable = false, length = 280)
    private Date dataPedido;
    @Column(nullable = false, unique = true, length = 255)
    private String vendedor;
    @Column(nullable = false, unique = true, length = 255)
    private String observacoes;
    @Column(nullable = false, length = 280)
    private boolean status;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
