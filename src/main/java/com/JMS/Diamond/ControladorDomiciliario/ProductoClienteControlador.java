package com.JMS.Diamond.ControladorDomiciliario;

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
public class ProductoClienteControlador {

	
	@Autowired
	private ProductosServicioImp productoServicio;
	

	@GetMapping(path = "/productosCliente/all")
	public String getproductos(Model model) {
		List<Productos> productos = productoServicio.ListarProductos();
		model.addAttribute("producto", productoServicio.ListarProductos());
		return "Cliente/productosall";
	}



	
	
	
}
