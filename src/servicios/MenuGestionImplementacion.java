package servicios;

import controladores.Inicio;

public class MenuGestionImplementacion implements MenuInterfaz {

	@Override
	public void mostrarMenu() {
		// Menú Gestión
				System.out.println("Menú Gestión···············");
				System.out.println("Escoja una opción··········");
				System.out.println("1. Mostrar Ventas del Día··");
				System.out.println("2. Crear un nuevo Pedido···");
				System.out.println("3. Volver al menú principal");
			}


	@Override
	public byte recogerOpcion() {
		byte opcion = Inicio.sc.nextByte();
		return opcion;
	}

	@Override
	public boolean funcionarMenu(byte opcion) {
		boolean esCerrado = false;
		switch(opcion) {
		case 1:
			//Mostrar Ventas
			break;
				
		case 2:
			//Nuevo Pedido
			break;
			
		case 3:
			//Volver
			esCerrado=true;
			break;
			
			default:
				System.out.println("Opción no válida");
		}
		return esCerrado;
	}

}
