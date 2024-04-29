package com.carolina.api.rest.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //para el autoincrement del id
	private Long id;
	private String nombre;
	private String tipo;
	private String categoria;
	private String descripcion;
	private Double precio_compra;
	private Double precio_venta;
	private boolean activo;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Double getPrecio_compra() {
		return precio_compra;
	}



	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}



	public Double getPrecio_venta() {
		return precio_venta;
	}



	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	private static final long serialVersionUID = 1L;
}
