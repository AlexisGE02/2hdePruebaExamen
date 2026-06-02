package servicios;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import controladores.Inicio;
import entidades.Producto;
import entidades.Ventas;

public class GestionImplementacion {
	/**
	 * Muestra las ventas de un dia pidiendo la fecha del mismo y las muestra en un listado.
	 * Luego guarda un archivo de texto nombrado con la fecha del día, con el listado de todas las ventas en ese dia.
	 * @author garci
	 */
	
	public void filtrarVentas() {
		System.out.println("¿Cómo desea ordenar sus ventas?");
		System.out.println("1. Desde la primera del dia a la última");
		System.out.println("2. Desde la última del dia a la primera");
		System.out.println("3. De menor a mayor importe");
		System.out.println("4. De mayor a menor importe");
		Byte opcion = Inicio.sc.nextByte();
		ArrayList<Ventas> ventasOrdenada= new ArrayList<>(Inicio.listaVentas);
		switch(opcion) {
		case 1:
			ventasOrdenada.sort(Comparator.comparing(Ventas::getFechaInstante));
			for (Ventas v:ventasOrdenada)	{
				System.out.println(v.toString());
			}
			break;
		case 2:
			ventasOrdenada.sort(Comparator.comparing(Ventas::getFechaInstante));
			for (Ventas v:ventasOrdenada.reversed())	{
				System.out.println(v.toString());
			}
			break;
		case 3:
			ventasOrdenada.sort(Comparator.comparing(Ventas::getImporte));
			for (Ventas v:ventasOrdenada)	{
				System.out.println(v.toString());
			}
			break;
		case 4:
			ventasOrdenada.sort(Comparator.comparing(Ventas::getImporte));
			for (Ventas v:ventasOrdenada.reversed())	{
				System.out.println(v.toString());
			}
			break;
			default:
				System.out.println("Opción no válida");
				
		
		}
		//Inicio.listaVentas
	}
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
		DateTimeFormatter formatoNombreFichero = DateTimeFormatter.ofPattern("ddMMyyyy");
		String fechaNombreFichero = dia.format(formatoNombreFichero);
		Path ruta = Path.of("ficheros",fechaNombreFichero+".txt");
		ArrayList<String> listaVentasDia = new ArrayList<>();
		
		for(Ventas v: Inicio.listaVentas) {
			if(v.getFechaInstante().toLocalDate().isEqual(dia)) {
				listaVentasDia.add(v.toString());
				System.out.println(v.toString());
				
				try {
					Files.write(ruta,listaVentasDia);
					System.out.println("Ventas guardadas correctamente en "+ fechaNombreFichero);
				}catch(IOException e) {
					System.out.println("No se ha podido crear correctamente el fichero para guardar las ventas");
				}
			}else {
				System.out.println("No hay ninguna venta registrada ese dia");
			}
		}
		
		
		
	}
	/**
	 * Se pide el nombre, la cantidad, y la fecha de un producto de forma cíclica hasta que el usuario
	 * indique que no quiere añadir más productos
	 * Luego se muestra por pantalla el pedido entero en un listado de los productos, la cantidad y la fecha de entrega.
	 * @author garci
	 */
	public void crearPedido() {
		boolean haTerminado = false;
		boolean haRespondidoBien = false;
		ArrayList<Producto> pedido = new ArrayList<>();
		do {
			
		Producto productoPedido = new Producto();
		Inicio.sc.nextLine();
		System.out.println("Indique el nombre del producto que quiere añadir al pedido");
		String nombre = Inicio.sc.nextLine();
		productoPedido.setNombre(nombre);
		System.out.println("¿Qué cantidad desea añadir?");
		int cantidad = Inicio.sc.nextInt();
		productoPedido.setCantidad(cantidad);
		Inicio.sc.nextLine();
		System.out.println("¿En qué fecha desea recibir el producto? (Debe introducir la fecha de esta forma: dd-MM-yyyy");
		String fecha = Inicio.sc.nextLine();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaEntrega = LocalDate.parse(fecha, formato);
		productoPedido.setFechaDeEntrega(fechaEntrega);
		pedido.add(productoPedido);
			do {
				
			
			System.out.println("¿Desea añadir algún producto más? s/n");
			String respuesta = Inicio.sc.next();
			
			switch(respuesta) {
			case "s":
				haRespondidoBien = true;
				break;
			case "n":
				haRespondidoBien = true;
				haTerminado= true;
				break;
				default:
					System.out.println("Solo puede responder 's' o 'n'");
			}
			}while(!haRespondidoBien);
			
		}while(!haTerminado);
		
		for (Producto p: pedido) {
			System.out.println(p.toString());
		}
	
		}
	/**
	 * Carga los datos en un fichero con el nombre Ventas para que los datos persistan en la app
	 */
	public void cargarDatos() {
		ArrayList<String> listaVentas = new ArrayList<>();
		for (Ventas v : Inicio.listaVentas) {
			String datosVenta = v.datosAString();
			listaVentas.add(datosVenta);
		}
		
		Path ruta = Path.of("ficheros", "Ventas.txt");
		try {
			Files.write(ruta,listaVentas,StandardOpenOption.CREATE);
		}catch(IOException e) {
			System.out.println("No se ha encontrado la ruta para generar o escribir en el archivo");
		}
	}
	public void descargaDatos() {
		Path ruta = Path.of("ficheros", "Ventas.txt");
		ArrayList<String> datosFichero = new ArrayList<>();
		try {
			datosFichero.addAll(Files.readAllLines(ruta, StandardCharsets.UTF_8));
		}catch(IOException e) {
			System.out.println("No se ha encontrado la ruta para descargar los datos del archivo");
		}
		for(String v:datosFichero) {
			String importe = v.split(",")[1];
			Integer importeInt = Integer.parseInt(importe);
			String fechaInstanteStr = v.split(",")[2];
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
			LocalDateTime fechaInstante = LocalDateTime.parse(fechaInstanteStr, formato);
			Ventas nuevaVenta = new Ventas();
			nuevaVenta.setImporte(importeInt);
			nuevaVenta.setFechaInstante(fechaInstante);
			Inicio.listaVentas.add(nuevaVenta);
		}
	}
	}
