package com.JMS.Diamond.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JMS.Diamond.modelo.Categorias;
import com.JMS.Diamond.repositorio.CategoriaRepositorio;

 



@Service
public class CategoriaServicioImp implements CategoriaServicio {


    @Autowired
    private CategoriaRepositorio repositorio;;

    @Override
	public List<Categorias> ListarCategorias() {
		return repositorio.findAll();
	}

    public Categorias saveCategoria(Categorias categoria) {
        return repositorio.save(categoria);
    }

    public Categorias getCategoria(Long id){
        return repositorio.findById(id).get();
    }

    public Categorias updateCategoria(Categorias categoria) {
        return repositorio.save(categoria);
    }

    public void deleteCategria(Long id){
    	repositorio.deleteById(id);
    }

	
}
