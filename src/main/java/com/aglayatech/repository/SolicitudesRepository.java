package com.aglayatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
