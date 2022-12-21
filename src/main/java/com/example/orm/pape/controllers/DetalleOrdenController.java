package com.example.orm.pape.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orm.pape.models.DetalleOrdenModel;
import com.example.orm.pape.services.DetalleOrdenService;

@RestController
@RequestMapping("/detalleOrden")
public class DetalleOrdenController {
	
	@Autowired
	DetalleOrdenService detordServicio;
	
	@GetMapping()
	public ArrayList<DetalleOrdenModel>obtenerDetalles() {
		return detordServicio.obtenerDetalles();
	}
	
	@PostMapping()
	public DetalleOrdenModel guardarDetalles(@RequestBody DetalleOrdenModel detalles) {
		return this.detordServicio.guardarDetalles(detalles);
	}
	
	/*@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioServicio.obtenerPorPrioridad(prioridad);
	}*/
	
	@GetMapping(path = "/{id}")
	public Optional<DetalleOrdenModel> obtenerDetallesPorId(@PathVariable("id")Long id){
		return this.detordServicio.obtenerPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarPorId (@PathVariable("id") Long id) {
		boolean check = this.detordServicio.eliminarPorId(id);
		if (check) {
			return "Detalles eliminados";
		}
		else {
			return "No se eliminaron los detalles con el identificador " + id;
		}
	}
	
}