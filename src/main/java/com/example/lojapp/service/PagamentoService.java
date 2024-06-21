package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.PagamentoRepository;
import com.example.lojapp.model.Pagamento;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> getPagamentoById(int id) {
        return pagamentoRepository.findById(id);
    }

    public Pagamento saveOrUpdatePagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public void deletePagamento(int id) {
        pagamentoRepository.deleteById(id);
    }
}