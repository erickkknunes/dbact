package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
