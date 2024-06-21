package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.CompraRepository;
import com.example.lojapp.model.Compra;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    public Optional<Compra> getCompraById(int id) {
        return compraRepository.findById(id);
    }

    public Compra saveOrUpdateCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public void deleteCompra(int id) {
        compraRepository.deleteById(id);
    }
}
