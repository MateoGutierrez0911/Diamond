package com.JMS.Diamond.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.JMS.Diamond.modelo.Reservas;

import com.JMS.Diamond.servicio.ReservasServicioImp;

@Controller
public class ReservaControlador {

	

	@Autowired
	private ReservasServicioImp reservaServicio;
	

	@GetMapping(path = "/reservas/all")
	public String getReservas(Model model) {
		model.addAttribute("reserva", reservaServicio.ListarReservas());
		return "Reservas/all";
	}

	@GetMapping("/reservas/new")
	public String showNewReservasModel(Model model) {
		model.addAttribute("reserva", new Reservas());
		return "Reservas/new";
	}

	@PostMapping("/reservas/save")
	public String newReservas(@ModelAttribute("reserva") Reservas reservas) {
		reservaServicio.saveReservas(reservas);
		return "redirect:/reservas/all";
	}

	@GetMapping("/reservas/update/{id}")
	public String showUpdateReservas(@PathVariable Long id, Model model) {
		model.addAttribute("reserva", reservaServicio.getReservas(id));
		return "Reservas/edit";
	}

	@PostMapping("/reservas/{id}")
	public String updateReservas(@PathVariable Long id, @ModelAttribute("reserva") Reservas reservas, Model modelo) {
		Reservas reservaExistente = reservaServicio.getReservas(id);
		reservaExistente.setId_reserva(id);
		reservaExistente.setProductos(reservas.getProductos());

		reservaServicio.updateReservas(reservaExistente);
		return "redirect:/reservas/all";
	}

	@GetMapping("/reservas/delete/{id}")
	public String deleteReservas(@PathVariable Long id) {
		reservaServicio.deleteReservas(id);
		return "redirect:/reservas/all";
	}
}
