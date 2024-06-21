package com.example.lojapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.lojapp.model.ItemPedido;
import com.example.lojapp.service.ItemPedidoService;

@Controller
@RequestMapping("/itempedidos")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping("")
    public String viewItemPedidosPage(Model model) {
        model.addAttribute("listItemPedidos", itemPedidoService.getAllItemPedidos());
        return "itempedido"; // itempedido.html na pasta templates
    }

    @GetMapping("/showNewItemPedidoForm")
    public String showNewItemPedidoForm(Model model) {
        ItemPedido itemPedido = new ItemPedido();
        model.addAttribute("itemPedido", itemPedido);
        return "new_itempedido"; // new_itempedido.html na pasta templates
    }

    @PostMapping("/saveItemPedido")
    public String saveItemPedido(@ModelAttribute("itemPedido") ItemPedido itemPedido) {
        itemPedidoService.saveOrUpdateItemPedido(itemPedido);
        return "redirect:/itempedidos";
    }

    @GetMapping("/showFormForUpdateItemPedido/{id}")
    public String showFormForUpdateItemPedido(@PathVariable(value = "id") int id, Model model) {
        ItemPedido itemPedido = itemPedidoService.getItemPedidoById(id).orElse(null);
        model.addAttribute("itemPedido", itemPedido);
        return "update_itempedido"; // update_itempedido.html na pasta templates
    }

    @GetMapping("/deleteItemPedido/{id}")
    public String deleteItemPedido(@PathVariable(value = "id") int id) {
        itemPedidoService.deleteItemPedido(id);
        return "redirect:/itempedidos";
    }
}