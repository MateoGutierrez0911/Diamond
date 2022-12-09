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
@Table(name="reserva")
public class Reservas implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id_reserva;
    
    @Column (name = "cantidad")
    private int cantidad;
    
   
    @Column(name = "fecha_reserva")
    private String fechaVenta;
    
    @Column(name = "hora_reserva")
    private String horaVenta;
    
    @Column(name = "valorTotal_reserva")
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
    
    public Reservas() {
		
	}

	public Reservas(Long id_reserva, int cantidad, String fechaVenta, String horaVenta, double valorTotalVenta,
			Categorias categoria, Productos productos, Usuario usuario) {
		super();
		this.id_reserva = id_reserva;
		this.cantidad = cantidad;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.valorTotalVenta = valorTotalVenta;
		this.categoria = categoria;
		this.productos = productos;
		this.usuario = usuario;
	}

	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
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

	public void setUsuarios(Usuario usuarios) {
		this.usuario = usuarios;
	}

	
}
