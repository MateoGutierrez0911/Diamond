package com.JMS.Diamond.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JMS.Diamond.modelo.Productos;
import com.JMS.Diamond.repositorio.ProductosRepositorio;
 
 
 

@Service
public class ProductosServicioImp implements ProductosServicio{

	@Autowired
	private ProductosRepositorio repositorio;
	
	@Override
	public List<Productos> ListarProductos() {
		
		return repositorio.findAll() ;
	}
	

    public Productos saveProductos(Productos productos) {
        return repositorio.save(productos);
    }

    public Productos getProductos(Long id){
        return repositorio.findById(id).get();
    }

    public Productos updateProductos(Productos productos) {
        return repositorio.save(productos);
    }

    public void deleteProductos(Long id){
    	repositorio.deleteById(id);
    }


}
