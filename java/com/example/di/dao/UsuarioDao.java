package com.example.di.dao;

import java.util.List;

import com.example.di.models.Usuario;

public interface UsuarioDao {
	
	List<Usuario> getUsuarios();

	void eliminar(long id);

	void registrar(Usuario usuario);

	boolean verificarEmail(Usuario usuario);
	
}
