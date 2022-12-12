package com.JMS.Diamond.modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="productos")
public class Productos {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_producto")
	private Long id_producto;
	 
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
	
	
    @NotNull
    @Column(name = "nombre_producto")
    private String nombreInsumo;
    @NotNull
    
    @NotNull 
    @Column(name = "descripccion_producto")
    private String descripccionInsumo;
    
    @NotNull
    @DecimalMin(value="1")
    @Column(name = "precio_producto" )
    private int precioInsumo;
    
    @NotNull
    @DecimalMin(value="1")
    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;
    
    @NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechavencimiento_producto")
    private Date fechaVencimientoInsumo;
	

	
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}




	public Productos(Long id_producto, @NotNull Date fechaRegistro, String nombreInsumo, String descripccionInsumo,
			@DecimalMin("1") int precioInsumo, int cantidadDisponible, @NotNull Date fechaVencimientoInsumo) {
		super();
		this.id_producto = id_producto;
		this.fechaRegistro = fechaRegistro;
		this.nombreInsumo = nombreInsumo;
		this.descripccionInsumo = descripccionInsumo;
		this.precioInsumo = precioInsumo;
		this.cantidadDisponible = cantidadDisponible;
		this.fechaVencimientoInsumo = fechaVencimientoInsumo;
	}







	public Long getId_producto() {
		return id_producto;
	}


	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}




	public Date getFechaRegistro() {
		return fechaRegistro;
	}




	public void setFechaRegistro(Date fechaRegistro) {
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




	public Date getFechaVencimientoInsumo() {
		return fechaVencimientoInsumo;
	}


	public void setFechaVencimientoInsumo(Date fechaVencimientoInsumo) {
		this.fechaVencimientoInsumo = fechaVencimientoInsumo;
	}




	 
}
