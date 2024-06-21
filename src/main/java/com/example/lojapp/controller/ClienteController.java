package com.example.lojapp.controller;

import com.example.lojapp.model.Cliente;
import com.example.lojapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String viewClientesPage(Model model) {
        model.addAttribute("listClientes", clienteService.getAllClientes());
        return "cliente";
    }

    @GetMapping("/showNewClienteForm")
    public String showNewClienteForm(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "new_cliente";
    }

    @PostMapping("/saveCliente")
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.saveOrUpdateCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/showFormForUpdateCliente/{id}")
    public String showFormForUpdateCliente(@PathVariable(value = "id") int id, Model model) {
        Cliente cliente = clienteService.getClienteById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "update_cliente";
    }

    @GetMapping("/deleteCliente/{id}")
    public String deleteCliente(@PathVariable(value = "id") int id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes";
    }
}
