package com.banco.capgemini.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banco.capgemini.entities.Cliente;
import com.banco.capgemini.interfaces.service.IClienteService;

@RestController
@RequestMapping("api")
public class ClienteController {
	
	private IClienteService clienteService;
	
	public ClienteController(IClienteService clienteService) {
		this.clienteService = clienteService;
	}
		
	@PostMapping("/cliente")
	Cliente post(@RequestBody Cliente entidade) {
		return clienteService.CadastrarCliente(entidade);		
	}
}
