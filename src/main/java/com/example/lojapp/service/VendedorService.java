package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.VendedorRepository;
import com.example.lojapp.model.Vendedor;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> getAllVendedores() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> getVendedorById(int id) {
        return vendedorRepository.findById(id);
    }

    public Vendedor saveOrUpdateVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public void deleteVendedor(int id) {
        vendedorRepository.deleteById(id);
    }
}