package com.pedidosVenda.pedidosVenda.Classes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;


public class Cliente extends Pessoa{
    private double limiteCredito; 
    private String cartaoCredito; 
    private String Contato; 
    private boolean status; 
    private List<Pedido> Pedidos; 
    public Cliente(String nome, Date data, double limiteCartao, String cartaoCredito,  boolean status, int id, String contado) {
        super(nome, data);
        this.limiteCredito = limiteCartao;
        this.cartaoCredito = cartaoCredito;
        this.Contato = contado;
        this.status = status;
    }

    public double verificaCartao(){
        return 0.0;
    }

    public boolean validaCartao(){
        return false;
    }
}
