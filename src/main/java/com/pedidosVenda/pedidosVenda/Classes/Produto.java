package com.pedidosVenda.pedidosVenda.Classes;

public class Produto {
    private String nomeProduto; 
    private double preco; 
    private int quantidadeDisponivel; 

    public int consultaQuantidadeProduto(){
        return this.quantidadeDisponivel;
    }

}
