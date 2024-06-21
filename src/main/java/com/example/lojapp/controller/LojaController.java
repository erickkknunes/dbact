package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Loja;
import com.example.lojapp.service.LojaService;

@Controller
@RequestMapping("/lojas")
public class LojaController {
    @Autowired
    private LojaService lojaService;

    @GetMapping("")
    public String viewHomePage(Model model) {
        model.addAttribute("listLojas", lojaService.getAllLojas());
        return "loja";
    }

    @GetMapping("/showNewLojaForm")
    public String showNewLojaForm(Model model) {
        Loja loja = new Loja();
        model.addAttribute("loja", loja);
        return "new_loja";
    }

    @PostMapping("/saveLoja")
    public String saveLoja(@ModelAttribute("loja") Loja loja) {
        lojaService.saveOrUpdateLoja(loja);
        return "redirect:/lojas";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Loja loja = lojaService.getLojaById(id).orElse(null);
        model.addAttribute("loja", loja);
        return "update_loja";
    }

    @GetMapping("/deleteLoja/{id}")
    public String deleteLoja(@PathVariable(value = "id") int id) {
        lojaService.deleteLoja(id);
        return "redirect:/lojas";
    }
}
