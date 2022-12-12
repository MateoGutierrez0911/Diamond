package com.JMS.Diamond.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EstilosControl {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/dashboardCliente")
	public String dashboardCliente() {
		return "dashboardCliente";
	}
	
	@GetMapping("/dashboardDomiciliario")
	public String dashboardDomiciliario() {
		return "dashboardDomiciliario";
	}
	
	

	@GetMapping("/userForm")
	public String userForm() {
		return "user-form/user-view";
	}
	

	@GetMapping("/Cliente/caballero")
	public String caballero() {
		return "Cliente/caballero";
	}
	@GetMapping("/Cliente/dama")
	public String dama() {
		return "Cliente/dama";
	}
	@GetMapping("/Cliente/niño")
	public String niño() {
		return "Cliente/niño";
	}
	@GetMapping("/Cliente/niña")
	public String niña() {
		return "Cliente/niña";
	}
	
	@GetMapping("/Cliente/compras")
	public String compras() {
		return "Cliente/compras";
	}
	
	@GetMapping("@{/cliente/all}")
	public String clientes() {
		return "Cliente/all";
	}
	@GetMapping("@{/cliente/new}")
	public String editarCliente() {
		return "Cliente/edit";
	}
	
	@GetMapping("/Roles/Rols")
	public String Roles() {
		return "Roles/Rols";
	}
	@PostMapping("@{/rol/new}")
	public String newRoles() {
		return "Roles/nuevoRol";
	}
	
	@GetMapping("@{/role/update/{id}")
	public String showUpdaterol() {
	return "Roles/Rols";
}
	@GetMapping("@{/role/delete/{id}")
	public String deleterol() {
	return "Roles/Rols";
}
	
	
	@GetMapping("/Operador/domicilio")
	public String domicilio() {
		return "Operador/domicilio";
	}
	@GetMapping("/Operador/agregarproducto")
	public String agregarproducto() {
		return "Operador/agregarproducto";
	}
	@GetMapping("/Operador/informe")
	public String informe() {
		return "Operador/informe";
	}
	@GetMapping("/Operador/asignarrepartidor")
	public String asignarrepartidor() {
		return "Operador/asignarrepartidor";
	}
	
	
	
	
	
	@GetMapping("/administrador")
	public String administrador() {
		return "admnistrador";
	}
	
	@GetMapping("/Administrador/vistaproduto")
	public String vistaproduto() {
		return "Administrador/vistaproduto";
	}
	
	@GetMapping("/Administrador/listaventas")
	public String listaventas() {
		return "Administrador/listaventas";
	}
	

	@GetMapping("/Administrador/addproducto")
	public String addproducto() {
		return "Administrador/addproducto";
	}

	
	
	
	

	
	@GetMapping("@{reservas/all}")
	public String listaReservas() {
		return "Reservas/all";
	}
	
	
	@GetMapping("@{reservas/new")
	public String nuevaReserva () {
	return "Reservas/new";
}
	
	
	@GetMapping("@{/reservas/delete/{id}")
	public String deleteReserva() {
	return "Reservas/all";
}
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("@{/ventas/all}")
	public String listaVentas() {
		return "Ventas/all";
	}
	
	
	@GetMapping("@{/ventas/new")
	public String nuevaVentas () {
	return "Ventas/new";
}
	
	
	@GetMapping("@{/ventas/delete/{id}")
	public String deleteVentas() {
	return "Ventas/all";
}
	
	
	
	
	
	
	
	
	
	@GetMapping("@{productos/all}")
	public String listaProducto() {
		return "Reservas/all";
	}
	
	
	@GetMapping("@{productos/new")
	public String nuevaProducto () {
	return "Reservas/new";
}
	
	
	@GetMapping("@{/productos/delete/{id}")
	public String deleteProducto() {
	return "Reservas/all";
}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("@{categorias/all}")
	public String listaCategoria() {
		return "Categorias/all";
	}
	@GetMapping("@{/categorias/delete/{id}")
	public String deleteCategoria() {
	return "Categorias/all";
}
	@GetMapping("@{categorias/new")
	public String nuevaCategoria () {
	return "Categorias/new";
}
	
	
	
	
	
	@GetMapping("@{/productosCliente/all}")
	public String listasprod() {
		return "Cliente/productosall";
	}
	
	@GetMapping("/nosotros")
	public String Nosotros() {
		return "Cliente/nosotros";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}