package com.pedidosVenda.pedidosVenda.repositories;

import com.pedidosVenda.pedidosVenda.models.ItemPedidoModel;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface for decouple purpose
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, UUID>{

}
