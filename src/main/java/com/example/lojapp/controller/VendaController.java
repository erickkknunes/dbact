package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Venda;
import com.example.lojapp.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @GetMapping("")
    public String viewVendasPage(Model model) {
        model.addAttribute("listVendas", vendaService.getAllVendas());
        return "venda"; // venda.html na pasta templates
    }

    @GetMapping("/showNewVendaForm")
    public String showNewVendaForm(Model model) {
        Venda venda = new Venda();
        model.addAttribute("venda", venda);
        return "new_venda"; // new_venda.html na pasta templates
    }

    @PostMapping("/saveVenda")
    public String saveVenda(@ModelAttribute("venda") Venda venda) {
        vendaService.saveOrUpdateVenda(venda);
        return "redirect:/vendas";
    }

    @GetMapping("/showFormForUpdateVenda/{id}")
    public String showFormForUpdateVenda(@PathVariable(value = "id") int id, Model model) {
        Venda venda = vendaService.getVendaById(id).orElse(null);
        model.addAttribute("venda", venda);
        return "update_venda"; // update_venda.html na pasta templates
    }

    @GetMapping("/deleteVenda/{id}")
    public String deleteVenda(@PathVariable(value = "id") int id) {
        vendaService.deleteVenda(id);
        return "redirect:/vendas";
    }
}