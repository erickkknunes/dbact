package com.example.lojapp.controller;

import com.example.lojapp.model.Cliente;
import com.example.lojapp.model.Pedido;
import com.example.lojapp.model.Tempo;
import com.example.lojapp.model.Vendedor;
import com.example.lojapp.service.ClienteService;
import com.example.lojapp.service.PedidoService;
import com.example.lojapp.service.TempoService;
import com.example.lojapp.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private TempoService tempoService;

    @GetMapping("")
    public String viewPedidosPage(Model model) {
        model.addAttribute("listPedidos", pedidoService.getAllPedidos());
        return "pedido"; // pedido.html na pasta templates
    }

    @GetMapping("/showNewPedidoForm")
    public String showNewPedidoForm(Model model) {
        Pedido pedido = new Pedido();
        model.addAttribute("pedido", pedido);

        // Carregar listas para os dropdowns
        model.addAttribute("listaClientes", clienteService.getAllClientes());
        model.addAttribute("listaVendedores", vendedorService.getAllVendedores());
        model.addAttribute("listaTempos", tempoService.getAllTempos());

        return "new_pedido"; // new_pedido.html na pasta templates
    }

    @PostMapping("/savePedido")
    public String savePedido(@ModelAttribute("pedido") Pedido pedido) {
        pedidoService.saveOrUpdatePedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/showFormForUpdatePedido/{id}")
    public String showFormForUpdatePedido(@PathVariable(value = "id") int id, Model model) {
        Pedido pedido = pedidoService.getPedidoById(id).orElse(null);
        model.addAttribute("pedido", pedido);

        // Carregar listas para os dropdowns
        model.addAttribute("listaClientes", clienteService.getAllClientes());
        model.addAttribute("listaVendedores", vendedorService.getAllVendedores());
        model.addAttribute("listaTempos", tempoService.getAllTempos());

        return "update_pedido"; // update_pedido.html na pasta templates
    }

    @GetMapping("/deletePedido/{id}")
    public String deletePedido(@PathVariable(value = "id") int id) {
        pedidoService.deletePedido(id);
        return "redirect:/pedidos";
    }
}
