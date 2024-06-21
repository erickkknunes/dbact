package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Compra;
import com.example.lojapp.service.CompraService;

@Controller
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("")
    public String viewComprasPage(Model model) {
        model.addAttribute("listCompras", compraService.getAllCompras());
        return "compra"; // compra.html na pasta templates
    }

    @GetMapping("/showNewCompraForm")
    public String showNewCompraForm(Model model) {
        Compra compra = new Compra();
        model.addAttribute("compra", compra);
        return "new_compra"; // new_compra.html na pasta templates
    }

    @PostMapping("/saveCompra")
    public String saveCompra(@ModelAttribute("compra") Compra compra) {
        compraService.saveOrUpdateCompra(compra);
        return "redirect:/compras";
    }

    @GetMapping("/showFormForUpdateCompra/{id}")
    public String showFormForUpdateCompra(@PathVariable(value = "id") int id, Model model) {
        Compra compra = compraService.getCompraById(id).orElse(null);
        model.addAttribute("compra", compra);
        return "update_compra"; // update_compra.html na pasta templates
    }

    @GetMapping("/deleteCompra/{id}")
    public String deleteCompra(@PathVariable(value = "id") int id) {
        compraService.deleteCompra(id);
        return "redirect:/compras";
    }
}
