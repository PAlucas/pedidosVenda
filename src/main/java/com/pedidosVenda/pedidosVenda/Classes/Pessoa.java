package com.pedidosVenda.pedidosVenda.Classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Pessoa {
    public String nome;
    public String dataNasc;

    public Pessoa(String nome, String data){
        this.nome = nome;
        this.dataNasc = data;
    }

    public long calcularIdade(){
        String[] dataDecomposto = dataNasc.split("-");
        LocalDate startDate = LocalDate.of(Integer.parseInt(dataDecomposto[0]),Integer.parseInt(dataDecomposto[1]), Integer.parseInt(dataDecomposto[2]));
        LocalDate endDate = LocalDate.now();
        System.out.print(startDate);
        long year = ChronoUnit.YEARS.between(startDate, endDate);

        return year;
    }

    public void setDataNasc(String data){
        this.dataNasc = data;
    }

    public String getDataNasc(){
        return this.dataNasc;
    }
}
