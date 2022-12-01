package com.produtos.crud.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.crud.exception.NaoEncontradoException;
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
		try {
			return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.salvaProdutoServico(produtoServicoDTO), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<ProdutoServicoDTO>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(value = "/listaProdutos",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProdutoServicoDTO> > listaProdutosCadastrados () {
		try {
			return new ResponseEntity<>(produtoServicoService.listaProdutosServicosCadastrados(), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<List<ProdutoServicoDTO>>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(value = "/buscaProduto/{id}",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoServicoDTO> buscaProdutoServicoPeloId(@PathVariable UUID id) {
		try {
			return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.buscaProdutoServicoPeloId(id), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<ProdutoServicoDTO>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@RequestMapping(value = "/deletaProduto/{id}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoServicoDTO> deletaProdutoServicoPeloId(@PathVariable UUID id) {
		try {
			return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.deletaProdutoServicoPeloId(id), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<ProdutoServicoDTO>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(value = "/alteraProduto",
			method = RequestMethod.PATCH,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoServicoDTO> alteraProdutoServico(@RequestBody ProdutoServicoDTO produtoServicoDTO) {
		try {
			return new ResponseEntity<ProdutoServicoDTO>(produtoServicoService.alteraProduto(produtoServicoDTO), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<ProdutoServicoDTO>(HttpStatus.NOT_FOUND);
		}
	}
}
