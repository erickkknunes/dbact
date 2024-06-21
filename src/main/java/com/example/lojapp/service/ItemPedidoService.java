package com.example.lojapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lojapp.repository.ItemPedidoRepository;
import com.example.lojapp.model.ItemPedido;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItemPedidos() {
        return itemPedidoRepository.findAll();
    }

    public Optional<ItemPedido> getItemPedidoById(int id) {
        return itemPedidoRepository.findById(id);
    }

    public ItemPedido saveOrUpdateItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public void deleteItemPedido(int id) {
        itemPedidoRepository.deleteById(id);
    }
}