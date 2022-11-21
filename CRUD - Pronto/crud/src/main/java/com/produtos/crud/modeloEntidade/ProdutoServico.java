package com.produtos.crud.modeloEntidade;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO_SERVICO")
public class ProdutoServico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "POS_DESCRI", nullable = false)
	private String descricao;
	
	@Column(name = "POS_VALUNI", nullable = false)
	private double valorUnitario;

	@Column(name = "POS_EHSERVICO", nullable = false)
	private int ehServico = 0;

	
	public ProdutoServico() {}

	public ProdutoServico(UUID id, String descricao, double valorUnitario, int ehServico) {
		this.id = id;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.ehServico = ehServico;
	}

	public ProdutoServico(String descricao, double valorUnitario, int ehServico) {
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.ehServico = ehServico;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getEhServico() {
		return ehServico;
	}

	public void setEhServico(int ehServico) {
		this.ehServico = ehServico;
	}
	
}
