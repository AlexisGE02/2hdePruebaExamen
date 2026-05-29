package servicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
		//Preparamos la fecha para el nombre del archivo
		DateTimeFormatter formatoNombreArchivo = DateTimeFormatter.ofPattern("ddMMyyyy");
		String fechaNombreArchivo = dia.format(formatoNombreArchivo);
		Path ruta = Path.of("ficheros",fechaNombreArchivo+".txt");
		ArrayList<String> listaVentasDia = new ArrayList<>();
		
		for(Ventas v: Inicio.listaVentas) {
			if(v.getFechaInstante().toLocalDate().isEqual(dia)) {
				listaVentasDia.add(v.toString());
				System.out.println(v.toString());
			}
		}
		try {
			Files.write(ruta,listaVentasDia);
		}catch(IOException e) {
			
		}
		
		
	}

}
