package com.example.orm.pape.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.pape.models.DetalleOrdenModel;
import com.example.orm.pape.repositories.DetalleOrdenRepository;

@Service
public class DetalleOrdenService {
	@Autowired
	DetalleOrdenRepository detordRepositorio;
	public ArrayList<DetalleOrdenModel> obtenerDetalles() {
		return (ArrayList<DetalleOrdenModel>) detordRepositorio.findAll();
	}
	
	public DetalleOrdenModel guardarDetalles(DetalleOrdenModel detalles) {
		return detordRepositorio.save(detalles);
	}
	
	/*public ArrayList<ProductoModel> obtenerPorPrioridad(Integer prioridad) {
		return productoRepositorio.findByPrioridad(prioridad);
	}*/
	
	public Optional<DetalleOrdenModel> obtenerPorId(Long id) {
		return detordRepositorio.findById(id);
	}
	
	public boolean eliminarPorId(Long id) {
		try {
		detordRepositorio.deleteById(id);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

}