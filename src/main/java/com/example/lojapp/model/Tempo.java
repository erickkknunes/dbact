package com.example.lojapp.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Tempo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtempo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date datacompleta;

    private int mes;
    private int ano;

    // Getters e setters
    public int getIdtempo() {
        return idtempo;
    }

    public void setIdtempo(int idtempo) {
        this.idtempo = idtempo;
    }

    public Date getDatacompleta() {
        return datacompleta;
    }

    public void setDatacompleta(Date datacompleta) {
        this.datacompleta = datacompleta;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
