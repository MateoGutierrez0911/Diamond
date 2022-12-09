package com.JMS.Diamond.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JMS.Diamond.modelo.Rol;
import com.JMS.Diamond.servicio.RolServicio;

@Controller
public class RolControlador {

	@Autowired
	private RolServicio rolService;

	@GetMapping(path = "/rol/all")
	public String getrol(Model model) {
		List<Rol> role = rolService.ListarRoles();
		model.addAttribute("role", rolService.ListarRoles());
		return "Roles/Rols";
	}

	@GetMapping("/rol/new")
	public String showNewrolModel(Model model) {
		model.addAttribute("role", new Rol());
		return "Roles/nuevoRol";
	}

	@PostMapping("/rol/save")
	public String newRol(@ModelAttribute("role") Rol rol) {
		rolService.saveRol(rol);
		return "redirect:/rol/all";
	}

	@GetMapping("/role/update/{id}")
	public String showUpdaterol(@PathVariable Long id, Model model) {
		model.addAttribute("role", rolService.getRoles(id));
		return "Roles/editar";
	}

	@PostMapping("/role/{id}")
	public String updateRol(@PathVariable Long id, @ModelAttribute("role") Rol rol, Model modelo) {
		Rol rolExistente = rolService.getRoles(id);
		rolExistente.setId(id);
		rolExistente.setNombre(rol.getNombre());

		rolService.updateRol(rolExistente);
		return "redirect:/rol/all";
	}

	@GetMapping("/role/delete/{id}")
	public String deleterol(@PathVariable Long id) {
		rolService.deleteRol(id);
		return "redirect:/rol/all";
	}

}
