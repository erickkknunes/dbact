package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.FornecedorRepository;
import com.example.lojapp.model.Fornecedor;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> getFornecedorById(int id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor saveOrUpdateFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void deleteFornecedor(int id) {
        fornecedorRepository.deleteById(id);
    }
}
