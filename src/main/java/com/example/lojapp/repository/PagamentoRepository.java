package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
