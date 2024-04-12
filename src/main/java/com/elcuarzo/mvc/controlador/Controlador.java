package com.elcuarzo.mvc.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elcuarzo.mvc.modelo.Personas;
import com.elcuarzo.mvc.modelo.Licencias;
import com.elcuarzo.mvc.servicios.LicenciaServicios;

@Controller
public class Controlador {
	private final LicenciaServicios licenciaServicios;
	
	public Controlador(LicenciaServicios licenciaServicio) {
		this.licenciaServicios = licenciaServicio;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Personas> persona = licenciaServicios.TodosLasPersonas();
		List<Licencias> licencias = licenciaServicios.TodasLasLicencias();
		model.addAttribute("licencias", licencias);
		model.addAttribute("persona", persona);
		return "/index.jsp";
	}
	
	@RequestMapping("/persona/nueva")
	public String CrearPersona() {
		return "/nuevaPersona.jsp";
	}
	
	@RequestMapping("/licencia/nueva")
	public String CrearLicencia(Model model) {
		List<Personas> nombres = licenciaServicios.TodosLasPersonas();
		model.addAttribute("nombres", nombres);
		return "/nuevaLicencia.jsp";
	}
	
	@RequestMapping("/persona/{id}")
	public String mostrarPersonaPorId(@PathVariable("id") Long id, Model model) {
		Personas persona = licenciaServicios.EncontrarPersona(id);
		model.addAttribute("persona", persona);
		return "/mostrar.jsp";
	}
	
	@RequestMapping(value="/crear/persona", method=RequestMethod.POST)
	public String CrearPersona(@RequestParam(value="nombre") String nombre,
							   @RequestParam(value="apellido") String apellido) {
		Personas persona = new Personas(nombre, apellido);
		licenciaServicios.CrearPersona(persona);
		return "redirect:/licencia/nueva";
	}
	
	@RequestMapping(value="/crear/licencia", method=RequestMethod.POST)
	public String CrearLicencia(@RequestParam(value="nombre") Long nombre,
								@RequestParam(value="fechaExpiracion") String fechaExpiracion,
								@RequestParam(value="estado") String estado) {
		licenciaServicios.CrearLicenciaParaPersona(nombre, fechaExpiracion, estado);
		return "redirect:/persona/nueva";
	}
	
	
}
