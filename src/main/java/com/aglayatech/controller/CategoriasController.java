package com.aglayatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.model.Categoria;
import com.aglayatech.service.ICategoriasService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	// @Qualifier("categoriasServiceJPA")
	private ICategoriasService serviceCategoria;
	
	// @GetMapping("/index")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> categorias = serviceCategoria.buscarTodas();
		model.addAttribute("categorias", categorias);
		return "categorias/listCategorias";
	}
	
	@RequestMapping(value = "/indexPaginate",method = RequestMethod.GET)
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria> categorias = serviceCategoria.buscarTodas(page);
		model.addAttribute("categorias", categorias);
		return "categorias/listCategorias";
	}
	
	// @GetMapping("/create")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	// @PostMapping("/save")
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		serviceCategoria.guardar(categoria);
		attributes.addFlashAttribute("mensaje", "La categoría ha sido registrada con éxito.");
		return "redirect:/categorias/index";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") int idcategoria, Model model) {
		Categoria categoria = serviceCategoria.buscarPorId(idcategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") int idcategoria, RedirectAttributes attributes) {
		serviceCategoria.eliminar(idcategoria);
		attributes.addFlashAttribute("mensaje", "Categoria con ID: " + idcategoria + " ha sido eliminada con éxito!");
		return "redirect:/categorias/index";
	}
}
