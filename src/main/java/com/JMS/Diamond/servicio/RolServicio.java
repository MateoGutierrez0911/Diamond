package com.JMS.Diamond.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JMS.Diamond.modelo.Rol;
import com.JMS.Diamond.repositorio.RolRepository;

@Service
public class RolServicio implements RolService{


    @Autowired
    private RolRepository rolRepository;

    @Override
	public List<Rol> ListarRoles() {
		return rolRepository.findAll();
	}

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol getRoles(Long id){
        return rolRepository.findById(id).get();
    }

    public Rol updateRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteRol(Long id){
    	rolRepository.deleteById(id);
    }

	
}
