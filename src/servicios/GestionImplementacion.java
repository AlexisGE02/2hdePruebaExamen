package servicios;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import controladores.Inicio;
import entidades.Ventas;

public class GestionImplementacion {
	
	public void mostrarVentas() {
		
		//Limpiamos el buffer
	 	Inicio.sc.nextLine();
	 	//pedimos la fecha
		System.out.println("Introduzca la fecha del día que quiera mostrar siguiente forma: dd-MM-yyyy");
		String fechaString = Inicio.sc.nextLine();
		//Guardo el Formato
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		//Parseamos la fecha en un tipo de dato temporal
		LocalDate dia = LocalDate.parse(fechaString, formatoFecha);
		
		ArrayList<Ventas> listaVentasDia = new ArrayList<>();
		
		for(Ventas v: Inicio.listaVentas) {
			if(v.getFechaInstante().toLocalDate().isEqual(dia)) {
				listaVentasDia.add(v);
				System.out.println(v.toString());
			}
		}
		
		
	}

}
