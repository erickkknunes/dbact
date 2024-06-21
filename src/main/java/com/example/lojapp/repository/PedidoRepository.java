package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
