package com.produtos.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.crud.exception.NaoEncontradoException;
import com.produtos.crud.modelo.DTO.PedidoItemDTO;
import com.produtos.crud.service.PedidoItemService;

@RestController
@RequestMapping("/crud")
public class ControllerPedidoItem {

	@Autowired
	PedidoItemService pedidoItemService;
	
	@RequestMapping(value = "/deletaPedidoItem",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoItemDTO> deletaPedidoItemPeloId(@RequestBody PedidoItemDTO pedidoItemDTO) {
		try {
			return new ResponseEntity<PedidoItemDTO>(pedidoItemService.deletaPedidoItemPeloId(pedidoItemDTO.getId()), HttpStatus.OK);
		} catch (NaoEncontradoException e) {
			throw new NaoEncontradoException();
		}
	}
}
