package com.elcuarzo.mvc.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elcuarzo.mvc.modelo.Licencias;
import com.elcuarzo.mvc.modelo.Personas;
import com.elcuarzo.mvc.repositorio.LicenciaRepositorio;
import com.elcuarzo.mvc.repositorio.PersonaRepositorio;

@Service
public class LicenciaServicios {
	private final LicenciaRepositorio licenciaRepositorio;
	private final PersonaRepositorio personaRepositorio;
	
	//Se inicia la variable.
	public LicenciaServicios(LicenciaRepositorio licenciaRepositorio, PersonaRepositorio personaRepositorio) {
		this.licenciaRepositorio = licenciaRepositorio;
		this.personaRepositorio = personaRepositorio;
	}
	
	// Desplegar todas las personas
	public List<Personas> TodosLasPersonas(){
		return personaRepositorio.findAll();
	}
	
	//Desplegar todas las licencias
	public List<Licencias> TodasLasLicencias(){
		return licenciaRepositorio.findAll();
	}
	
	//Crear una Persona
	public Personas CrearPersona(Personas p) {
		return personaRepositorio.save(p);
	}
	
	//Crear una Licencia
	public String CrearLicenciaParaPersona(Long personaId, String fechaExpiracion, String estado) {
		Optional<Personas> personaOpcion = personaRepositorio.findById(personaId);
		if(personaOpcion.isPresent()) {
			Personas persona = personaOpcion.get();
			
			Licencias licencia =  new Licencias();
			licencia.setPersona(persona);
			Integer numeroLicencia = generarNumeroLicencia();
			licencia.setNumero(numeroLicencia);
			licencia.setEstado(estado);
			licencia.setFechaExpiracion(fechaExpiracion);
			
			licenciaRepositorio.save(licencia);
			return "redirect:/licencia/nueva";
		}
		else {
			return "redirect:/licencia/nueva";
		}
	}
	
	//GenerarNumeroLicencia
	private int generarNumeroLicencia() {
		String ultimoNumero = licenciaRepositorio.obtenerUltimoNumeroLicencia();
		
		if(ultimoNumero != null) {
			Integer siguienteNumero = Integer.parseInt(ultimoNumero) + 1;
			return siguienteNumero;
		}
		else {
			return (Integer) 1;
		}
	}

	//Encontrar Persona
	public Personas EncontrarPersona(Long id) {
		Optional<Personas> personaOpcional = personaRepositorio.findById(id);
		if(personaOpcional.isPresent()) {
			return personaOpcional.get();
		}
		else {
			return null;
		}
	}
}
