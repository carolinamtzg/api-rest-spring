package com.carolina.api.rest.service;

import java.util.List;

import com.carolina.api.rest.entity.Producto;

public interface ProductoService {
	public List<Producto> buscarProductos();
	
	public Producto buscarProducotPorId(Long id);
	
	public Producto guardarProducto(Producto producto);
	
	public Producto eliminarProducto(Long id);
}
