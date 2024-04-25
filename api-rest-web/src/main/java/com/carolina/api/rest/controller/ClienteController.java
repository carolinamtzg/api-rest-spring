package com.carolina.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.api.rest.entity.Cliente;
import com.carolina.api.rest.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	// metodo get que devuelve todos los clientes:
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return servicio.buscarTodos();
	}
	
	// metodo que devuelve un solo registro dado el id:
	@GetMapping("/clientes/{id}") // para pasar la ruta
	public Cliente show(@PathVariable Long id) { // se pasa el mismo parametro que en la ruta
		return servicio.buscarPorId(id);
	}
	
	// metodo que guarda un solo registro:
	@PostMapping("/clientes")
	public Cliente create(@RequestBody Cliente cliente) {
		return servicio.guardar(cliente);
	}
	
	@PutMapping("/clientes/{id}") // put es para actualizar
	// metodo para actualizar un registro de cliente existente:
	public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
		
		Cliente clienteUpdate = servicio.buscarPorId(id); // busco al cliente a modificar por id
		
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefono(cliente.getTelefono());
		clienteUpdate.setCreatedAt(cliente.getCreatedAt());
		
		return servicio.guardar(clienteUpdate);
	}
	
	// metodo para eliminar un registro:
	@DeleteMapping("/clientes/{id}")
	public Cliente delete(@PathVariable Long id) {
		return servicio.borrar(id);
	}
}
