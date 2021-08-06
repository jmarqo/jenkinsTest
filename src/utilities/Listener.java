package utilities;

import java.util.Scanner;

public class Listener {

	/**
     * Devuelve el Scanner para acceder a inputs por teclado
     */
	private static Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	/**
     * Devuelve un int introducido por teclado
     */
	public static int getInt() {

		return getScanner().nextInt();
	}
	
	/**
     * Devuelve un int introducido por teclado mostrando un mensaje
     * @param message Mensaje para mostrar
     */
	public static int getInt(String message) {
		Messenger.showSysout(message);
		return getInt();
	}
	
	/**
     * Devuelve un int introducido por teclado mostrando un mensaje y dados unos limites
     * @param message Mensaje para mostrar
     * @param lowerBound Numero minimo
     * @param upperBound Numero maximo
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
     */
	public static String getString() {
		return getScanner().nextLine();
	}

	/**
     * Devuelve un String introducido por teclado mostrando un mensaje
     * @param message Mensaje para mostrar
     */
	public static String getString(String message) {
		Messenger.showSysout(message);
		return getString();
	}

	/**
     * Devuelve un String introducido por teclado mostrando un mensaje y dadas dos opciones
     * @param message Mensaje para mostrar
     * @param trueOption Opcion para verdadero
     * @param falseOption Opcion para falso
     */
	public static boolean getConditional(String message, String trueOption, String falseOption) {
		boolean r= true;
		trueOption = trueOption.toLowerCase();
		falseOption = falseOption.toLowerCase();
		
		String s = getString(message).toLowerCase();
		while(s != trueOption || s != falseOption) {
			s = getString("[Caracter no valido] " + message).toLowerCase();
		}
		
		if(s == falseOption)
			r = false;
		
		return r;
	}
	
}
