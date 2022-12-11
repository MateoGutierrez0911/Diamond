package com.JMS.Diamond.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JMS.Diamond.modelo.Productos;
import com.JMS.Diamond.servicio.ProductosServicioImp;

@Controller
public class ProductoControlador {

	
	@Autowired
	private ProductosServicioImp productoServicio;
	

	@GetMapping(path = "/productos/all")
	public String getproductos(Model model) {
		List<Productos> productos = productoServicio.ListarProductos();
		model.addAttribute("producto", productoServicio.ListarProductos());
		return "Productos/all";
	}

	@GetMapping("/productos/new")
	public String showNewproductoModel(Model model) {
		model.addAttribute("producto", new Productos());
		return "Productos/new";
	}

	@PostMapping("/productos/save")
	public String newproductos(@ModelAttribute("producto") Productos producto) {
		productoServicio.saveProductos(producto);
		return "redirect:/productos/all";
	}

	@GetMapping("/productos/update/{id}")
	public String showUpdateproductos(@PathVariable Long id, Model model) {
		model.addAttribute("producto", productoServicio.getProductos(id));
		return "Productos/edit";
	}

	@PostMapping("/productos/{id}")
	public String updateproducto(@PathVariable Long id, @ModelAttribute("producto") Productos producto, Model modelo) {
		Productos productoExistente = productoServicio.getProductos(id);
		productoExistente.setId_producto(id);
		productoExistente.setNombreInsumo(producto.getNombreInsumo());

		productoServicio.updateProductos(productoExistente);
		return "redirect:/productos/all";
	}

	@GetMapping("/productos/delete/{id}")
	public String deleteproducto(@PathVariable Long id) {
		productoServicio.deleteProductos(id);
		return "redirect:/productos/all";
	}
}