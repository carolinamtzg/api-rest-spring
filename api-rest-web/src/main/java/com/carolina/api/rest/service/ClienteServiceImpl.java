package com.carolina.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carolina.api.rest.dao.ClienteDao;
import com.carolina.api.rest.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true) // esto solo se pone en los gets
	public List<Cliente> buscarTodos() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true) // buena practica para optimizar las peticiones get
	public Cliente buscarPorId(Long id) {
		return clienteDao.findById(id).orElse(null); // orElse es por si no encuentra el id para null
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public Cliente borrar(Long id) {
		Cliente clienteBorrado = clienteDao.findById(id).orElse(null);
		
		clienteDao.deleteById(id);
		
		return clienteBorrado;
	}
	
}
