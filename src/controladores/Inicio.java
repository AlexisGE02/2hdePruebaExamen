package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Ventas;
import servicios.GestionImplementacion;
import servicios.MenuImplementacion;

/** Clase ontroladora de la aplicación que maneja
 *  el flujo de los métodos principales de la aplicación
 * @author alexis
 * 
 */
public class Inicio {

	public static int idVentas = 0;
	public static int idProducto = 0;
	public static Scanner sc = new Scanner(System.in);
	public static MenuImplementacion mi = new MenuImplementacion();
	public static ArrayList<Ventas> listaVentas = new ArrayList<>();
	
	/** Método pricipal con la estructura de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Descarga de datos
		GestionImplementacion gi = new GestionImplementacion();
		gi.descargaDatos();
		
		//Control principal de la app
		boolean esCerrado = false;
		byte opcion;
		do {
			mi.mostrarMenu();
			opcion = mi.recogerOpcion();
			esCerrado=mi.funcionarMenu(opcion);	
		}while (!esCerrado);
		
		//Carga de datos y cierre de Scanner
		gi.cargarDatos();
		sc.close();
	}
}

