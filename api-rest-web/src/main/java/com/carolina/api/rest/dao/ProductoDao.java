package com.carolina.api.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carolina.api.rest.entity.Producto;


@Repository
public interface ProductoDao extends CrudRepository<Producto, Long>{
	
}
