package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Tempo;
import com.example.lojapp.service.TempoService;

@Controller
@RequestMapping("/tempos")
public class TempoController {
    @Autowired
    private TempoService tempoService;

    @GetMapping("")
    public String viewTemposPage(Model model) {
        model.addAttribute("listTempos", tempoService.getAllTempos());
        return "tempo"; // tempo.html na pasta templates
    }

    @GetMapping("/showNewTempoForm")
    public String showNewTempoForm(Model model) {
        Tempo tempo = new Tempo();
        model.addAttribute("tempo", tempo);
        return "new_tempo"; // new_tempo.html na pasta templates
    }

    @PostMapping("/saveTempo")
    public String saveTempo(@ModelAttribute("tempo") Tempo tempo) {
        tempoService.saveOrUpdateTempo(tempo);
        return "redirect:/tempos";
    }

    @GetMapping("/showFormForUpdateTempo/{id}")
    public String showFormForUpdateTempo(@PathVariable(value = "id") int id, Model model) {
        Tempo tempo = tempoService.getTempoById(id).orElse(null);
        model.addAttribute("tempo", tempo);
        return "update_tempo"; // update_tempo.html na pasta templates
    }

    @GetMapping("/deleteTempo/{id}")
    public String deleteTempo(@PathVariable(value = "id") int id) {
        tempoService.deleteTempo(id);
        return "redirect:/tempos";
    }
}