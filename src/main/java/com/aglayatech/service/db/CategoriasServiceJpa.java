package com.aglayatech.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aglayatech.model.Categoria;
import com.aglayatech.repository.CategoriasRepository;
import com.aglayatech.service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService{
	
	@Autowired
	private CategoriasRepository repoCategorias;

	@Override
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		List<Categoria> lista = repoCategorias.findAll();
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = repoCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategorias.deleteById(idCategoria);
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		return repoCategorias.findAll(page);
	}

}
