package com.aglayatech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aglayatech.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	
	List<Vacante> findByEstatus(String estatus);
	
	List<Vacante> findByEstatusAndDestacadoOrderByIdDesc(String estatus, int destacado);
	
	List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double salario1, double salario2);
	
	List<Vacante> findByEstatusIn(String[] estatus);

}
