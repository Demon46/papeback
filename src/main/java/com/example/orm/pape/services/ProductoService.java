package com.example.orm.pape.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.pape.models.ProductoModel;
import com.example.orm.pape.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepositorio;
	public ArrayList<ProductoModel> obtenerProductos() {
		return (ArrayList<ProductoModel>) productoRepositorio.findAll();
	}
	
	public ProductoModel guardarProducto(ProductoModel producto) {
		return productoRepositorio.save(producto);
	}
	
	/*public ArrayList<ProductoModel> obtenerPorPrioridad(Integer prioridad) {
		return productoRepositorio.findByPrioridad(prioridad);
	}*/
	
	public Optional<ProductoModel> obtenerPorId(Long id) {
		return productoRepositorio.findById(id);
	}
	
	public boolean eliminarPorId(Long id) {
		try {
		productoRepositorio.deleteById(id);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

}