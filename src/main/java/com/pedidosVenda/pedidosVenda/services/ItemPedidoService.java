package com.pedidosVenda.pedidosVenda.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pedidosVenda.pedidosVenda.models.ItemPedidoModel;
import com.pedidosVenda.pedidosVenda.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
    //to make dependency injection
    @Autowired
    private ItemPedidoRepository ItemPedidoRepository;

    @Transactional
    public ItemPedidoModel save(ItemPedidoModel ItemPedidoModel) {
        return ItemPedidoRepository.save(ItemPedidoModel);
    }

    public List<ItemPedidoModel> findAll(){
        return ItemPedidoRepository.findAll();
    }

    public Optional<ItemPedidoModel> findById(UUID id) {
        return ItemPedidoRepository.findById(id);
    }

    @Transactional
    public UUID delete(ItemPedidoModel ItemPedidoModel) {
        UUID id = ItemPedidoModel.getId();
        ItemPedidoRepository.delete(ItemPedidoModel);
        return id;
    }
    

}
