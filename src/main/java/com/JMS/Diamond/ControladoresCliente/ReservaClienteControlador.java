package com.JMS.Diamond.ControladoresCliente;

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
public class ReservaClienteControlador {

	

	@Autowired
	private ReservasServicioImp reservaServicio;
	
	@GetMapping(path = "/reservasCliente/all")
	public String getReservas(Model model) {
		model.addAttribute("reserva", reservaServicio.ListarReservas());
		return "dashboardCliente";
	}

	@GetMapping("/reservasCliente/new")
	public String showNewReservasModel(Model model) {
		model.addAttribute("reserva", new Reservas());
		return "Cliente/nuevaReserva";
	}

	@PostMapping("/reservasCliente/save")
	public String newReservas(@ModelAttribute("reserva") Reservas reservas) {
		reservaServicio.saveReservas(reservas);
		return "redirect:/reservasCliente/all";
	}


	
}
