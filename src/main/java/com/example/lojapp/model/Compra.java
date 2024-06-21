package com.example.lojapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcompra;

    @ManyToOne
    @JoinColumn(name = "idtempo")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tempo tempo;

    @ManyToOne
    @JoinColumn(name = "idloja")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Loja loja;

    @ManyToOne
    @JoinColumn(name = "idfornecedor")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "idproduto")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produto produto;

    private int quantidade;
    private BigDecimal valor;

    // Getters e setters
    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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
