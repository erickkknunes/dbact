package com.example.lojapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvenda;

    @ManyToOne
    @JoinColumn(name = "idtempo")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tempo tempo;

    @ManyToOne
    @JoinColumn(name = "idloja")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Loja loja;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idproduto")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produto produto;

    private int quantidade;
    private BigDecimal valor;

    // Getters e setters
    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
