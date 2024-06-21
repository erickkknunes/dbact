package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.ProdutoRepository;
import com.example.lojapp.model.Produto;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(int id) {
        return produtoRepository.findById(id);
    }

    public Produto saveOrUpdateProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(int id) {
        produtoRepository.deleteById(id);
    }
}
