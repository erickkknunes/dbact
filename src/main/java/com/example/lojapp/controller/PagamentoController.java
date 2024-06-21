package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Pagamento;
import com.example.lojapp.service.PagamentoService;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("")
    public String viewPagamentosPage(Model model) {
        model.addAttribute("listPagamentos", pagamentoService.getAllPagamentos());
        return "pagamento"; // pagamento.html na pasta templates
    }

    @GetMapping("/showNewPagamentoForm")
    public String showNewPagamentoForm(Model model) {
        Pagamento pagamento = new Pagamento();
        model.addAttribute("pagamento", pagamento);
        return "new_pagamento"; // new_pagamento.html na pasta templates
    }

    @PostMapping("/savePagamento")
    public String savePagamento(@ModelAttribute("pagamento") Pagamento pagamento) {
        pagamentoService.saveOrUpdatePagamento(pagamento);
        return "redirect:/pagamentos";
    }

    @GetMapping("/showFormForUpdatePagamento/{id}")
    public String showFormForUpdatePagamento(@PathVariable(value = "id") int id, Model model) {
        Pagamento pagamento = pagamentoService.getPagamentoById(id).orElse(null);
        model.addAttribute("pagamento", pagamento);
        return "update_pagamento"; // update_pagamento.html na pasta templates
    }

    @GetMapping("/deletePagamento/{id}")
    public String deletePagamento(@PathVariable(value = "id") int id) {
        pagamentoService.deletePagamento(id);
        return "redirect:/pagamentos";
    }
}