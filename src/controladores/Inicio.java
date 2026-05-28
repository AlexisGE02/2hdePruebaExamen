package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Ventas;
import servicios.MenuImplementacion;

/** Clase ontroladora de la aplicación que maneja
 *  el flujo de los métodos principales de la aplicación
 * @author alexis
 * 
 */
public class Inicio {

	public static int idVentas = 0;
	public static Scanner sc = new Scanner(System.in);
	public static MenuImplementacion mi = new MenuImplementacion();
	public static ArrayList<Ventas> listaVentas = new ArrayList<>();
	/** Método pricipal con la estructura de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean esCerrado = false;
		byte opcion;
		do {
			mi.mostrarMenu();
			opcion = mi.recogerOpcion();
			esCerrado=mi.funcionarMenu(opcion);	
		}while (!esCerrado);
		
		sc.close();
	}

}
