package com.example.lojapp.controller;

import com.example.lojapp.model.ItemPedido;
import com.example.lojapp.model.Pedido;
import com.example.lojapp.model.Produto;
import com.example.lojapp.service.ItemPedidoService;
import com.example.lojapp.service.PedidoService;
import com.example.lojapp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/itempedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("")
    public String viewItemPedidosPage(Model model) {
        model.addAttribute("listItemPedidos", itemPedidoService.getAllItemPedidos());
        return "itempedido";
    }

    @GetMapping("/showNewItemPedidoForm")
    public String showNewItemPedidoForm(Model model) {
        ItemPedido itemPedido = new ItemPedido();
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        List<Produto> produtos = produtoService.getAllProdutos();
        model.addAttribute("itemPedido", itemPedido);
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("produtos", produtos);
        return "new_itempedido";
    }

    @PostMapping("/saveItemPedido")
    public String saveItemPedido(@ModelAttribute("itemPedido") ItemPedido itemPedido) {
        itemPedidoService.saveOrUpdateItemPedido(itemPedido);
        return "redirect:/itempedidos";
    }

    @GetMapping("/showFormForUpdateItemPedido/{id}")
    public String showFormForUpdateItemPedido(@PathVariable(value = "id") int id, Model model) {
        ItemPedido itemPedido = itemPedidoService.getItemPedidoById(id).orElse(null);
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        List<Produto> produtos = produtoService.getAllProdutos();
        model.addAttribute("itemPedido", itemPedido);
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("produtos", produtos);
        return "update_itempedido";
    }

    @GetMapping("/deleteItemPedido/{id}")
    public String deleteItemPedido(@PathVariable(value = "id") int id) {
        itemPedidoService.deleteItemPedido(id);
        return "redirect:/itempedidos";
    }
}