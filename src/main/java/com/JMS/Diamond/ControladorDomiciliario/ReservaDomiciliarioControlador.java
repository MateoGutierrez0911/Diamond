package com.JMS.Diamond.ControladorDomiciliario;

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
public class ReservaDomiciliarioControlador {

	

	@Autowired
	private ReservasServicioImp reservaServicio;
	
	@GetMapping(path = "/reservasDomiciliario/all")
	public String getReservas(Model model) {
		model.addAttribute("reserva", reservaServicio.ListarReservas());
		return "Domiciliario/Reservasall";
	}


	
}
