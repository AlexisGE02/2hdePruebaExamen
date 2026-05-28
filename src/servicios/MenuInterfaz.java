package servicios;

/**
 * Interfaz molde de las clases Menús que contiene los trés métodos precisados para la correcta implementación de estos
 */

public interface MenuInterfaz {

	/**
	 * Método que muestra las opciones disponibles por consola
	 * @author alexis
	 */
	public void mostrarMenu();
	/**
	 * Método que recoge la opción que el usuario ha introducido por consola, la recoge y devuelve como tipo byte
	 *
	 * @author alexis
	 * @return byte
	 */
	public byte recogerOpcion();
	/**
	 * Método que mediante la opción recogida del usuario actua llamando los métodos necesarios dentro de la opción qe el usuario ha elegido
	 * El método devuelve un condicional que para los casos de cierre del menú o de la aplicación será false
	 * @param opcion
	 * @return boolean
	 */
	public boolean funcionarMenu(byte opcion);
}
