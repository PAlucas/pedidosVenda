package com.pedidosVenda.pedidosVenda.Classes;

import java.util.Date;

public class Pessoa {
    protected String nome;
    protected Date dataNasc;

    public Pessoa(String nome, Date data){
        this.nome = nome;
        this.dataNasc = data;
    }

    public int calcularIdade(){
        return 0;

    }
}
