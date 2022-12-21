package com.example.orm.pape.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoriaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String nombre;
	
	/*@OneToMany(mappedBy = "categoria")
	private ArrayList<ProductoModel> productos;*/
	
	public CategoriaModel() {
		
	}
	
	public CategoriaModel(Long id, String nombre, ArrayList<ProductoModel> productos) {
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

	/*public ArrayList<ProductoModel> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoModel> productos) {
		this.productos = productos;
	}*/
}
