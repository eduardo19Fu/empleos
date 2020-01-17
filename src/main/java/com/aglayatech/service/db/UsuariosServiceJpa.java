package com.aglayatech.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglayatech.model.Usuario;
import com.aglayatech.repository.UsuariosRepository;
import com.aglayatech.service.IUsuariosService;

@Service
public class UsuariosServiceJpa implements IUsuariosService {
	
	@Autowired
	private UsuariosRepository repoUsuario;

	@Override
	public List<Usuario> buscarTodos() {
		return repoUsuario.findAll();
	}

	@Override
	public void eliminar(Integer idUsuario) {
		repoUsuario.deleteById(idUsuario);
	}

	@Override
	public void guardar(Usuario usuario) {
		repoUsuario.save(usuario);
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return repoUsuario.findByUsername(username);
	}

}
