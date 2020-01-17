package com.aglayatech.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aglayatech.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService{
	
	private List<Vacante> lista = null;

	public VacantesServiceImpl() {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<>();
		try {
			
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero civil");
			vacante1.setDescripcion("Solicitamos Ingeniero Civil");
			vacante1.setFecha(formato.parse("08-02-2019"));
			vacante1.setSalario(8500.00);
			vacante1.setDestacado(1);
			vacante1.setImagen("logo1.png");
			vacante1.setEstatus("Creada");
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero civil");
			vacante2.setDescripcion("Solicitamos Ingeniero Civil");
			vacante2.setFecha(formato.parse("08-02-2019"));
			vacante2.setSalario(8500.00);
			vacante2.setDestacado(0);
			vacante2.setImagen("logo2.png");
			vacante2.setEstatus("Aprobada");
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero en Sistemas de Información");
			vacante3.setDescripcion("Solicitamos Ingeniero de Sistemas para soporte Técnico");
			vacante3.setFecha(formato.parse("10-05-2019"));
			vacante3.setSalario(9000.00);
			vacante3.setDestacado(0);
			vacante3.setImagen("logo3.png");
			vacante3.setEstatus("Aprobada");
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero civil");
			vacante4.setDescripcion("Solicitamos Ingeniero Civil");
			vacante4.setFecha(formato.parse("08-02-2019"));
			vacante4.setSalario(8501.00);
			vacante4.setDestacado(1);
			vacante4.setImagen("logo4.png");
			vacante4.setEstatus("Eliminada");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
			
			
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v : lista) {
			if(v.getId() == idVacante) {
				return v;
			}
		}
		
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
