package com.JMS.Diamond.modelo;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name ="categoria")
public class Categorias  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id_categoria;
    
    @Column(name = "nombre_cate")
    private String nombre_cate;
    
    @Column(name = "descripccion_cate")
    private String descripcion_categoria;
    
    @Column(name = "tipo_categoria")
    private String tipo_categoria;
    

  
    public Categorias() {
		// TODO Auto-generated constructor stub
	}



	public Categorias(Long id_categoria, String nombre_cate, String descripcion_categoria, String tipo_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nombre_cate = nombre_cate;
		this.descripcion_categoria = descripcion_categoria;
		this.tipo_categoria = tipo_categoria;
	}



	public Long getId_categoria() {
		return id_categoria;
	}



	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}



	public String getNombre_cate() {
		return nombre_cate;
	}



	public void setNombre_cate(String nombre_cate) {
		this.nombre_cate = nombre_cate;
	}



	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}



	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}



	public String getTipo_categoria() {
		return tipo_categoria;
	}



	public void setTipo_categoria(String tipo_categoria) {
		this.tipo_categoria = tipo_categoria;
	}





    
}
