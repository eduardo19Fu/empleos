package com.aglayatech.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aglayatech.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService {
	
	List<Categoria> lista = null;
	
	public CategoriasServiceImpl() {
		lista = new LinkedList<Categoria>();
		
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("Ventas");
		categoria1.setDescripcion("Categoria destinada a todos aquellos empleos cuyo objetivo principal yace en el departamento de ventas.");
		
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Contabilidad");
		categoria2.setDescripcion("Categoria destinada a todos aquellos empleos cuyo objetivo principal yace en el departamento de contabilidad.");
		
		Categoria categoria3 = new Categoria();
		categoria3.setId(1);
		categoria3.setNombre("Transporte");
		categoria3.setDescripcion("Categoria destinada a todos aquellos empleos solicitados por agencias dedicadas principalmente al transporte.");
		
		Categoria categoria4 = new Categoria();
		categoria4.setId(4);
		categoria4.setNombre("Informatica");
		categoria4.setDescripcion("Categoria destinada a todos aquellos empleos que se encuentran disponibles para el departamento de Informática y sus distintas áreas.");
		
		Categoria categoria5 = new Categoria();
		categoria5.setId(5);
		categoria5.setNombre("Construcción");
		categoria5.setDescripcion("Categoría creada para los empleos en agencias de construcción o diseño de estructuras.");
		
		lista.add(categoria1);
		lista.add(categoria2);
		lista.add(categoria3);
		lista.add(categoria4);
		lista.add(categoria5);
	}

	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		
		for(Categoria cat : lista) {
			if(cat.getId() == idCategoria) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
