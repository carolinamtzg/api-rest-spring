package com.carolina.api.rest.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity // anotacion para definir que es una entidad y mapeea
@Table(name="cliente")  // definimos el nombre que va a tener la tabla
public class Cliente implements Serializable{ //implementamos Serializable para darle un identificador unico.
	
	@Id // para marcar cual de ellos va a ser el ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para auto incremental
	private Long id;
	
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	
	@Column(name="fecha_creacion") // cambia el nombre de createdAt en la DB
	@Temporal(TemporalType.DATE) // cambia a solo la fecha en el Date en la DB
	private Date createdAt; // el camelcase se traduce a created_at en la DB
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	private static final long serialVersionUID = 1L;
	
	
}
