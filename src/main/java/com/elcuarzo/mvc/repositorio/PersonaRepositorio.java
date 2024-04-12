package com.elcuarzo.mvc.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelo.Personas;

public interface PersonaRepositorio extends CrudRepository<Personas, Long>{
	List<Personas> findAll();
}
