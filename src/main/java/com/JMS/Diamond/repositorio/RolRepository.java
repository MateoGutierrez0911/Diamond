package com.JMS.Diamond.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolRepository extends JpaRepository<com.JMS.Diamond.modelo.Rol, Long>{
	

}
