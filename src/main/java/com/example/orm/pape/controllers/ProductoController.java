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

import com.example.orm.pape.models.ProductoModel;
import com.example.orm.pape.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoServicio;
	
	@GetMapping()
	public ArrayList<ProductoModel>obtenerProductos() {
		return productoServicio.obtenerProductos();
	}
	
	@PostMapping()
	public ProductoModel guardarProducto (@RequestBody ProductoModel producto) {
		return this.productoServicio.guardarProducto(producto);
	}
	
	/*@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioServicio.obtenerPorPrioridad(prioridad);
	}*/
	
	@GetMapping(path = "/{id}")
	public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id")Long id){
		return this.productoServicio.obtenerPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarPorId (@PathVariable("id") Long id) {
		boolean check = this.productoServicio.eliminarPorId(id);
		if (check) {
			return "Producto eliminado";
		}
		else {
			return "No se elimino el producto " + id;
		}
	}
	
}