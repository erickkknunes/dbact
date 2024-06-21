package com.example.lojapp.controller;

import com.example.lojapp.model.Venda;
import com.example.lojapp.service.ClienteService;
import com.example.lojapp.service.LojaService;
import com.example.lojapp.service.ProdutoService;
import com.example.lojapp.service.TempoService;
import com.example.lojapp.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private TempoService tempoService;

    @Autowired
    private LojaService lojaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("")
    public String viewVendasPage(Model model) {
        model.addAttribute("listVendas", vendaService.getAllVendas());
        return "venda"; // venda.html na pasta templates
    }

    @GetMapping("/showNewVendaForm")
    public String showNewVendaForm(Model model) {
        Venda venda = new Venda();
        model.addAttribute("venda", venda);

        // Carregar listas para os dropdowns
        model.addAttribute("listaTempos", tempoService.getAllTempos());
        model.addAttribute("listaLojas", lojaService.getAllLojas());
        model.addAttribute("listaClientes", clienteService.getAllClientes());
        model.addAttribute("listaProdutos", produtoService.getAllProdutos());

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

        // Carregar listas para os dropdowns
        model.addAttribute("listaTempos", tempoService.getAllTempos());
        model.addAttribute("listaLojas", lojaService.getAllLojas());
        model.addAttribute("listaClientes", clienteService.getAllClientes());
        model.addAttribute("listaProdutos", produtoService.getAllProdutos());

        return "update_venda"; // update_venda.html na pasta templates
    }

    @GetMapping("/deleteVenda/{id}")
    public String deleteVenda(@PathVariable(value = "id") int id) {
        vendaService.deleteVenda(id);
        return "redirect:/vendas";
    }
}
