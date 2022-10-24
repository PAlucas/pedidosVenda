package com.pedidosVenda.pedidosVenda.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pedidosVenda.pedidosVenda.models.PedidoModel;
import com.pedidosVenda.pedidosVenda.repositories.PedidoRepository;

@Service
public class PedidoService {
    //to make dependency injection
    @Autowired
    private PedidoRepository PedidoRepository;

    @Transactional
    public PedidoModel save(PedidoModel PedidoModel) {
        return PedidoRepository.save(PedidoModel);
    }


    public List<PedidoModel> findAll(){
        return PedidoRepository.findAll();
    }

    public Optional<PedidoModel> findById(UUID id) {
        return PedidoRepository.findById(id);
    }

    @Transactional
    public UUID delete(PedidoModel PedidoModel) {
        UUID id = PedidoModel.getId();
        PedidoRepository.delete(PedidoModel);
        return id;
    }
    

}
