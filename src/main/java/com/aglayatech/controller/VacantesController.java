package com.aglayatech.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.model.Vacante;
import com.aglayatech.service.ICategoriasService;
import com.aglayatech.service.IVacantesService;
import com.aglayatech.util.Utileria;

@Controller
@RequestMapping(value = "/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@Autowired
	// @Qualifier("categoriasServiceJPA")
	private ICategoriasService serviceCategorias;
	
	@Value("${empleosapp.ruta.imagenes}")
	private String ruta;
	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Vacante> vacantes = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", vacantes);
		return "vacantes/listVacantes";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Vacante> lista = serviceVacantes.buscarTodas(page);
		model.addAttribute("vacantes", lista);
		return "vacantes/listVacantes";
	}

	
	@GetMapping(value = "/create")
	public String crear(Vacante vacante, Model model) {
		// model.addAttribute("categorias", serviceCategorias.buscarTodas());
		return "vacantes/formVacante";
	}
	
	@PostMapping(value = "/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes,  @RequestParam("archivoImagen") MultipartFile multiPart) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		
		if (!multiPart.isEmpty()) {
			// String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			// String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}

		System.out.println("Vacante: " + vacante);
		serviceVacantes.guardar(vacante);
		attributes.addFlashAttribute("mensaje", "Vacante registrada con éxito.");
		return "redirect:/vacantes/index";
	}
	
	/*@PostMapping(value = "/save")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado,
			@RequestParam("salario") double salario,@RequestParam("detalles") String detalles) {
		System.out.println("Nombre de Vacante: " + nombre);
		System.out.println("Descripcion: " + descripcion);
		System.out.println("Estatus: " + estatus); 
		System.out.println("Fecha Publicación: " + fecha);
		System.out.println("Destacado: " + destacado);
		System.out.println("Salario Ofrecido: " + salario);
		System.out.println("Detalles: " + detalles);
		return "vacantes/listVacantes";
	}*/
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idvacante, Model model, RedirectAttributes attributes) {
		serviceVacantes.eliminar(idvacante);
		attributes.addFlashAttribute("mensaje", "Vacante con ID: " + idvacante + " fué eliminada con éxito.");
		return "redirect:/vacantes/index";
	}
	
	@GetMapping(value = "/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		
		// Buscar los detalles de la vacante en la Base de Datos.
		
		return "detalle";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "vacantes/formVacante";
	}
	
	@ModelAttribute
	public void getCategorias(Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
