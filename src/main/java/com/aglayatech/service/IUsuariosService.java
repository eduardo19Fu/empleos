package com.aglayatech.service;

import java.util.List;

import com.aglayatech.model.Usuario;

public interface IUsuariosService {
	
	List<Usuario> buscarTodos();
	void eliminar(Integer idUsuario);
	void guardar(Usuario usuario);
	Usuario buscarPorUsername(String username);
}
