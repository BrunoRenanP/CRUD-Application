package com.produtos.crud.modelo.DTO;

import java.io.Serializable;
import java.util.UUID;

import com.produtos.crud.modeloEntidade.Pedido;
import com.produtos.crud.modeloEntidade.PedidoItem;

public class PedidoItemDTO implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private Long quantidade;
	private ProdutoServicoDTO produtoServico;
	
	public PedidoItemDTO(){
		
	}
	
	public PedidoItemDTO(PedidoItem pedidoItem){
		this.id = pedidoItem.getId();
		this.quantidade = pedidoItem.getQuantidade();
		this.produtoServico = new ProdutoServicoDTO(pedidoItem.getProdutoServico());
	}
	
	public UUID getId() {
		return id;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public ProdutoServicoDTO getProdutoServico() {
		return produtoServico;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public void setProdutoServico(ProdutoServicoDTO produtoServico) {
		this.produtoServico = produtoServico;
	}
	
	public PedidoItem converteParaEntidade() {
		PedidoItem ped = new PedidoItem(this.getId(), this.getQuantidade(), this.getProdutoServico().converteParaEntidade());
		return ped;
	}
	
}

