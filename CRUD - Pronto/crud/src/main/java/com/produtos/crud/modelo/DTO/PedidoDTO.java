package com.produtos.crud.modelo.DTO;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.produtos.crud.modeloEntidade.Pedido;
import com.produtos.crud.modeloEntidade.PedidoItem;

public class PedidoDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private Long numPed;
	private double valorPedido;
	private Set<PedidoItemDTO> pedidoItens;
	
	public PedidoDTO() {
	}
	
	public PedidoDTO(UUID id, Long numPed, double valorPedido, Set<PedidoItemDTO> pedidoItens) {
		super();
		this.id = id;
		this.numPed = numPed;
		this.valorPedido = valorPedido;
		this.pedidoItens = pedidoItens;
	}

	public PedidoDTO(Pedido pedido) {
		
		this.id = pedido.getId();
		this.numPed = pedido.getNumPed();
		this.valorPedido = pedido.getValorPedido();
		this.pedidoItens = pedido.getPedidoItens().stream()
					.map(PedidoItemDTO::new)
					.collect(Collectors.toSet());
	}
	
	public UUID getId() {
		return id;
	}
	public Long getNumPed() {
		return numPed;
	}
	public double getValorPedido() {
		return valorPedido;
	}
	public Set<PedidoItemDTO> getPedidoItens() {
		return pedidoItens;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setNumPed(Long numPed) {
		this.numPed = numPed;
	}
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public void setPedidoItens(Set<PedidoItemDTO> pedidoItens) {
		this.pedidoItens = pedidoItens;
	}
	
	public Pedido converteParaEntidade() {
		Pedido ped = new Pedido(this.getId(), this.getNumPed(), this.getValorPedido());
		ped.setPedidoItens(this.getPedidoItens().stream()
				.map(PedidoItemDTO::converteParaEntidade)
				.collect(Collectors.toSet()));
		for (PedidoItem pedidoItem : ped.getPedidoItens()) {
			pedidoItem.setPedido(ped);
		}
		return ped;
	}
	
}
