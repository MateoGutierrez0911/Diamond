package com.JMS.Diamond.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.JMS.Diamond.Reportes.ProductosExportarEXCEL;
import com.JMS.Diamond.Reportes.ProductosExportarPDF;
import com.JMS.Diamond.Reportes.ReservasExportarEXCEL;
import com.JMS.Diamond.Reportes.ReservasExportarPDF;
import com.JMS.Diamond.modelo.Productos;
import com.JMS.Diamond.modelo.Reservas;

import com.JMS.Diamond.servicio.ReservasServicioImp;
import com.lowagie.text.DocumentException;

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


		reservaServicio.updateReservas(reservaExistente);
		return "redirect:/reservas/all";
	}

	@GetMapping("/reservas/delete/{id}")
	public String deleteReservas(@PathVariable Long id) {
		reservaServicio.deleteReservas(id);
		return "redirect:/reservas/all";
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/exportarReservasPDF")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Reservas> reservas = reservaServicio.ListarReservas();
		
		ReservasExportarPDF exporter = new ReservasExportarPDF(reservas);
		exporter.exportar(response);
	}
	

	@GetMapping("/exportarReservasExcel")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Reservas> reservas = reservaServicio.ListarReservas();
		
		ReservasExportarEXCEL exporter = new ReservasExportarEXCEL(reservas);
		exporter.exportar(response);
	}
}
