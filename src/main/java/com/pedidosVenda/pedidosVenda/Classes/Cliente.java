package com.pedidosVenda.pedidosVenda.Classes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;


public class Cliente extends Pessoa{
    public double limiteCredito;
    public String cartaoCredito; 

    public double getLimiteCredito() {
        return this.limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getCartaoCredito() {
        return this.cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getContato() {
        return this.Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
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

    public List<Pedido> getPedidos() {
        return this.Pedidos;
    }

    public void setPedidos(List<Pedido> Pedidos) {
        this.Pedidos = Pedidos;
    }
    public String Contato; 
    public boolean status; 
    public List<Pedido> Pedidos; 
    public Cliente(String nome, String data, double limiteCartao, String cartaoCredito,  boolean status, int id, String contado) {
        super(nome, data);
        this.limiteCredito = limiteCartao;
        this.cartaoCredito = cartaoCredito;
        this.Contato = contado;
        this.status = status;
    }

    public boolean validaCartao(){
        String regex = "^[0-9][0-9]{12}(?:[0-9]{3})?$";
        if(this.cartaoCredito.matches(regex)){
            return true;
        }
        return false;
    }
}
