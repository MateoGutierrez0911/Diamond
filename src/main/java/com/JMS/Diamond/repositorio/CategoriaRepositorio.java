package com.JMS.Diamond.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JMS.Diamond.modelo.Categorias;
 

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categorias, Long> {

}
