package com.aglayatech.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aglayatech.model.Solicitud;
import com.aglayatech.repository.SolicitudesRepository;
import com.aglayatech.service.ISolicitudesService;

@Service
public class SolicitudesServiceJpa implements ISolicitudesService {
	
	@Autowired
	private SolicitudesRepository repoSolicitudes;

	@Override
	public List<Solicitud> buscarTodas() {
		return repoSolicitudes.findAll();
	}

	@Override
	public void guardar(Solicitud solicitud) {
		repoSolicitudes.save(solicitud);
	}

	@Override
	public void eliminar(Integer idSolicitud) {
		repoSolicitudes.deleteById(idSolicitud);
	}

	@Override
	public Page<Solicitud> buscarTodas(Pageable page) {
		Page<Solicitud> paginas = repoSolicitudes.findAll(page);
		return paginas;
	}

	@Override
	public Solicitud buscarPorId(Integer idSolicitud) {
		Optional<Solicitud> optional = repoSolicitudes.findById(idSolicitud);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
