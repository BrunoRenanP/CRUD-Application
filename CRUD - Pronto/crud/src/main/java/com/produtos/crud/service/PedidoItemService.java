package com.produtos.crud.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.crud.modelo.DTO.PedidoItemDTO;
import com.produtos.crud.modeloEntidade.PedidoItem;
import com.produtos.crud.repository.PedidoItemRepositorio;

@Service
public class PedidoItemService {
	
	@Autowired
	PedidoItemRepositorio pedidoItemRepositorio;
	
	public PedidoItemDTO deletaPedidoItemPeloId(UUID id) {
		Optional<PedidoItem> pedItem = pedidoItemRepositorio.findById(id);
		PedidoItem pedidoItem = pedItem.get();
		pedidoItemRepositorio.delete(pedidoItem);
		PedidoItemDTO ped = new PedidoItemDTO(pedidoItem);
		return ped;
	}
	

}
