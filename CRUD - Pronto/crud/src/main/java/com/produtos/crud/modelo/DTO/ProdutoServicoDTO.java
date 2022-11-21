package com.produtos.crud.modelo.DTO;

import java.io.Serializable;
import java.util.UUID;

import com.produtos.crud.modeloEntidade.ProdutoServico;

public class ProdutoServicoDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private String descricao;
	private double valorUnitario;
	private int ehServico = 0;
	
	public ProdutoServicoDTO () {
		
	}
	
	public ProdutoServicoDTO (UUID id, String descricao, double valorUnitario, int ehServico) {
		this.id = id;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.ehServico = ehServico;
	}
	
	public ProdutoServicoDTO(ProdutoServico produtoServico) {
		this.id = produtoServico.getId();
		this.descricao = produtoServico.getDescricao();
		this.valorUnitario = produtoServico.getValorUnitario();
		this.ehServico = produtoServico.getEhServico();
	}

	public UUID getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public int getEhServico() {
		return ehServico;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public void setEhServico(int ehServico) {
		this.ehServico = ehServico;
	}
	
	public ProdutoServico converteParaEntidade() {
		ProdutoServico prod = new ProdutoServico(this.id, this.descricao, this.valorUnitario, this.ehServico);
		return prod;
	}
	
	
}
