package com.carolina.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carolina.api.rest.dao.ProductoDao;
import com.carolina.api.rest.entity.Producto;


@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoDao productoDao;

	@Override
	@Transactional(readOnly= true)
	public List<Producto> buscarProductos() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Producto buscarProducotPorId(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto guardarProducto(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public Producto eliminarProducto(Long id) {
		Producto productoDelete = productoDao.findById(id).orElse(null);
		productoDao.deleteById(id);
		return productoDelete;
	}

}
