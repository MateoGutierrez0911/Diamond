package com.JMS.Diamond.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JMS.Diamond.modelo.Categorias;
import com.JMS.Diamond.servicio.CategoriaServicioImp;

@Controller
public class CategoriaControlador {

	@Autowired
	private CategoriaServicioImp categoriaServicio;
	

	@GetMapping(path = "/categorias/all")
	public String getCategorias(Model model) {
		List<Categorias> categoria = categoriaServicio.ListarCategorias();
		model.addAttribute("categoria", categoriaServicio.ListarCategorias());
		return "Categorias/all";
	}

	@GetMapping("/categorias/new")
	public String showNewCategoriasModel(Model model) {
		model.addAttribute("categoria", new Categorias());
		return "Categorias/new";
	}

	@PostMapping("/categorias/save")
	public String newCategorias(@ModelAttribute("categoria") Categorias categoria) {
		categoriaServicio.saveCategoria(categoria);
		return "redirect:/categorias/all";
	}

	@GetMapping("/categorias/update/{id}")
	public String showUpdateCategorias(@PathVariable Long id, Model model) {
		model.addAttribute("categoria", categoriaServicio.getCategoria(id));
		return "Categorias/edit";
	}

	@PostMapping("/categorias/{id}")
	public String updateCategorias(@PathVariable Long id, @ModelAttribute("categoria") Categorias categoria, Model modelo) {
		Categorias categoriaExistente = categoriaServicio.getCategoria(id);
		categoriaExistente.setId_categoria(id);
		categoriaExistente.setTipo_categoria(categoria.getTipo_categoria());
		categoriaExistente.setDescripcion_categoria(categoria.getDescripcion_categoria());
		
		categoriaServicio.updateCategoria(categoriaExistente);
		return "redirect:/categorias/all";
	}

	@GetMapping("/categorias/delete/{id}")
	public String deleteCategorias(@PathVariable Long id) {
		categoriaServicio.deleteCategria(id);
		return "redirect:/categorias/all";
	}
	
}
