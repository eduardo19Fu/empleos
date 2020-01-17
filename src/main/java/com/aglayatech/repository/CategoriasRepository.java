package com.aglayatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aglayatech.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
