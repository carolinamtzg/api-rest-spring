package com.carolina.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.api.rest.entity.Cliente;
import com.carolina.api.rest.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return servicio.buscarTodos();
	}
}
