package com.example.orm.pape.models;

import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalleOrden")
public class DetalleOrdenModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String nombre;
	private Integer cantidad;
	private Float montoTotal;
	
	/*@OneToMany(mappedBy = "detalleOrden")
	private ArrayList<ProductoModel> productos;*/
	
	@OneToOne
	@JoinColumn(name = "FK_ORDEN")
	private OrdenModel orden;
	
	public DetalleOrdenModel() {
		
	}
	
	public DetalleOrdenModel(Long id, String nombre, Integer cantidad, Float montoTotal,
			ArrayList<ProductoModel> productos, OrdenModel orden) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.montoTotal = montoTotal;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}

	/*public ArrayList<ProductoModel> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoModel> productos) {
		this.productos = productos;
	}*/
	
	public OrdenModel getOrden() {
		return orden;
	}

	public void setOrden(OrdenModel orden) {
		this.orden = orden;
	}
	
	
}