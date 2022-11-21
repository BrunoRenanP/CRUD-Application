package com.produtos.crud.modeloEntidade;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.produtos.crud.modelo.DTO.PedidoDTO;
import com.produtos.crud.modelo.DTO.PedidoItemDTO;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name= "PED_NUMPED", nullable = false, unique = true)
	private Long numPed;
	
	@Column(name= "PED_VALPED", nullable = false)
	private double valorPedido;
	
	@OneToMany(targetEntity = PedidoItem.class, cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
	private Set<PedidoItem> pedidoItens;
	
	public Pedido() {
	}

	public Pedido(Long numPed, double valorPedido, Set<PedidoItem> pedidoItens) {
		this.numPed = numPed;
		this.valorPedido = valorPedido;
		this.pedidoItens = pedidoItens;
	}

	public Pedido(UUID id, Long numPed, double valorPedido, Set<PedidoItem> pedidoItens) {
		this.id = id;
		this.numPed = numPed;
		this.valorPedido = valorPedido;
		this.pedidoItens = pedidoItens;
	}

	public Pedido(UUID id, Long numPed, double valorPedido) {
		this.id = id;
		this.numPed = numPed;
		this.valorPedido = valorPedido;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getNumPed() {
		return numPed;
	}

	public double getValorPedido() {
		return valorPedido;
	}

	public Set<PedidoItem> getPedidoItens() {
		return pedidoItens;
	}

	public void setNumPed(Long numPed) {
		this.numPed = numPed;
	}

	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public void setPedidoItens(Set<PedidoItem> pedidoItens) {
		this.pedidoItens = pedidoItens;
	}
	
}

