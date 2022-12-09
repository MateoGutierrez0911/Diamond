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
    private String descripccionCategoria;
    
    @Column(name = "tipo_categoria")
    private String tipoCategoria;
    

  
    public Categorias() {
		// TODO Auto-generated constructor stub
	}



	public Categorias(Long id_categoria, String nombre_cate, String descripccionCategoria, String tipoCategoria) {
		super();
		this.id_categoria = id_categoria;
		this.nombre_cate = nombre_cate;
		this.descripccionCategoria = descripccionCategoria;
		this.tipoCategoria = tipoCategoria;
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



	public String getDescripccionCategoria() {
		return descripccionCategoria;
	}



	public void setDescripccionCategoria(String descripccionCategoria) {
		this.descripccionCategoria = descripccionCategoria;
	}



	public String getTipoCategoria() {
		return tipoCategoria;
	}



	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}


    
}
