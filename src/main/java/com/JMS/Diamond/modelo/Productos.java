package com.JMS.Diamond.modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name ="productos")
public class Productos {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_producto")
	private Long id_producto;
	  
    @Column(name = "fecha_registro")
    private String fechaRegistro;
    
    @Column(name = "nombre_producto")
    private String nombreInsumo;
    
    @Column(name = "descripccion_producto")
    private String descripccionInsumo;
    
    @Column(name = "precio_producto")
    private int precioInsumo;
    
    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;
    
    @Column(name = "fechavencimiento_producto")
    private String fechaVencimientoInsumo;
	
	@ManyToOne
	@JoinColumn(name="id_categoria", referencedColumnName ="id_categoria")
	private Categorias categoria;
	
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}


	public Productos(Long id_producto, String fechaRegistro, String nombreInsumo, String descripccionInsumo,
			int precioInsumo, int cantidadDisponible, String fechaVencimientoInsumo, Categorias categoria) {
		super();
		this.id_producto = id_producto;
		this.fechaRegistro = fechaRegistro;
		this.nombreInsumo = nombreInsumo;
		this.descripccionInsumo = descripccionInsumo;
		this.precioInsumo = precioInsumo;
		this.cantidadDisponible = cantidadDisponible;
		this.fechaVencimientoInsumo = fechaVencimientoInsumo;
		this.categoria = categoria;
	}


	public Long getId_producto() {
		return id_producto;
	}


	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}


	public String getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public String getNombreInsumo() {
		return nombreInsumo;
	}


	public void setNombreInsumo(String nombreInsumo) {
		this.nombreInsumo = nombreInsumo;
	}


	public String getDescripccionInsumo() {
		return descripccionInsumo;
	}


	public void setDescripccionInsumo(String descripccionInsumo) {
		this.descripccionInsumo = descripccionInsumo;
	}


	public int getPrecioInsumo() {
		return precioInsumo;
	}


	public void setPrecioInsumo(int precioInsumo) {
		this.precioInsumo = precioInsumo;
	}


	public int getCantidadDisponible() {
		return cantidadDisponible;
	}


	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}


	public String getFechaVencimientoInsumo() {
		return fechaVencimientoInsumo;
	}


	public void setFechaVencimientoInsumo(String fechaVencimientoInsumo) {
		this.fechaVencimientoInsumo = fechaVencimientoInsumo;
	}


	public Categorias getCategoria() {
		return categoria;
	}


	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}


	 
}
