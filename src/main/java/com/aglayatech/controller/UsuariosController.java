package com.aglayatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aglayatech.service.IUsuariosService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {
	
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/demo-bcrypt")
	public String pruebaBcrypt() {
		String password = "mari123";
		String encriptado = passwordEncoder.encode(password);
		System.out.println("Password encriptado: " + encriptado);
		return "usuarios/demo";
	}

	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("usuarios", serviceUsuarios.buscarTodos());
		return "usuarios/listUsuarios";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idusuario,RedirectAttributes attributes) {
		serviceUsuarios.eliminar(idusuario);
		attributes.addFlashAttribute("mensaje", "El registro fue eliminado con éxito!");
		return "redirect:/usuarios/index";
	}
	
}
