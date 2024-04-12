package com.elcuarzo.mvc.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelo.Licencias;

public interface LicenciaRepositorio extends CrudRepository<Licencias, Long> {
	List<Licencias> findAll();
	
	@Query("SELECT MAX(l.numero) FROM Licencias l")
	String obtenerUltimoNumeroLicencia();
}
