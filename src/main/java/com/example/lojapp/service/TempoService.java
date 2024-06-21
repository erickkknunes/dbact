package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.TempoRepository;
import com.example.lojapp.model.Tempo;

import java.util.List;
import java.util.Optional;

@Service
public class TempoService {
    @Autowired
    private TempoRepository tempoRepository;

    public List<Tempo> getAllTempos() {
        return tempoRepository.findAll();
    }

    public Optional<Tempo> getTempoById(int id) {
        return tempoRepository.findById(id);
    }

    public Tempo saveOrUpdateTempo(Tempo tempo) {
        return tempoRepository.save(tempo);
    }

    public void deleteTempo(int id) {
        tempoRepository.deleteById(id);
    }
}