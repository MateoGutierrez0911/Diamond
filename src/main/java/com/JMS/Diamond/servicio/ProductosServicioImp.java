package com.JMS.Diamond.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JMS.Diamond.modelo.Productos;
import com.JMS.Diamond.repositorio.ProductosRepositorio;

 
 

@Service
public class ProductosServicioImp implements ProductosServicio{

	@Autowired
	private ProductosRepositorio repositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Productos> ListarProductos() {
		return(List<Productos>) repositorio.findAll() ;
	}
	
    @Override

    public Productos saveProductos(Productos productos) {
        return repositorio.save(productos);
    }

    @Override

   public Productos FindByid(Long id) {
    	return repositorio.findById(id).get();
    }
   @Override

    public Productos updateProductos(Productos productos) {
        return repositorio.save(productos);
    }
    @Override

    public void deleteProductos(Long id){
    	repositorio.deleteById(id);
    }

    @Override
	@Transactional(readOnly = true)
	public Productos findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}

}
