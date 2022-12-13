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

import com.JMS.Diamond.Reportes.ReservasExportarEXCEL;
import com.JMS.Diamond.Reportes.ReservasExportarPDF;
import com.JMS.Diamond.Reportes.VentasExportarEXCEL;
import com.JMS.Diamond.Reportes.VentasExportarPDF;
import com.JMS.Diamond.modelo.Reservas;
import com.JMS.Diamond.modelo.Ventas;
import com.JMS.Diamond.servicio.VentasServicioImp;
import com.lowagie.text.DocumentException;

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
	public String newVentas(@ModelAttribute("venta") Ventas ventas) {
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

		ventasServicio.updateVentas(ventaExistente);
		return "redirect:/ventas/all";
	}

	@GetMapping("/ventas/delete/{id}")
	public String deleteVentas(@PathVariable Long id) {
		ventasServicio.deleteVentas(id);
		return "redirect:/ventas/all";
	}
	
	
	
	

	@GetMapping("/exportarVentasPDF")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Ventas> ventas = ventasServicio.ListarVentas();
		
		VentasExportarPDF exporter = new VentasExportarPDF(ventas);
		exporter.exportar(response);
	}
	

	@GetMapping("/exportarVentasExcel")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Ventas> ventas = ventasServicio.ListarVentas();
		
		VentasExportarEXCEL exporter = new VentasExportarEXCEL(ventas);
		exporter.exportar(response);
	}
	
}
