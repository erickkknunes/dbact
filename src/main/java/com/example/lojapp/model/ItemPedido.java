package com.example.lojapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iditempedido;

    @ManyToOne
    @JoinColumn(name = "idpedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;

    private int quantidade;
    private BigDecimal valorUnit;

    // Getters e setters
    public int getIditempedido() {
        return iditempedido;
    }

    public void setIditempedido(int iditempedido) {
        this.iditempedido = iditempedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public BigDecimal getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(BigDecimal valorUnit) {
        this.valorUnit = valorUnit;
    }
}
