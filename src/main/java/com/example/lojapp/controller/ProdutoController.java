package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Produto;
import com.example.lojapp.service.ProdutoService;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public String viewHomePage(Model model) {
        model.addAttribute("listProdutos", produtoService.getAllProdutos());
        return "produto";
    }

    @GetMapping("/showNewProdutoForm")
    public String showNewProdutoForm(Model model) {
        Produto produto = new Produto();
        model.addAttribute("produto", produto);
        return "new_produto";
    }

    @PostMapping("/saveProduto")
    public String saveProduto(@ModelAttribute("produto") Produto produto) {
        produtoService.saveOrUpdateProduto(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Produto produto = produtoService.getProdutoById(id).orElse(null);
        model.addAttribute("produto", produto);
        return "update_produto";
    }

    @GetMapping("/deleteProduto/{id}")
    public String deleteProduto(@PathVariable(value = "id") int id) {
        produtoService.deleteProduto(id);
        return "redirect:/produtos";
    }
}
