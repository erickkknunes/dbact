package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.VendaRepository;
import com.example.lojapp.model.Venda;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> getVendaById(int id) {
        return vendaRepository.findById(id);
    }

    public Venda saveOrUpdateVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deleteVenda(int id) {
        vendaRepository.deleteById(id);
    }
}