package com.example.orm.pape.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.pape.models.UsuarioModel;
import com.example.orm.pape.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepositorio;
	public ArrayList<UsuarioModel> obtenerUsuarios() {
		return (ArrayList<UsuarioModel>) usuarioRepositorio.findAll();
	}
	public UsuarioModel guardarUsuario(UsuarioModel usuario) {
		return usuarioRepositorio.save(usuario);
		
	}
	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
		return usuarioRepositorio.findByPrioridad(prioridad);
	}
	public Optional<UsuarioModel> obtenerPorId(Long id) {
		return usuarioRepositorio.findById(id);
	}
	
	public boolean eliminarPorId(Long id) {
		try {
		usuarioRepositorio.deleteById(id);
		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
//	public boolean eliminarPorId(Long id) {
//		if (usuarioRepositorio.findById(id).isPresent()) {
//			usuarioRepositorio.deleteById(id);
//			return true;
//		}else {
//			return false;
//		}
//		
//	}

}
