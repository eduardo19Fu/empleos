package com.aglayatech.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.model.Solicitud;
import com.aglayatech.model.Usuario;
import com.aglayatech.model.Vacante;
import com.aglayatech.service.ISolicitudesService;
import com.aglayatech.service.IVacantesService;
import com.aglayatech.util.Utileria;

@Controller
@RequestMapping(value = "/solicitudes")
public class SolicitudesController {
	
	@Autowired
	private ISolicitudesService serviceSolicitud;
	
	@Autowired
	private IVacantesService serviceVacante;

	
	@Value("${empleosapp.ruta.cv}")
	private String ruta;
	
	@GetMapping(value = "/index")
	public String indexPaginado(Model model, Pageable page) {
		return "solicitudes/listSolicitudes";
	}
	
	@GetMapping(value = "/create/{id}")
	public String crearSolicitud(@PathVariable("id") Integer idVacante,Solicitud solicitud,Model model) {
		Vacante vacante = serviceVacante.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "solicitudes/formSolicitud";
	}
	
	@PostMapping(value = "/save")
	public String guardar(Solicitud solicitud,RedirectAttributes attributes, BindingResult result, @RequestParam("archivoCV") MultipartFile multipartFile, 
						  @RequestParam("idvacante") int idVacante, HttpSession session) {
		
		Vacante vacante = serviceVacante.buscarPorId(idVacante);
		
		
		if(!multipartFile.isEmpty()) {
			String nombreArchivo = Utileria.guardarArchivo(multipartFile, ruta);
			if(nombreArchivo != null) {
				solicitud.setArchivo(nombreArchivo);
				solicitud.setVacante(vacante);
				solicitud.setFecha(new Date());
				solicitud.setUsuario((Usuario) session.getAttribute("usuario"));
			}
		}
		
		serviceSolicitud.guardar(solicitud);
		attributes.addFlashAttribute("mensaje", "La solicitud ha sido registrada con éxito.");
		return "redirect:/";
	}
	
	@InitBinder
	public void initiBinder(WebDataBinder binder) {
		
	}
	
}
