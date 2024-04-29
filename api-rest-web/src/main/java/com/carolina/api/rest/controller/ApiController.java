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
import com.carolina.api.rest.entity.Producto;
import com.carolina.api.rest.service.ClienteService;
import com.carolina.api.rest.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ClienteService servicio;
	
	@Autowired 
	private ProductoService servicioProd;
	
	
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
	
	
	
	// metodo get que devuelve todos los productos:
	@GetMapping("/productos")
	public List<Producto> indexProducto(){
		return servicioProd.buscarProductos();
	}
	
	// metodo que devuelve un solo producto dado el id:
		@GetMapping("/productos/{id}") 
		public Producto showProd(@PathVariable Long id) { 
			return servicioProd.buscarProducotPorId(id);
		}
		
		// metodo que guarda un solo producto:
		@PostMapping("/productos")
		public Producto createProd(@RequestBody Producto producto) {
			return servicioProd.guardarProducto(producto);
		}
		
		// metodo para actualizar producto por id:
		@PutMapping("productos/{id}")
		public Producto updateProd(@PathVariable Long id, @RequestBody Producto new_producto) {
			
			Producto productoUpdate = servicioProd.buscarProducotPorId(id);
			
			productoUpdate.setNombre(new_producto.getNombre());
			productoUpdate.setCategoria(new_producto.getCategoria());
			productoUpdate.setDescripcion(new_producto.getDescripcion());
			productoUpdate.setTipo(new_producto.getTipo());
			productoUpdate.setPrecio_compra(new_producto.getPrecio_compra());
			productoUpdate.setPrecio_compra(new_producto.getPrecio_compra());
			productoUpdate.setActivo(new_producto.isActivo());
			
			return servicioProd.guardarProducto(productoUpdate);
		}
		
		//metodo para eliminar producto por id:
		@DeleteMapping("productos/{id}")
		public Producto deleteProd(@PathVariable Long id) {
			return servicioProd.eliminarProducto(id);
		}
}
