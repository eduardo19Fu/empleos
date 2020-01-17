package com.aglayatech.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aglayatech.model.Solicitud;

public interface ISolicitudesService {
	
	List<Solicitud> buscarTodas();
	void guardar(Solicitud solicitud);
	void eliminar(Integer idSolicitud);
	Page<Solicitud> buscarTodas(Pageable page);
	Solicitud buscarPorId(Integer idSolicitud);
}
