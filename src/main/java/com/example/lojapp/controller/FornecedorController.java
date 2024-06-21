package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Fornecedor;
import com.example.lojapp.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("")
    public String viewHomePage(Model model) {
        model.addAttribute("listFornecedores", fornecedorService.getAllFornecedores());
        return "fornecedor";
    }

    @GetMapping("/showNewFornecedorForm")
    public String showNewFornecedorForm(Model model) {
        Fornecedor fornecedor = new Fornecedor();
        model.addAttribute("fornecedor", fornecedor);
        return "new_fornecedor";
    }

    @PostMapping("/saveFornecedor")
    public String saveFornecedor(@ModelAttribute("fornecedor") Fornecedor fornecedor) {
        fornecedorService.saveOrUpdateFornecedor(fornecedor);
        return "redirect:/fornecedores";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Fornecedor fornecedor = fornecedorService.getFornecedorById(id).orElse(null);
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor/update_fornecedor";
    }

    @GetMapping("/deleteFornecedor/{id}")
    public String deleteFornecedor(@PathVariable(value = "id") int id) {
        fornecedorService.deleteFornecedor(id);
        return "redirect:/fornecedores";
    }
}
