package com.pedidosVenda.pedidosVenda.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pedidosVenda.pedidosVenda.models.ClienteModel;
import com.pedidosVenda.pedidosVenda.repositories.ClienteRepository;

@Service
public class ClienteService {
    //to make dependency injection
    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public UUID delete(ClienteModel clienteModel) {
        UUID id = clienteModel.getId();
        clienteRepository.delete(clienteModel);
        return id;
    }
    

}
