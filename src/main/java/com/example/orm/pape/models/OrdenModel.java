package com.example.orm.pape.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden")
public class OrdenModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String nombre;
	
	@ManyToOne 
	private UsuarioModel usuario;
	
	/*@OneToOne(mappedBy = "orden")
	private DetalleOrdenModel detalleOrden;*/
	
	public OrdenModel() {

	}

	public OrdenModel(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

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

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	/*public DetalleOrdenModel getDetalleOrden() {
		return detalleOrden;
	}

	public void setDetalleOrden(DetalleOrdenModel detalleOrden) {
		this.detalleOrden = detalleOrden;
	}*/
	
}