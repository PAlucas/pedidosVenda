package com.pedidosVenda.pedidosVenda.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pedidosVenda.pedidosVenda.models.ProdutoModel;
import com.pedidosVenda.pedidosVenda.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    //to make dependency injection
    @Autowired
    private ProdutoRepository ProdutoRepository;

    @Transactional
    public ProdutoModel save(ProdutoModel ProdutoModel) {
        return ProdutoRepository.save(ProdutoModel);
    }

    public List<ProdutoModel> findAll(){
        return ProdutoRepository.findAll();
    }

    public Optional<ProdutoModel> findById(UUID id) {
        return ProdutoRepository.findById(id);
    }

    @Transactional
    public UUID delete(ProdutoModel ProdutoModel) {
        UUID id = ProdutoModel.getId();
        ProdutoRepository.delete(ProdutoModel);
        return id;
    }
    

}
