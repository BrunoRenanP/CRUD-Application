package com.produtos.crud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.crud.modeloEntidade.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, UUID>{

}
