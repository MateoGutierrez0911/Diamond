package com.JMS.Diamond.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JMS.Diamond.modelo.Ventas;
import com.JMS.Diamond.servicio.VentasServicioImp;

@Controller
public class VentasControlador {

	@Autowired
	private VentasServicioImp ventasServicio;
	

	@GetMapping(path = "/ventas/all")
	public String getVentas(Model model) {
		List<Ventas> ventas = ventasServicio.ListarVentas();
		model.addAttribute("venta", ventasServicio.ListarVentas());
		return "Ventas/all";
	}

	@GetMapping("/ventas/new")
	public String showNewVentasModel(Model model) {
		model.addAttribute("venta", new Ventas());
		return "Ventas/new";
	}

	@PostMapping("/ventas/save")
	public String newVentas(@ModelAttribute("reserva") Ventas ventas) {
		ventasServicio.saveVentas(ventas);
		return "redirect:/ventas/all";
	}

	@GetMapping("/ventas/update/{id}")
	public String showUpdateVentas(@PathVariable Long id, Model model) {
		model.addAttribute("venta", ventasServicio.getVentas(id));
		return "ventas/edit";
	}

	@PostMapping("/ventas/{id}")
	public String updateVentas(@PathVariable Long id, @ModelAttribute("venta") Ventas ventas, Model modelo) {
		Ventas ventaExistente = ventasServicio.getVentas(id);
		ventaExistente.setId_venta(id);
		ventaExistente.setProductos(ventas.getProductos());

		ventasServicio.updateVentas(ventaExistente);
		return "redirect:/ventas/all";
	}

	@GetMapping("/ventas/delete/{id}")
	public String deleteVentas(@PathVariable Long id) {
		ventasServicio.deleteVentas(id);
		return "redirect:/ventas/all";
	}
	
}
