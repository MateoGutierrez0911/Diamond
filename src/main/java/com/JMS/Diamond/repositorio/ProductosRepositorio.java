package com.JMS.Diamond.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JMS.Diamond.modelo.Productos;

 

@Repository
public interface ProductosRepositorio extends JpaRepository<Productos,Long>{

}
