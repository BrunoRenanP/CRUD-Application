package com.produtos.crud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.crud.modeloEntidade.ProdutoServico;

@Repository
public interface ProdutoServicoRepositorio extends JpaRepository<ProdutoServico, UUID>{

}
