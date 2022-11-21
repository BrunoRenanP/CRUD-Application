package com.produtos.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.crud.exception.NaoEncontradoException;
import com.produtos.crud.modelo.DTO.PedidoDTO;
import com.produtos.crud.modeloEntidade.Pedido;
import com.produtos.crud.modeloEntidade.PedidoItem;
import com.produtos.crud.repository.PedidoRepositorio;

@Service
public class PedidoService {

	@Autowired
	PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	PedidoItemService pedidoItemService;
	
	public PedidoDTO cadastraPedido(PedidoDTO pedidoDTO) {
		Pedido ped = pedidoDTO.converteParaEntidade();
		defineLiquidoProduto(ped.getPedidoItens());
		defineNumeroPedido(ped);
		defineValorTotalPedido(ped);
		pedidoRepositorio.save(ped);
		PedidoDTO retornoDTO = new PedidoDTO(ped);
		return retornoDTO;
	}

	private void defineValorTotalPedido(Pedido ped) {
		double valorTotalPedido = 0.0;
		for (PedidoItem umPedidoItem : ped.getPedidoItens()) {
			valorTotalPedido += umPedidoItem.getProdutoServico().getValorUnitario() * (umPedidoItem.getQuantidade());
		}
		ped.setValorPedido(valorTotalPedido);
	}

	private void defineNumeroPedido(Pedido ped) {
		ped.getPedidoItens().forEach(item -> item.setPedido(ped));
	}

	public List<PedidoDTO> listaPedidos() {
		List<Pedido> pedidoOp = pedidoRepositorio.findAll();
		return new ArrayList<>(pedidoOp.stream()
			.map(PedidoDTO::new)
			.collect(Collectors.toList()));
	}

	public PedidoDTO buscaPedido(UUID id) {
		Optional<Pedido> ped = pedidoRepositorio.findById(id);
		if(ped.isPresent()) {
			Pedido pedido = ped.get();
			PedidoDTO pedDTO = new PedidoDTO(pedido);
			return pedDTO;
		}
		return new PedidoDTO();
		
	}

	public PedidoDTO deletaPedido(UUID id) {
		Optional<Pedido> op = pedidoRepositorio.findById(id);
		if(op.isPresent()) {
			Pedido pedido = op.get();
			PedidoDTO pedDTO = new PedidoDTO(pedido);
			deletaPedidoItem(pedido.getPedidoItens());
			pedidoRepositorio.delete(pedido);
			return pedDTO;
		}else {
			throw new NaoEncontradoException();
		}
	}

	private void deletaPedidoItem(Set<PedidoItem> setPedidoItem) {
		for (PedidoItem umPedidoItem : setPedidoItem) {
			pedidoItemService.deletaPedidoItemPeloId(umPedidoItem.getId());
		}
	}

	public PedidoDTO alteraPedido(PedidoDTO pedidoDTO) {
		Pedido pedido = pedidoDTO.converteParaEntidade();
		defineLiquidoProduto(pedido.getPedidoItens());
		defineValorTotalPedido(pedido);
		pedidoRepositorio.save(pedido);
		PedidoDTO pedAux = new PedidoDTO(pedido);
		return pedAux;
	}
	
	public void defineLiquidoProduto(Set<PedidoItem> pedidoItens) {
		pedidoItens.forEach(umPedItem -> {
			if(umPedItem.getProdutoServico().getEhServico() == 0) {
				aplicaValorComDesconto(umPedItem);
			}
		});
	}

	private void aplicaValorComDesconto(PedidoItem umPedItem) {
		double valorOriginal = umPedItem.getProdutoServico().getValorUnitario();
		double valorLiquido = valorOriginal -  (valorOriginal * 0.1);
		umPedItem.getProdutoServico().setValorUnitario(valorLiquido);
	}

}
