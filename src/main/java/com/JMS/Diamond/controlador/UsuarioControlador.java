package com.JMS.Diamond.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.JMS.Diamond.modelo.Usuario;
import com.JMS.Diamond.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {
	@Autowired
	private UsuarioServicio usuarioservicio;
	
	@GetMapping(path = "/cliente/all")
	public String getusuario(Model model) {
		List<Usuario> usuario = usuarioservicio.listarUsuarios();
		model.addAttribute("usuarios", usuarioservicio.listarUsuarios());
		return "Cliente/all";
	}

}
