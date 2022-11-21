package com.produtos.crud.modeloEntidade;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDIDO_ITEM")
@SequenceGenerator(name = "TPI_ID", sequenceName = "TPI_ID")
public class PedidoItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "TPI_QTDPROD", nullable = false)
	private Long quantidade;
	
	@JoinColumn(name = "TPI_POSID", nullable = false)
	@ManyToOne(targetEntity = ProdutoServico.class, fetch = FetchType.LAZY)
	private ProdutoServico produtoServico;
	
	@JoinColumn(name = "TPI_PEDID", nullable = false)
	@ManyToOne(targetEntity = Pedido.class, fetch = FetchType.LAZY)
	private Pedido pedido;
	
	
	public PedidoItem(Long quantidade, ProdutoServico produtoServico, Pedido pedido) {
		super();
		this.quantidade = quantidade;
		this.produtoServico = produtoServico;
		this.pedido = pedido;
	}

	public PedidoItem() {}
	
	public PedidoItem(UUID id, Long quantidade, ProdutoServico produtoServico, Pedido pedido) {
		this.id = id;
		this.quantidade = quantidade;
		this.produtoServico = produtoServico;
		this.pedido = pedido;
	}

	public PedidoItem(UUID id, Long quantidade, ProdutoServico produtoServico) {
		this.id = id;
		this.quantidade = quantidade;
		this.produtoServico = produtoServico;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public ProdutoServico getProdutoServico() {
		return produtoServico;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public void setProdutoServico(ProdutoServico produtoServico) {
		this.produtoServico = produtoServico;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}

