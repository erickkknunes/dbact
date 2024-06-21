package com.example.lojapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojapp.model.Tempo;

public interface TempoRepository extends JpaRepository<Tempo, Integer> {
}
