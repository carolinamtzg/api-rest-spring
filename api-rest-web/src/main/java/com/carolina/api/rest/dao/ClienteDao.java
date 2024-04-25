package com.carolina.api.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carolina.api.rest.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{ // se pasa la entity y el type del ID.
	
}
