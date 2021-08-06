package gui;

import model.Game;
import java.util.List;

public class MenuViews {
	
	public static void showMainMenu() {
		System.out.println("Elige una opción y pulsa enter: ");
		System.out.println("1. Mostrar lista de juegos completa");
		System.out.println("2. Mostrar lista de juegos por género");
		System.out.println("3. Mostrar lista de juegos por fecha");
		System.out.println("4. Mostrar lista de juegos por consola");
		System.out.println("5. Mostrar lista de juegos de Nintendo");
		System.out.println("6. Mostrar creadores de juegos");
		System.out.println("0. Salir");
	}
	
	public static void showGamesList(List<Game> games) {
		
		int i = 1;
		for(Game game : games) {
			System.out.println(i+". "+game.toString());
		}
	}
	
	/*
	 * 0. menu inicial
	 * 1. lista de juegos completa
	 * 2. por genero (elegir genero)
	 * 3. por fecha (introducir fecha. opción even)
	 * 4. lista de creadores
	 * 5. por consola (elegir consola)
	 * */

}
