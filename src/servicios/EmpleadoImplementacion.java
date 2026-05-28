package servicios;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import controladores.Inicio;
import entidades.Ventas;

public class EmpleadoImplementacion {
	
	public void aniadirVenta(){
		Inicio.sc.nextLine();
		System.out.println("Introduzca el importe de la venta realizada: ");
		int importe = Inicio.sc.nextInt();
		Ventas nuevaVenta = new Ventas();
		nuevaVenta.setImporte(importe);
		Inicio.listaVentas.add(nuevaVenta);
	}
 public void calculoVentasDiario() {
	 
	 	//Limpiamos el buffer
	 	Inicio.sc.nextLine();
	 	//pedimos la fecha
		System.out.println("Introduzca la fecha del día que quiera calcular de la siguiente forma: dd-MM-yyyy");
		String fechaString = Inicio.sc.nextLine();
		//Guardo el Formato
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		//Parseamos la fecha en un tipo de dato temporal
		LocalDate dia = LocalDate.parse(fechaString, formatoFecha);
		
		ArrayList<Ventas> listaVentasDia = new ArrayList<>();
		int total = 0;
		Duration duracion;
		
		
		for(Ventas v: Inicio.listaVentas) {
			if(v.getFechaInstante().toLocalDate().isEqual(dia)) {
				listaVentasDia.add(v);
				total +=v.getImporte();
			}
		}
		LocalDateTime primeraVenta= listaVentasDia.getFirst().getFechaInstante();
		LocalDateTime ultimaVenta= listaVentasDia.getLast().getFechaInstante();
		duracion= Duration.between(primeraVenta, ultimaVenta);
		
		int horas = duracion.toHoursPart();
		int minutos = duracion.toMinutesPart();
		int segundos = duracion.toSecondsPart();
		if(!listaVentasDia.isEmpty()) {
			 System.out.println("Total ventas: " + total + " euros");
		        System.out.println("Tiempo transcurrido: " + horas + " horas " + minutos + " minutos y " + segundos + " segundos");
		}else {
			System.out.println("No hay ventas registradas ese dia");
		}
		}
 }

