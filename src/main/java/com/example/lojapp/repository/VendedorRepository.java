package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}
