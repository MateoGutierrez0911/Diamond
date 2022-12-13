package com.JMS.Diamond.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Rol() {
		
	}



	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}

	
}
