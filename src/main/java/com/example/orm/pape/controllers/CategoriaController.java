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

import com.example.orm.pape.models.CategoriaModel;
import com.example.orm.pape.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaServicio;
	
	@GetMapping()
	public ArrayList<CategoriaModel>obtenerCategorias() {
		return categoriaServicio.obtenerCategorias();
	}
	
	@PostMapping()
	public CategoriaModel guardarCategoria (@RequestBody CategoriaModel categoria) {
		return this.categoriaServicio.guardarCategoria(categoria);
	}
	
	/*@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioServicio.obtenerPorPrioridad(prioridad);
	}*/
	
	@GetMapping(path = "/{id}")
	public Optional<CategoriaModel> obtenerCategoriaPorId(@PathVariable("id")Long id){
		return this.categoriaServicio.obtenerPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarPorId (@PathVariable("id") Long id) {
		boolean check = this.categoriaServicio.eliminarPorId(id);
		if (check) {
			return "Categoria eliminada";
		}
		else {
			return "No se elimino la categoria " + id;
		}
	}
	
}