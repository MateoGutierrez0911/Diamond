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
@Table(name="reserva")
public class Reservas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_reserva;
    
    @Column (name = "cantidad")
    private int cantidad;
    
   
    @Column(name = "fecha_reserva")
    private String fechaVenta;
    
    @Column(name = "hora_reserva")
    private String horaVenta;
    
    @Column(name = "valorTotal_reserva")
    private double valorTotalVenta;
    
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Productos productos;
  

    
    public Reservas() {
		
	}

    

	public Reservas(Long id_reserva, int cantidad, String fechaVenta, String horaVenta, double valorTotalVenta,
			String direccion, Productos productos) {
		super();
		this.id_reserva = id_reserva;
		this.cantidad = cantidad;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.valorTotalVenta = valorTotalVenta;
		this.direccion = direccion;
		this.productos = productos;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}


    
    
	
}
