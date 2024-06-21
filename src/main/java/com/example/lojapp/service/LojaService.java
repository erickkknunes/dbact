package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.LojaRepository;
import com.example.lojapp.model.Loja;

import java.util.List;
import java.util.Optional;

@Service
public class LojaService {
    @Autowired
    private LojaRepository lojaRepository;

    public List<Loja> getAllLojas() {
        return lojaRepository.findAll();
    }

    public Optional<Loja> getLojaById(int id) {
        return lojaRepository.findById(id);
    }

    public Loja saveOrUpdateLoja(Loja loja) {
        return lojaRepository.save(loja);
    }

    public void deleteLoja(int id) {
        lojaRepository.deleteById(id);
    }
}
