package com.JMS.Diamond.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="venta")
public class Ventas implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_venta")
    private Long id_venta;
    
    @Column (name = "cantidad")
    private int cantidad;
    

    @Column(name = "fechaVenta")
    private String fechaVenta;
    
    @Column(name = "horaVenta")
    private String horaVenta;
    
    @Column(name = "valorTotalVenta")
    private double valorTotalVenta;
    
    
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categorias categoria;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Productos productos;
    
   
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Usuario usuario;
    

    
	public Ventas() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ventas(Long id_venta, int cantidad, String fechaVenta, String horaVenta, double valorTotalVenta,
			Categorias categoria, Productos productos, Usuario usuario) {
		super();
		this.id_venta = id_venta;
		this.cantidad = cantidad;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.valorTotalVenta = valorTotalVenta;
		this.categoria = categoria;
		this.productos = productos;
		this.usuario = usuario;
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



	public String getFechaVenta() {
		return fechaVenta;
	}



	public void setFechaVenta(String fechaVenta) {
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



	public Categorias getCategoria() {
		return categoria;
	}



	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}



	public Productos getProductos() {
		return productos;
	}



	public void setProductos(Productos productos) {
		this.productos = productos;
	}



	public Usuario getUsuarios() {
		return usuario;
	}



	public void setUsuarios(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
