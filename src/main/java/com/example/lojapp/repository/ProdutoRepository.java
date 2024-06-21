package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
