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

import com.produtos.crud.exception.NaoEncontradoException;
import com.produtos.crud.modelo.DTO.PedidoDTO;
import com.produtos.crud.service.PedidoService;

@RestController
@RequestMapping("/crud")
public class ControllerPedido {
	
	@Autowired
	public PedidoService pedidoService;
	
	@RequestMapping(value = "/cadastrarPedido",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoDTO> cadastrarPedido(@RequestBody PedidoDTO pedidoDTO) throws Exception {
		
		return new ResponseEntity<PedidoDTO>(pedidoService.cadastraPedido(pedidoDTO), HttpStatus.OK);
	}

	@RequestMapping(value = "/listaPedidos",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PedidoDTO>> listaPedidos () {
		try {
			return new ResponseEntity<List<PedidoDTO>>(pedidoService.listaPedidos(), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<List<PedidoDTO>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/buscaPedido",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoDTO> buscaPedido(@RequestBody PedidoDTO pedidoDTO) {
		try {
			return new ResponseEntity<PedidoDTO>(pedidoService.buscaPedido(pedidoDTO.getId()), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<PedidoDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/deletaPedido",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoDTO> deletaPedido(@RequestBody PedidoDTO pedidoDTO) {
		try {			
			return new ResponseEntity<PedidoDTO>(pedidoService.deletaPedido(pedidoDTO.getId()), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<PedidoDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/alteraPedido",
			method = RequestMethod.PATCH,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoDTO> alteraPedido(@RequestBody PedidoDTO pedidoDTO) {
		try {
			return new ResponseEntity<PedidoDTO>(pedidoService.alteraPedido(pedidoDTO), HttpStatus.OK);
		}catch (NaoEncontradoException e) {
			return new ResponseEntity<PedidoDTO>(HttpStatus.NOT_FOUND);
		}
		
	}

}
