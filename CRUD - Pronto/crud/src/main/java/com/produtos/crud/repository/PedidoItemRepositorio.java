package com.produtos.crud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.crud.modeloEntidade.PedidoItem;

@Repository
public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, UUID>{

}
