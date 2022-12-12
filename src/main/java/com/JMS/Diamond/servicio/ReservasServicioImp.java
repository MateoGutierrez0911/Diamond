package com.JMS.Diamond.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JMS.Diamond.modelo.Reservas;
import com.JMS.Diamond.repositorio.ReservasRepositorio;

 

@Service
public class ReservasServicioImp implements ReservasServicio{
	
	@Autowired
	private ReservasRepositorio repositorio;

	@Override
	public List<Reservas> ListarReservas() {
		
		return (List<Reservas>) repositorio.findAll();
	}
	

    public Reservas saveReservas(Reservas reservas) {
        return repositorio.save(reservas);
    }

    public Reservas getReservas(Long id){
        return repositorio.findById(id).get();
    }

    public Reservas updateReservas(Reservas reservas) {
        return repositorio.save(reservas);
    }

    public void deleteReservas(Long id){
    	repositorio.deleteById(id);
    }

	
	

}
