package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;

public class Producto {
	
	//Constructor
	public Producto() {
		super();
		this.id = Inicio.idProducto++;
	}
	
	//Atributos
	private int id;
	private String nombre;
	private int cantidad;
	private LocalDate fechaDeEntrega;
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public LocalDate getFechaDeEntrega() {
		return fechaDeEntrega;
	}
	public void setFechaDeEntrega(LocalDate fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
	}
	public int getId() {
		return id;
	}
	// ToString
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String instatanteEnFormato = fechaDeEntrega.format(formato);
		return ".......\nNombre del producto: " + nombre + "\nCantidad del producto " + cantidad + " euros\nFecha deseada de entrega: " + instatanteEnFormato;
	}
	
	
}

