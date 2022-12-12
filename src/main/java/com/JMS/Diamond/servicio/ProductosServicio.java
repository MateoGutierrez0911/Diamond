package com.JMS.Diamond.servicio;

import java.util.List;

import com.JMS.Diamond.modelo.Productos;

 

public interface ProductosServicio {

	public List<Productos> ListarProductos();

	Productos findOne(Long id);

	void deleteProductos(Long id);

	Productos updateProductos(Productos productos);

	Productos saveProductos(Productos productos);

	public Productos FindByid(Long id);
}
