package com.pedidosVenda.pedidosVenda.dtos;


import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteDto {
    
    @NotBlank
    @Size(max = 280)
    private String nome;
    @NotBlank
    @Size(max = 280)
    private String cartaoCredito;
    private String status;
    @NotBlank
    @Size(max = 280)
    private String limiteCartao;
    @NotBlank
    @Size(max = 280)
    private String data;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(String limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
