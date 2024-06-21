package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
