package com.produtos.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.crud.modelo.DTO.ProdutoServicoDTO;
import com.produtos.crud.service.ProdutoServicoService;

@RestController
@RequestMapping("/crud")
public class ControllerProduto {

	
	@Autowired
	public ProdutoServicoService produtoServicoService;
	
	@RequestMapping(value = "/adicionaProduto",
					method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoServicoDTO> salvaProdutoServico (@RequestBody ProdutoServicoDTO produtoServicoDTO) throws Exception {
		return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.salvaProdutoServico(produtoServicoDTO), HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/listaProdutos",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProdutoServicoDTO> > listaProdutosCadastrados () {
		return new ResponseEntity<>(produtoServicoService.listaProdutosServicosCadastrados(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscaProduto",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoServicoDTO> buscaProdutoServicoPeloId(@RequestBody ProdutoServicoDTO produtoServicoDTO) {
		return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.buscaProdutoServicoPeloId(produtoServicoDTO.getId()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deletaProduto",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoServicoDTO> deletaProdutoServicoPeloId(@RequestBody ProdutoServicoDTO produtoServicoDTO) {
		return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.deletaProdutoServicoPeloId(produtoServicoDTO.getId()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/alteraProduto",
			method = RequestMethod.PATCH,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoServicoDTO> alteraProdutoServico(@RequestBody ProdutoServicoDTO produtoServicoDTO) {
		return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.alteraProduto(produtoServicoDTO), HttpStatus.OK);
	}
	
}
