package com.aglayatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsername(String username);

}
