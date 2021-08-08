package utilities;

/**
 * <h3>Messenger</h3>
 * Clase para imprimir mensajes por consola usando el metodo System.out.println
 * @version 1.0
 * @since 28/08/2020
 * @author Christian
 */
public class Messenger {

	/**
	 * Muestra un mensaje por pantalla
	 * @param <E> Cualquier tipo admitido
	 * @param message Mensaje para mostrar
	 */
	public static <E> void printMessageConsole(E message) {
		System.out.println(message.toString());
	}

}
