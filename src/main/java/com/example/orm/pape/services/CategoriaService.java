package com.example.orm.pape.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.pape.models.CategoriaModel;
import com.example.orm.pape.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepositorio;
	public ArrayList<CategoriaModel> obtenerCategorias() {
		return (ArrayList<CategoriaModel>) categoriaRepositorio.findAll();
	}
	
	public CategoriaModel guardarCategoria(CategoriaModel categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
	/*public ArrayList<ProductoModel> obtenerPorPrioridad(Integer prioridad) {
		return productoRepositorio.findByPrioridad(prioridad);
	}*/
	
	public Optional<CategoriaModel> obtenerPorId(Long id) {
		return categoriaRepositorio.findById(id);
	}
	
	public boolean eliminarPorId(Long id) {
		try {
		categoriaRepositorio.deleteById(id);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

}