package com.JMS.Diamond.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JMS.Diamond.modelo.Ventas;
import com.JMS.Diamond.repositorio.VentasRepositorio;




@Service
public class VentasServicioImp implements VentasServicio{

	
	@Autowired
	private VentasRepositorio repositorio;
	
	@Override
	public List<Ventas> ListarVentas() {
		
		return repositorio.findAll();
	}


    public Ventas saveVentas(Ventas ventas) {
        return repositorio.save(ventas);
    }

    public Ventas getVentas(Long id){
        return repositorio.findById(id).get();
    }

    public Ventas updateVentas(Ventas ventas) {
        return repositorio.save(ventas);
    }

    public void deleteVentas(Long id){
    	repositorio.deleteById(id);
    }

}
