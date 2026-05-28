package servicios;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz{
 MenuGestionImplementacion mgi = new MenuGestionImplementacion();
 MenuEmpresarioImplementacion mei = new MenuEmpresarioImplementacion();
	@Override
	public void mostrarMenu() {
		// Menú principal
		System.out.println("Menú Principal·····");
		System.out.println("Escoja una opción··");
		System.out.println("1. Menú Gestión····");
		System.out.println("2. Menú Empleados··");
		System.out.println("3. Cerrar app······");
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
		
		case 1: //menú gestion
			boolean esCerrado1=false;
			do{
				mgi.mostrarMenu();
				byte opcion1=mgi.recogerOpcion();
				esCerrado1=mgi.funcionarMenu(opcion1);
			}while(!esCerrado1);
			break;
			
		case 2: //menú empleado
			boolean esCerrado2=false;
			do{
				mei.mostrarMenu();
				byte opcion1=mei.recogerOpcion();
				esCerrado2=mei.funcionarMenu(opcion1);
			}while(!esCerrado2);
			break;
			
		case 3: //Cerrar app
			esCerrado=true;
			break;
		default:
			System.out.println("Opcion no válida prueve de nuevo");
			
		}
		return esCerrado;
	}

}
