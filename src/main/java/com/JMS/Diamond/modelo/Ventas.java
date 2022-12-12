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
@Table(name ="venta")
public class Ventas {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_venta")
    private Long id_venta;

    @NotNull
    @DecimalMin(value="1")
    @Column (name = "cantidad")
    private int cantidad;
    
    @NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "fecha_reserva")
    private Date fechaVenta;
    
    
    @NotNull
    @Column(name = "hora_reserva")
    private String horaVenta;
    
    @NotNull
    @DecimalMin(value="1")
    @Column(name = "valorTotal_reserva")
    private double valorTotalVenta;
    
    @NotNull
    private String direccion;

    
  
    @NotNull
    private String nombre_producto;
   

    
	public Ventas() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ventas(Long id_venta, @NotNull @DecimalMin("1") int cantidad, @NotNull Date fechaVenta,
			@NotNull String horaVenta, @NotNull @DecimalMin("1") double valorTotalVenta, @NotNull String direccion,
			@NotNull String nombre_producto) {
		super();
		this.id_venta = id_venta;
		this.cantidad = cantidad;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.valorTotalVenta = valorTotalVenta;
		this.direccion = direccion;
		this.nombre_producto = nombre_producto;
	}



	public Long getId_venta() {
		return id_venta;
	}



	public void setId_venta(Long id_venta) {
		this.id_venta = id_venta;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public Date getFechaVenta() {
		return fechaVenta;
	}



	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}



	public String getHoraVenta() {
		return horaVenta;
	}



	public void setHoraVenta(String horaVenta) {
		this.horaVenta = horaVenta;
	}



	public double getValorTotalVenta() {
		return valorTotalVenta;
	}



	public void setValorTotalVenta(double valorTotalVenta) {
		this.valorTotalVenta = valorTotalVenta;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getNombre_producto() {
		return nombre_producto;
	}



	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}








	


	

	

}
