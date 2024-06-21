package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.Vendedor;
import com.example.lojapp.service.VendedorService;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {
    @Autowired
    private VendedorService vendedorService;

    @GetMapping("")
    public String viewVendedoresPage(Model model) {
        model.addAttribute("listVendedores", vendedorService.getAllVendedores());
        return "vendedor"; // vendedor.html na pasta templates
    }

    @GetMapping("/showNewVendedorForm")
    public String showNewVendedorForm(Model model) {
        Vendedor vendedor = new Vendedor();
        model.addAttribute("vendedor", vendedor);
        return "new_vendedor"; // new_vendedor.html na pasta templates
    }

    @PostMapping("/saveVendedor")
    public String saveVendedor(@ModelAttribute("vendedor") Vendedor vendedor) {
        vendedorService.saveOrUpdateVendedor(vendedor);
        return "redirect:/vendedores";
    }

    @GetMapping("/showFormForUpdateVendedor/{id}")
    public String showFormForUpdateVendedor(@PathVariable(value = "id") int id, Model model) {
        Vendedor vendedor = vendedorService.getVendedorById(id).orElse(null);
        model.addAttribute("vendedor", vendedor);
        return "update_vendedor"; // update_vendedor.html na pasta templates
    }

    @GetMapping("/deleteVendedor/{id}")
    public String deleteVendedor(@PathVariable(value = "id") int id) {
        vendedorService.deleteVendedor(id);
        return "redirect:/vendedores";
    }
}