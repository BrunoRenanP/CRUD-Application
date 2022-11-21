package com.produtos.crud.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.crud.modelo.DTO.ProdutoServicoDTO;
import com.produtos.crud.modeloEntidade.ProdutoServico;
import com.produtos.crud.repository.ProdutoServicoRepositorio;

@Service
public class ProdutoServicoService {
	
	@Autowired
	ProdutoServicoRepositorio produtoServicoRepositorio;
	
	public ProdutoServicoDTO salvaProdutoServico(ProdutoServicoDTO produtoServicoDTO) throws Exception {
		if(produtoServicoDTO != null) {
			ProdutoServico prod = new ProdutoServico(produtoServicoDTO.getId(), produtoServicoDTO.getDescricao(), produtoServicoDTO.getValorUnitario(), produtoServicoDTO.getEhServico());
			produtoServicoRepositorio.save(prod);
			return produtoServicoDTO;
		}else {
			return new ProdutoServicoDTO();
		}
	}
	
	public List<ProdutoServicoDTO> listaProdutosServicosCadastrados() {
		List<ProdutoServico> lProdutoServico = produtoServicoRepositorio.findAll();
		return lProdutoServico.stream()
			.map(umOp -> new ProdutoServicoDTO(umOp.getId(), umOp.getDescricao(), umOp.getValorUnitario(), umOp.getEhServico()))
			.collect(Collectors.toList());
	}
	
	public ProdutoServicoDTO buscaProdutoServicoPeloId(UUID uuid) {
		ProdutoServico produto = produtoServicoRepositorio.getById(uuid);
		ProdutoServicoDTO prodDTO = new ProdutoServicoDTO(produto.getId(), produto.getDescricao(), produto.getValorUnitario(), produto.getEhServico());
		return prodDTO;
	}
	
	
	public ProdutoServicoDTO deletaProdutoServicoPeloId(UUID uuid) {
		ProdutoServico produto = produtoServicoRepositorio.getById(uuid);
		ProdutoServicoDTO prodDTO = new ProdutoServicoDTO(produto.getId(), produto.getDescricao(), produto.getValorUnitario(), produto.getEhServico());
		produtoServicoRepositorio.delete(produto);
		return prodDTO;
	}

	public ProdutoServicoDTO alteraProduto(ProdutoServicoDTO produtoServicoDTO) {
		ProdutoServico prod = new ProdutoServico(produtoServicoDTO.getId(), produtoServicoDTO.getDescricao(), produtoServicoDTO.getValorUnitario(), produtoServicoDTO.getEhServico());
		produtoServicoRepositorio.save(prod);
		return produtoServicoDTO;
	}
}
