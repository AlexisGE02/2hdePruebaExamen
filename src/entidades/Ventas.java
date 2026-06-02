package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;


/** 
 * Esta clase representa la entidad ventas que tiene como atributos:
 * Un Id que se autoimplementa en el contructor;
 * Un importe que será introducido por el usuario
 * Y una fecha que recoge el instante exacto en el que se realiza dicha venta;
 * 
 * @author alexis
 */
public class Ventas {
	

	public Ventas() {
		super();
		this.id = Inicio.idVentas++;
	}
	
	// Atributos
	private int id;
	private int importe;
	private LocalDateTime fechaInstante;
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public LocalDateTime getFechaInstante() {
		return fechaInstante;
	}
	public void setFechaInstante(LocalDateTime fechaInstante) {
		this.fechaInstante = fechaInstante;
	}
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String instatanteEnFormato = fechaInstante.format(formato);
		return ".......\nVenta numero: " + id + "\nEuros: " + importe + " euros\nInstante de Compra: " + instatanteEnFormato;
	}
	
	public String datosAString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
		String instatanteEnFormato = fechaInstante.format(formato);
		return id+","+importe+","+instatanteEnFormato;
	}

}

