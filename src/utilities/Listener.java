package utilities;

import java.util.Scanner;

/**
 * <h3>Listener</h3>
 * Clase para pedir datos introducidos por teclado.
 * @version 1.0
 * @since 28/08/2020
 * @author Christian
 */
public class Listener {

	/**
     * Crea un scanner para leer los datos introducidos por teclado
     * @return scanner Objeto scanner
     */
	private static Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	/**
     * Devuelve un int introducido por teclado
     * @return int Numero entero introducido por teclado
     */
	public static int getInt() {

		return getScanner().nextInt();
	}
	
	/**
     * Devuelve un int introducido por teclado mostrando un mensaje
     * @param message Mensaje para mostrar
     * @return int Numero entero introducido por teclado
     */
	public static int getInt(String message) {
		Messenger.printMessageConsole(message);
		return getInt();
	}
	
	/**
     * Devuelve un int introducido por teclado mostrando un mensaje y dados unos limites
     * @param message Mensaje para mostrar
     * @param lowerBound Numero minimo
     * @param upperBound Numero maximo
     * @return int Numero entero introducido por teclado
     */
	public static int getInt(String message, int lowerBound, int upperBound) {
		int i = 0;

		i = Listener.getInt(message);
		while(i < lowerBound || i > upperBound) {
			i = Listener.getInt("Numero fuera de limites, " + message);
		}
		
		return i;
	}
	
	/**
     * Devuelve un String introducido por teclado
     * @return String Cadena de texto introducida por teclado
     */
	public static String getString() {
		return getScanner().nextLine();
	}

	/**
     * Devuelve un String introducido por teclado mostrando un mensaje
     * @param message Mensaje para mostrar
     * @return String Cadena de texto introducida por teclado
     */
	public static String getString(String message) {
		Messenger.printMessageConsole(message);
		return getString();
	}

	/**
     * Devuelve un String introducido por teclado mostrando un mensaje y dadas dos opciones
     * @param message Mensaje para mostrar
     * @param trueOption Opcion para verdadero
     * @param falseOption Opcion para falso
     * @return response Respuesta bool decidida por el usuario
     */
	public static boolean getConditional(String message, String trueOption, String falseOption) {
		boolean response = true;
		trueOption = trueOption.toLowerCase();
		falseOption = falseOption.toLowerCase();
		
		String s = getString(message).toLowerCase();
		while(s != trueOption || s != falseOption) {
			s = getString("[Caracter no valido] " + message).toLowerCase();
		}
		
		if(s == falseOption)
			response = false;
		
		return response;
	}
	
}
