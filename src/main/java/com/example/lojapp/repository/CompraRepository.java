package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
