package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}
