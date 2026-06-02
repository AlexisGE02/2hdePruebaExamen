package servicios;

import controladores.Inicio;

public class MenuEmpleadoImplementacion implements MenuInterfaz {
EmpleadoImplementacion ei = new EmpleadoImplementacion();
	@Override
	public void mostrarMenu() {
		// Menú Gestión
				System.out.println("Menú Empleado···············");
				System.out.println("Escoja una opción··········");
				System.out.println("1. Añadir Ventas····");
				System.out.println("2. Calcular Total Diario···");
				System.out.println("3. Volver al menú principal···");
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
			ei.aniadirVenta();
			break;
			
		case 2:
			ei.calculoVentasDiario();
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
