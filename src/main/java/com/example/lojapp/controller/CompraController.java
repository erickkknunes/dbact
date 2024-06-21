package com.example.lojapp.controller;

import com.example.lojapp.model.Compra;
import com.example.lojapp.service.CompraService;
import com.example.lojapp.service.FornecedorService;
import com.example.lojapp.service.LojaService;
import com.example.lojapp.service.ProdutoService;
import com.example.lojapp.service.TempoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private TempoService tempoService;

    @Autowired
    private LojaService lojaService;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("")
    public String viewComprasPage(Model model) {
        model.addAttribute("listCompras", compraService.getAllCompras());
        return "compra"; // compra.html na pasta templates
    }

    @GetMapping("/showNewCompraForm")
    public String showNewCompraForm(Model model) {
        Compra compra = new Compra();
        model.addAttribute("compra", compra);

        // Carregar listas para os dropdowns
        model.addAttribute("listaTempos", tempoService.getAllTempos());
        model.addAttribute("listaLojas", lojaService.getAllLojas());
        model.addAttribute("listaFornecedores", fornecedorService.getAllFornecedores());
        model.addAttribute("listaProdutos", produtoService.getAllProdutos());

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

        // Carregar listas para os dropdowns
        model.addAttribute("listaTempos", tempoService.getAllTempos());
        model.addAttribute("listaLojas", lojaService.getAllLojas());
        model.addAttribute("listaFornecedores", fornecedorService.getAllFornecedores());
        model.addAttribute("listaProdutos", produtoService.getAllProdutos());

        return "update_compra"; // update_compra.html na pasta templates
    }

    @GetMapping("/deleteCompra/{id}")
    public String deleteCompra(@PathVariable(value = "id") int id) {
        compraService.deleteCompra(id);
        return "redirect:/compras";
    }
}
