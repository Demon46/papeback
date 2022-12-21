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

import com.example.orm.pape.models.OrdenModel;
import com.example.orm.pape.services.OrdenService;

@RestController
@RequestMapping("/orden")
public class OrdenController {
	
	@Autowired
	OrdenService ordenServicio;
	
	@GetMapping()
	public ArrayList<OrdenModel>obtenerOrdenes() {
		return ordenServicio.obtenerOrdenes();
	}
	
	@PostMapping()
	public OrdenModel guardarOrden (@RequestBody OrdenModel orden) {
		return this.ordenServicio.guardarOrden(orden);
	}
	
	/*@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioServicio.obtenerPorPrioridad(prioridad);
	}*/
	
	@GetMapping(path = "/{id}")
	public Optional<OrdenModel> obtenerOrdenPorId(@PathVariable("id")Long id){
		return this.ordenServicio.obtenerPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarPorId (@PathVariable("id") Long id) {
		boolean check = this.ordenServicio.eliminarPorId(id);
		if (check) {
			return "Orden eliminada";
		}
		else {
			return "No se elimino la orden " + id;
		}
	}
	
}