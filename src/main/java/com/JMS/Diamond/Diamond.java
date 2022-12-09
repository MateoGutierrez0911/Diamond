package com.JMS.Diamond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.JMS.Diamond.modelo.Rol;
import com.JMS.Diamond.repositorio.RolRepository;

@SpringBootApplication
public class Diamond implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Diamond.class, args);
	}

	@Autowired
	public RolRepository repositorio;
	
	@Override
	public void run(String... args) throws Exception {
	/*	Rol rol1 = new Rol("lagos");
		repositorio.save(rol1);
		
		Rol rol2 = new Rol("rios");
		repositorio.save(rol2);
		*/
	}

}
