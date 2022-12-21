package com.example.orm.pape.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.pape.models.OrdenModel;
import com.example.orm.pape.repositories.OrdenRepository;

@Service
public class OrdenService {
	@Autowired
	OrdenRepository ordenRepositorio;
	public ArrayList<OrdenModel> obtenerOrdenes() {
		return (ArrayList<OrdenModel>) ordenRepositorio.findAll();
	}
	
	public OrdenModel guardarOrden(OrdenModel orden) {
		return ordenRepositorio.save(orden);
	}
	
	/*public ArrayList<ProductoModel> obtenerPorPrioridad(Integer prioridad) {
		return productoRepositorio.findByPrioridad(prioridad);
	}*/
	
	public Optional<OrdenModel> obtenerPorId(Long id) {
		return ordenRepositorio.findById(id);
	}
	
	public boolean eliminarPorId(Long id) {
		try {
		ordenRepositorio.deleteById(id);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

}