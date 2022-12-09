package com.JMS.Diamond.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JMS.Diamond.modelo.Reservas;

 

@Repository
public interface ReservasRepositorio extends JpaRepository<Reservas, Long>{

}
