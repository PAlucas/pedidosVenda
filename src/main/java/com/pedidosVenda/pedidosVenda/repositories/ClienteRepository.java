package com.pedidosVenda.pedidosVenda.repositories;

import com.pedidosVenda.pedidosVenda.models.ClienteModel;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface for decouple purpose
@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID>{

}
